package com.t7apklym8.t7world;

public class TimeSystem {

    private int day;
    private int time;

    public TimeSystem() {
        this.day = 1;
        this.time = 8; // 08:00 pagi
    }

    public void updateTime() {
        time++;
        if (time > 24) {
            time = 1;
            day++;
        }
    }

    public String getTimeStatus() {
        if (time >= 6 && time <= 18) {
            return "Siang";
        } else {
            return "Malam";
        }
    }
}