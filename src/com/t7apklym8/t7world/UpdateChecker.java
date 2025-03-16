package com.t7apklym8.t7world;

import android.content.Context;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UpdateChecker {

    private static final String TAG = "UpdateChecker";
    private DatabaseReference databaseRef;

    public UpdateChecker() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        databaseRef = firebaseDatabase.getReference("AppVersion");
    }

    // Cek versi terbaru di Firebase Realtime Database
    public void checkForUpdate(Context context, String currentVersion) {
        databaseRef.child("latest_version").get().addOnCompleteListener(task -> {
            if (task.isSuccessful() && task.getResult() != null) {
                String latestVersion = task.getResult().getValue(String.class);
                if (latestVersion != null && !latestVersion.equals(currentVersion)) {
                    Log.d(TAG, "Update Tersedia: Versi Terbaru " + latestVersion);
                    new SecurityManager().decryptJson(context);  // Decrypt data JSON
                    LicenseCheckService.verifyIMEI(context);     // Cek IMEI perangkat
                }
            }
        });
    }
}