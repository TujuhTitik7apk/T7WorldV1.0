package com.t7apklym8.t7world;

public class Kultivasi {

    private int energy;
    private int meditationPower;

    public Kultivasi() {
        this.energy = 100;
        this.meditationPower = 0;
    }

    public void meditate() {
        meditationPower += 10;
        energy -= 5;
    }

    public void recharge() {
        energy += 20;
    }

    public int getEnergy() {
        return energy;
    }

    public int getMeditationPower() {
        return meditationPower;
    }
}