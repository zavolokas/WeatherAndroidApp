package com.zavolokas.sunshine;


import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;

import java.util.prefs.Preferences;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsActivityFragment extends PreferenceFragment
implements Preference.OnPreferenceChangeListener {


    public SettingsActivityFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.pref_general);
        //bindPreferenceSummaryToValue
    }

    private void bindPreferenceSummaryToValue(Preference preference){
        preference.setOnPreferenceChangeListener(this);
        onPreferenceChange(preference, PreferenceManager
                .getDefaultSharedPreferences(preference.getContext())
                .getString(preference.getKey(),""));
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {

        String stringValue = newValue.toString();

        if (preference instanceof ListPreference){

        } else{
            preference.setSummary(stringValue);
        }


        return true;
    }
}

