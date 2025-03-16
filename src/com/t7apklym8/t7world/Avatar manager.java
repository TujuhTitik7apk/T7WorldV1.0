package com.t7apklym8.t7world;

import android.content.Context;
import android.content.SharedPreferences;

public class AvatarManager {
    private static final String PREFS_NAME = "AvatarPrefs";
    private static final String AVATAR_KEY = "selected_avatar";

    private int[] avatars = {
        R.drawable.avatar_child_male,
        R.drawable.avatar_child_female,
        R.drawable.avatar_teen_male,
        R.drawable.avatar_teen_female,
        R.drawable.avatar_adult_male,
        R.drawable.avatar_adult_female
    };

    private SharedPreferences prefs;

    public AvatarManager(Context context) {
        prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public int getSelectedAvatar() {
        int index = prefs.getInt(AVATAR_KEY, 0); // Default ke avatar pertama
        return avatars[index];
    }

    public void setSelectedAvatar(int index) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(AVATAR_KEY, index);
        editor.apply();
    }

    public int[] getAllAvatars() {
        return avatars;
    }
}