package com.t7apklym8.t7world;

import java.io.Serializable;

public class Player implements Serializable {

    private String playerID;
    private String playerName;
    private int level;
    private int gold;
    private int kultivasiPower;

    // Konstruktor
    public Player() {
        this.playerID = "DefaultPlayer";
        this.playerName = "Pendekar T7";
        this.level = 1;
        this.gold = 100;
        this.kultivasiPower = 0;
    }

    // Getter & Setter
    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getKultivasiPower() {
        return kultivasiPower;
    }

    public void setKultivasiPower(int kultivasiPower) {
        this.kultivasiPower = kultivasiPower;
    }
}