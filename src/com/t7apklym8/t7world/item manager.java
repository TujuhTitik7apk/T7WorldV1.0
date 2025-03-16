package com.t7apklym8.t7world;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ItemManager {
    private JSONArray itemsData;

    public ItemManager(Context context) {
        try {
            InputStream inputStream = context.getAssets().open("items/item.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            String json = new String(buffer, StandardCharsets.UTF_8);
            JSONObject jsonObject = new JSONObject(json);
            itemsData = jsonObject.getJSONArray("items");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JSONObject getItem(int itemId) {
        try {
            for (int i = 0; i < itemsData.length(); i++) {
                JSONObject item = itemsData.getJSONObject(i);
                if (item.getInt("id") == itemId) {
                    return item;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}