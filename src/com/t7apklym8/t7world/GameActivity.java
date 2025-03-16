package com.t7apklym8.t7world;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {

    private ImageView avatarView;
    private TextView welcomeText;

    private LanguageManager languageManager;
    private GameManager gameManager;
    private GameEngine gameEngine;
    private NPCDialogManager npcDialogManager;

    private int[] avatars = {
            R.drawable.avatar_child_male,
            R.drawable.avatar_child_female,
            R.drawable.avatar_teen_male,
            R.drawable.avatar_teen_female,
            R.drawable.avatar_adult_male,
            R.drawable.avatar_adult_female
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        avatarView = findViewById(R.id.avatarView);
        welcomeText = findViewById(R.id.welcomeText);

        languageManager = new LanguageManager(this);
        gameManager = new GameManager(this);
        gameEngine = GameEngine.getInstance(this);
        npcDialogManager = new NPCDialogManager(this); // ✅ Tambahkan NPC Dialog Manager

        // Ambil avatar yang dipilih dari SharedPreferences
        SharedPreferences prefs = getSharedPreferences("AvatarPrefs", MODE_PRIVATE);
        int avatarIndex = prefs.getInt("selected_avatar", 0);
        avatarView.setImageResource(avatars[avatarIndex]);

        // Tampilkan teks sesuai bahasa yang dipilih
        String selectedLanguage = prefs.getString("selected_language", "id");
        welcomeText.setText(languageManager.getString("welcome_message", selectedLanguage));

        // Load data game dari JSON
        gameManager.loadGameData(this);

        // Sinkronisasi data player ke Firebase
        gameEngine.savePlayerData();

        // ✅ Load NPC Dialog
        String npcDialog = npcDialogManager.getNPCDialog(1, selectedLanguage);
        welcomeText.setText(npcDialog); // Tampilkan Dialog NPC
    }
}