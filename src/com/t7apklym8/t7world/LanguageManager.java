package com.t7apklym8.t7world;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

import org.json.JSONObject;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class LanguageManager {
    private Context context;
    private JSONObject languageData;

    public LanguageManager(Context context) {
        this.context = context;
        loadLanguageData();
    }

    // Load JSON Language
    private void loadLanguageData() {
        try {
            InputStream inputStream = context.getAssets().open("language.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            String json = new String(buffer, StandardCharsets.UTF_8);
            languageData = new JSONObject(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Ambil teks berdasarkan bahasa
    public String getString(String key, String langCode) {
        try {
            JSONObject translations = languageData.getJSONObject("translations");
            JSONObject selectedLanguage = translations.getJSONObject(langCode);
            return selectedLanguage.getString(key);
        } catch (Exception e) {
            e.printStackTrace();
            return key; // Default jika tidak ditemukan
        }
    }

    // Ambil nama bahasa berdasarkan kode bahasa
    public String getLanguageName(String langCode) {
        try {
            for (int i = 0; i < languageData.getJSONArray("languages").length(); i++) {
                JSONObject language = languageData.getJSONArray("languages").getJSONObject(i);
                if (language.getString("code").equals(langCode)) {
                    return language.getString("name");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return langCode; // Default jika tidak ditemukan
    }

    // Ubah Locale Bahasa (Langsung Restart Activity)
    public void setLocale(String langCode) {
        Locale locale = new Locale(langCode);
        Locale.setDefault(locale);
        Resources resources = context.getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale);
        resources.updateConfiguration(config, resources.getDisplayMetrics());
    }
}