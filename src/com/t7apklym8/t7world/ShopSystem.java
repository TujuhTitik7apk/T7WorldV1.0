package com.t7apklym8.t7world;

import java.util.HashMap;
import java.util.Map;

public class ShopSystem {

    private Map<String, Integer> itemPrice;

    public ShopSystem() {
        itemPrice = new HashMap<>();
        initShopItems();
    }

    // Inisialisasi daftar item di toko
    private void initShopItems() {
        itemPrice.put("Pedang Legendaris", 1000);
        itemPrice.put("Potion Energi", 200);
        itemPrice.put("Item Bertapa", 500);
    }

    // Membeli item jika gold mencukupi
    public boolean buyItem(Player player, String itemName) {
        if (itemPrice.containsKey(itemName)) {
            int price = itemPrice.get(itemName);
            if (player.getGold() >= price) {
                player.setGold(player.getGold() - price);
                return true; // Berhasil membeli
            }
        }
        return false; // Gagal membeli
    }

    // Mendapatkan harga item
    public int getItemPrice(String itemName) {
        return itemPrice.getOrDefault(itemName, -1);
    }

    // Daftar semua item di toko
    public Map<String, Integer> getAllItems() {
        return itemPrice;
    }
}