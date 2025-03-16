package com.t7apklym8.t7world;

import java.util.HashMap;
import java.util.Map;

public class QuestSystem {

    private Map<String, Boolean> questProgress;

    public QuestSystem() {
        questProgress = new HashMap<>();
        initQuests();
    }

    // Inisialisasi daftar misi
    private void initQuests() {
        questProgress.put("Kalahkan Boss Hutan", false);
        questProgress.put("Temukan Item Bertapa", false);
        questProgress.put("Naik Level Kultivasi ke Lv.10", false);
    }

    // Mark quest sebagai selesai
    public void completeQuest(String questName) {
        if (questProgress.containsKey(questName)) {
            questProgress.put(questName, true);
        }
    }

    // Cek apakah quest sudah selesai
    public boolean isQuestComplete(String questName) {
        return questProgress.getOrDefault(questName, false);
    }

    // Dapatkan daftar semua quest
    public Map<String, Boolean> getAllQuests() {
        return questProgress;
    }
}