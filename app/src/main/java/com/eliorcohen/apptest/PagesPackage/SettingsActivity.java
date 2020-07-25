package com.eliorcohen.apptest.PagesPackage;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.eliorcohen.apptest.R;

public class SettingsActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings_xml);

    }

}
