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
                "AI smeartassist".toUpperCase(),
                "TV E-mail".toUpperCase(),
                "Zoog VPN".toUpperCase(),
                "SEND FILES TO TV",
                "Screencast".toUpperCase(),
        };
        int[] resourceId = {
                R.drawable.ai_smeartassist_ic,
                R.drawable.ic_tv_mail,
                R.drawable.ic_zoog_vpn,
                R.drawable.ic_utilities_send_files_to_tv,
                R.drawable.ic_utilities_screen_cast,
        };
        String[] packageName = {
                "com.gowittgroup.smartassist",
                "not.a.bug.tvmail",
                "com.zoogvpn.android",
                "com.yablio.sendfilestotv",
                "com.ionitech.airscreen"
        };

        String[] apkUrl = {
                null,
                null,
                null,
                null,
                null,
        };

        for (int index = 0; index < title.length; ++index) {
            MoviesAppsCard s = new MoviesAppsCard();
            s.setTitle(title[index]);
            s.setIconDrawable(ContextCompat.getDrawable(c, resourceId[index]));
            s.setBackgroundStringUri(ResourceHelpers.toStringUri(R.drawable.bg_row_support_aa));
            s.setPackageName(packageName[index]);
            s.setApkUrl(apkUrl[index]);
            list.add(s);
        }

        return list;
    }
}
