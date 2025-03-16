package com.t7apklym8.t7world;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ShopManager {

    private List<ShopItem> shopItems = new ArrayList<>();

    public ShopManager(Context context) {
        loadShopData(context);
    }

    private void loadShopData(Context context) {
        try {
            InputStream inputStream = context.getAssets().open("shop/shop_data.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();

            String json = new String(buffer, StandardCharsets.UTF_8);
            JSONObject jsonObject = new JSONObject(json);
            JSONArray itemsArray = jsonObject.getJSONArray("items");

            for (int i = 0; i < itemsArray.length(); i++) {
                JSONObject itemObject = itemsArray.getJSONObject(i);
                ShopItem item = new ShopItem(
                        itemObject.getInt("id"),
                        itemObject.getString("name"),
                        itemObject.getInt("price"),
                        itemObject.getString("type")
                );
                shopItems.add(item);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ShopItem> getAllItems() {
        return shopItems;
    }
}