package com.t7apklym8.t7world;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Multiplayer {

    private DatabaseReference databaseRef;

    public Multiplayer() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseRef = database.getReference("Multiplayer");
    }

    public void syncPlayerData(Player player) {
        databaseRef.child("players").child(player.getPlayerID()).setValue(player);
    }
}