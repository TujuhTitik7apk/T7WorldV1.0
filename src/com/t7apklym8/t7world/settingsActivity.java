package com.t7apklym8.t7world;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    private String[] languageCodes = {"id", "jv", "ja", "en", "zh"};
    private LanguageManager languageManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        languageManager = new LanguageManager(this);

        // Ambil data dari Spinner
        Spinner languageSpinner = findViewById(R.id.languageSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.languages_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languageSpinner.setAdapter(adapter);

        // Load bahasa sebelumnya yang dipilih
        SharedPreferences prefs = getSharedPreferences("LanguagePrefs", MODE_PRIVATE);
        int savedLanguageIndex = prefs.getInt("selected_language_index", 0);
        languageSpinner.setSelection(savedLanguageIndex);

        // Saat bahasa dipilih
        languageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, android.view.View view, int position, long id) {
                changeLanguage(languageCodes[position]);
                saveLanguagePreference(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void changeLanguage(String langCode) {
        languageManager.setLocale(langCode);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish(); // Restart agar bahasa berubah
    }

    private void saveLanguagePreference(int index) {
        SharedPreferences.Editor editor = getSharedPreferences("LanguagePrefs", MODE_PRIVATE).edit();
        editor.putInt("selected_language_index", index);
        editor.apply();
    }
}