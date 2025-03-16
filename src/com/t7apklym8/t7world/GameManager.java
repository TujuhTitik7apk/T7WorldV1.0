package com.t7apklym8.t7world;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class GameManager {

    private int health;
    private int stamina;
    private int level;
    private int experience;
    private String currentLocation;
    private JSONArray items;

    public GameManager(Context context) {
        loadGameData(context);
    }

    public void loadGameData(Context context) {
        try {
            InputStream inputStream = context.getAssets().open("game/game_data.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();

            String json = new String(buffer, StandardCharsets.UTF_8);
            JSONObject jsonObject = new JSONObject(json);

            JSONObject player = jsonObject.getJSONObject("player");
            health = player.getInt("health");
            stamina = player.getInt("stamina");
            level = player.getInt("level");
            experience = player.getInt("experience");

            JSONObject world = jsonObject.getJSONObject("world");
            currentLocation = world.getString("current_location");

            items = jsonObject.getJSONArray("quests");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getHealth() { return health; }
    public int getStamina() { return stamina; }
    public int getLevel() { return level; }
    public int getExperience() { return experience; }
    public String getCurrentLocation() { return currentLocation; }
}