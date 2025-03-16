package com.t7apklym8.t7world;

import android.content.Context;
import android.telephony.TelephonyManager;

public class LicenseCheckService {

    private static final String ALLOWED_IMEI = "869120080123456"; // IMEI Perangkat yang diizinkan

    public static boolean isDeviceLicensed(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);

        // Ambil IMEI Perangkat
        String deviceImei = telephonyManager.getImei();

        // Cek apakah IMEI sesuai dengan IMEI yang diizinkan
        return deviceImei != null && deviceImei.equals(ALLOWED_IMEI);
    }
}