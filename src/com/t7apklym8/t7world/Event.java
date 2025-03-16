package com.t7apklym8.t7world;

public class Event {

    private int id;
    private String name;
    private String description;
    private String reward;

    public Event(int id, String name, String description, String reward) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.reward = reward;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getReward() {
        return reward;
    }
}