package com.tistory.itmir.studycheckerfnextensions;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;


public class MainActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.pref_setting);

        setOnPreferenceClick(findPreference("show"));
        setOnPreferenceClick(findPreference("setting"));
    }

    private void setOnPreferenceClick(Preference mPreference) {
        mPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                String getKey = preference.getKey();

                if ("show".equals(getKey)) {
                    startService(new Intent(getApplicationContext(), MyService.class));
                } else if ("setting".equals(getKey)) {
                    startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
                }

                return true;
            }
        });
    }
}
