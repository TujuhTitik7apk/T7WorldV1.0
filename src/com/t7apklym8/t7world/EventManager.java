package com.t7apklym8.t7world;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class EventManager {

    private List<Event> eventList = new ArrayList<>();

    public EventManager(Context context) {
        loadEventData(context);
    }

    private void loadEventData(Context context) {
        try {
            InputStream inputStream = context.getAssets().open("events/event_data.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();

            String json = new String(buffer, StandardCharsets.UTF_8);
            JSONObject jsonObject = new JSONObject(json);
            JSONArray eventsArray = jsonObject.getJSONArray("events");

            for (int i = 0; i < eventsArray.length(); i++) {
                JSONObject eventObject = eventsArray.getJSONObject(i);
                Event event = new Event(
                        eventObject.getInt("id"),
                        eventObject.getString("name"),
                        eventObject.getString("description"),
                        eventObject.getString("reward")
                );
                eventList.add(event);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Event> getAllEvents() {
        return eventList;
    }
}