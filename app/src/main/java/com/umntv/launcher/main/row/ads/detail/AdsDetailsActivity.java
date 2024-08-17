package com.umntv.launcher.main.row.ads.detail;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.umntv.launcher.main.row.ads.Ads;
import com.umntv.launcher.main.row.ads.AdsCard;
import com.umntv.launcher.main.row.ads.detail.global_girl_net.GlobalGirlNetFragment;
import com.umntv.launcher.main.row.ads.detail.support.SupportFragment;

import java.io.Serializable;

public class AdsDetailsActivity extends FragmentActivity {

    public static final String ITEM = "Item";
    public static final String SHARED_ELEMENT_NAME = "hero";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            Serializable s = getIntent().getSerializableExtra(AdsDetailsActivity.ITEM);
            if (s instanceof AdsCard a) {
                if (a.getTitle().equals(Ads.VENDORS_SUPPORT)) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(android.R.id.content, new SupportFragment())
                            .commitNow();
                } else if (a.getTitle().equals(Ads.GLOBAL_GIRLS_NET)) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(android.R.id.content, new GlobalGirlNetFragment())
                            .commitNow();
                } else {
                    getSupportFragmentManager().beginTransaction()
                            .replace(android.R.id.content, new AdsDetailsFragment())
                            .commitNow();
                }
            }
        }
    }
}
