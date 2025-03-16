package com.t7apklym8.t7world;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class NPCDialogManager {

    private JSONArray npcData;

    public NPCDialogManager(Context context) {
        try {
            InputStream inputStream = context.getAssets().open("npc/npc_dialog.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            String json = new String(buffer, StandardCharsets.UTF_8);
            JSONObject jsonObject = new JSONObject(json);
            npcData = jsonObject.getJSONArray("npcs");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getNPCDialog(int npcId, String language) {
        try {
            for (int i = 0; i < npcData.length(); i++) {
                JSONObject npc = npcData.getJSONObject(i);
                if (npc.getInt("id") == npcId) {
                    JSONObject dialog = npc.getJSONObject("dialog");
                    JSONObject text = dialog.getJSONObject("text");
                    return text.getString(language);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Dialog tidak ditemukan.";
    }
}