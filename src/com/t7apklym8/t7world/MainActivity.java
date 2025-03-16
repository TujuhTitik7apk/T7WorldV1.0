package com.t7apklym8.t7world;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private LanguageManager languageManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi Language Manager
        languageManager = new LanguageManager(this);

        // Set Welcome Text sesuai bahasa yang dipilih
        TextView welcomeText = findViewById(R.id.txt_welcome);
        welcomeText.setText(languageManager.getString("welcome_message", "id")); // Default: Bahasa Indonesia

        // Tombol Start Game
        Button btnStartGame = findViewById(R.id.btn_start_game);
        btnStartGame.setOnClickListener(v -> startGame());

        // Tombol Settings
        Button btnSettings = findViewById(R.id.btn_settings);
        btnSettings.setOnClickListener(v -> openSettings());

        // Tombol Exit
        Button btnExit = findViewById(R.id.btn_exit);
        btnExit.setOnClickListener(v -> finish());
    }

    private void startGame() {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    private void openSettings() {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}