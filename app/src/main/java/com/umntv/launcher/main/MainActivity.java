package com.umntv.launcher.main;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import media.umn.tv.R;

public class MainActivity extends FragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_browse_fragment, new MainFragment())
                    .commitNow();
        }
    }

    @Override
    public void onBackPressed() {
        /**/
    }
}