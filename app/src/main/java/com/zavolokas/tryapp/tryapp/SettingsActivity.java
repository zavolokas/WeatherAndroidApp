package com.zavolokas.tryapp.tryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager().beginTransaction()
                .replace(R.id.settings_container, new SettingsActivityFragment(), "SETTINGS_FRAGMENT")
                .commit();
    }
}
