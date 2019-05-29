package com.example.applicationlogin;

import android.content.Context;
import android.content.SharedPreferences;

public class UserPreferences {
    private static final String SHARED_PREFERENCES_NAME = "com.example.applicationlogin";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    private SharedPreferences prefs;

    public UserPreferences(Context context) {
        prefs = context.getApplicationContext().getSharedPreferences( SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    public void register( String username, String password) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString( USERNAME, username);
        editor.putString( PASSWORD, password);
        editor.commit();
    }

    public String getUserName() {
        return prefs.getString( USERNAME, null);
    }
}
