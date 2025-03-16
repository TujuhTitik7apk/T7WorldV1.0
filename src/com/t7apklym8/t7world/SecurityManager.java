package com.t7apklym8.t7world;

import android.util.Base64;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityManager {

    private static final String SECRET_KEY = T7WorldApp.getInstance()
            .getString(R.string.encryption_key);

    // Enkripsi JSON dengan SHA-1
    public static String encryptJSON(String jsonData) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
            byte[] hashBytes = digest.digest(jsonData.getBytes(StandardCharsets.UTF_8));

            // Hasil Hash dalam Base64
            return Base64.encodeToString(hashBytes, Base64.NO_WRAP);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Validasi IMEI dengan SHA-1 (dengan SHA-1 Device T7World)
    public static String hashIMEI(String imei) {
        try {
            String sha1Key = "FB:22:F8:D7:A3:7C:99:34:6B:D2:08:C8:28:95:D2:02:59:61:E2:FA";
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(sha1Key.getBytes(StandardCharsets.UTF_8));
            byte[] hashBytes = digest.digest(imei.getBytes(StandardCharsets.UTF_8));

            return Base64.encodeToString(hashBytes, Base64.NO_WRAP);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}