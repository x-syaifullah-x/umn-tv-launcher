package com.umntv.launcher.main.row.movies_apps;

import android.content.Context;

import androidx.core.content.ContextCompat;

import com.umntv.launcher.util.ResourceHelpers;

import java.util.ArrayList;
import java.util.List;

import media.umn.tv.R;

public class MoviesApps {

    private static final List<MoviesAppsCard> list = new ArrayList<>();

    public static List<MoviesAppsCard> setup(Context c) {
        if (!list.isEmpty()) return list;

        String[] title = {
                "NETFLIX",
                "DISNEY+",
                "PRIME VIDEO",
                "APPLE +",
                "ALLBLK",
                "HULU",
                "HBO MAX",
                "ZEUS NETWORK",
        };
        int[] resourceId = {
                R.drawable.ic_support_netflix,
                R.drawable.ic_disney_plus,
                R.drawable.ic_support_prime_video,
                R.drawable.ic_support_apple_tv_plus,
                R.drawable.ic_support_allblk,
                R.drawable.ic_support_hulu,
                R.drawable.ic_support_hbo_max,
                R.drawable.ic_zuy_fl
        };
        String[] packageName = {
                "com.netflix.mediaclient",
                "com.disney.disneyplus",
                "com.amazon.amazonvideo.livingroom",
                "com.apple.atve.androidtv.appletv",
                "com.umc.androidtv",
                "com.hulu.livingroomplus",
                "com.hbo.hbonow",
                "com.thezeusnetwork.www",
        };

        String[] apkUrl = {
                null,
                "https://umntvdealers.net/UMNTV/Apks/disneyplus-2-15-1-rc3.apk",
                null,
                null,
                null,
                null,
                null,
                null
        };

        for (int index = 0; index < title.length; ++index) {
            MoviesAppsCard s = new MoviesAppsCard();
            s.setTitle(title[index]);
            s.setIconDrawable(ContextCompat.getDrawable(c, resourceId[index]));
            s.setBackgroundStringUri(ResourceHelpers.toStringUri(R.drawable.bg_row_support));
            s.setPackageName(packageName[index]);
            s.setApkUrl(apkUrl[index]);
            list.add(s);
        }

        return list;
    }
}
