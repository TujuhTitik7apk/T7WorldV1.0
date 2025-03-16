package com.t7apklym8.t7world;

import android.content.Context;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GameEngine {

    private static final String TAG = "GameEngine";
    private static GameEngine instance;
    private DatabaseReference databaseRef;

    public Player player;
    public Kultivasi kultivasi;
    public TimeSystem timeSystem;
    public WeatherSystem weatherSystem;

    private GameEngine(Context context) {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        databaseRef = firebaseDatabase.getReference("GameData");

        player = new Player();
        kultivasi = new Kultivasi();
        timeSystem = new TimeSystem();
        weatherSystem = new WeatherSystem();
    }

    public static synchronized GameEngine getInstance(Context context) {
        if (instance == null) {
            instance = new GameEngine(context);
        }
        return instance;
    }

    public void savePlayerData() {
        if (player != null) {
            databaseRef.child("players").child(player.getPlayerID()).setValue(player)
                    .addOnSuccessListener(aVoid -> Log.d(TAG, "Data Player Berhasil Disimpan!"))
                    .addOnFailureListener(e -> Log.e(TAG, "Gagal Menyimpan Data Player: ", e));
        }
    }

    public void updateTimeAndWeather() {
        timeSystem.updateTime();
        weatherSystem.updateWeather();
    }
}