package com.umntv.launcher.main.row.ads.detail;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

public class AdsDetailsActivity extends FragmentActivity {

    public static final String ITEM = "Item";
    public static final String SHARED_ELEMENT_NAME = "hero";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(android.R.id.content, new AdsDetailsFragment())
                    .commitNow();
        }
    }
}
