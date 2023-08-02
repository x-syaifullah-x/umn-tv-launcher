package com.umntv.launcher.main.row.kids;

import media.umn.tv.R;
import com.umntv.launcher.util.ResourceHelpers;

import java.util.ArrayList;
import java.util.List;

public class Kids {

    private static final List<KidsCard> kids = new ArrayList<>();

    public static List<KidsCard> setup() {
        if (kids.isEmpty()) {
            String[] apkLinkDownload = {
                    "https://umntvdealers.net/UMNTV/Apks/KODI 19/UMN_Kids_UMNTV_1.apk",
                    null,
                    null,
                    null,
                    null
            };
            String[] title = {
                    "UMN KIDS TV",
                    "YOUTUBE KIDS",
                    "HAPPY KIDS",
                    "KIDOODLE TV",
                    "KIDDO-LEARNING"
            };
            int[] resourceId = {
                    R.drawable.kids_ic_umn_kids,
                    R.drawable.kids_ic_youtube_kids,
                    R.drawable.kids_ic_happy_kids,
                    R.drawable.kids_ic_kidoodle_tv,
                    R.drawable.kids_ic_kiddo_learning
            };
            String[] packageName = {
                    "kids.umn.net",
                    "com.google.android.youtube.tvkids",
                    "com.future.HappyKids",
                    "tv.kidoodle.android",
                    "com.vixi.kiddo",
            };

            for (int index = 0; index < title.length; ++index) {
                KidsCard k = new KidsCard();
                k.setTitle(title[index]);
                k.setLinkApkDownload(apkLinkDownload[index]);
                k.setPackageName(packageName[index]);
                k.setIconStringUri(ResourceHelpers.toStringUri(resourceId[index]));
                k.setBackgroundImageStringUri(ResourceHelpers.toStringUri(R.drawable.kids_bg_umn_kids));
                kids.add(k);
            }
        }
        return kids;
    }

}
