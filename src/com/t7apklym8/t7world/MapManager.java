package com.t7apklym8.t7world;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class MapManager {
    private JSONArray mapData;

    public MapManager(Context context) {
        try {
            InputStream inputStream = context.getAssets().open("maps/map.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            String json = new String(buffer, StandardCharsets.UTF_8);
            JSONObject jsonObject = new JSONObject(json);
            mapData = jsonObject.getJSONArray("maps");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JSONObject getMap(int mapId) {
        try {
            for (int i = 0; i < mapData.length(); i++) {
                JSONObject map = mapData.getJSONObject(i);
                if (map.getInt("id") == mapId) {
                    return map;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}