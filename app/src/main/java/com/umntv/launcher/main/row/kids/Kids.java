package com.umntv.launcher.main.row.kids;

import media.umn.tv.R;

import com.umntv.launcher.util.ResourceHelpers;

import java.util.ArrayList;
import java.util.List;

public class Kids {

    public static final String TITLE_E_LEARNING = "E-LEARNING";

    private static final List<KidsCard> kids = new ArrayList<>();

    public static List<KidsCard> setup() {
        if (kids.isEmpty()) {
            String[] downloadUrl = {
                    "https://umntvdealers.net/UMNTV/Apks/KODI 19/UMN_Kids_UMNTV_1.apk",
                    null,
                    "https://umntv.net/UMNTV/IXL_7.0.0_Apkpure.apk",
                    null,
                    null
            };
            String[] title = {
                    "UMN KIDS TV",
                    "YOUTUBE KIDS",
                    "UMN_IXL",
                    TITLE_E_LEARNING,
                    "KIDS NURSERY SONGS"
            };
            int[] icon = {
                    R.drawable.kids_ic_umn_kids,
                    R.drawable.kids_ic_youtube_kids,
                    R.drawable.kids_ic_umn_ixl,
                    R.drawable.kids_ic_e_learning,
                    R.drawable.kids_ic_kids_nursery
            };
            String[] packageName = {
                    "kids.umn.net",
                    "com.google.android.youtube.tvkids",
                    "com.ixl.ixlmath",
                    null,
                    "net.colorcity.kidsy",
            };

            for (int index = 0; index < title.length; ++index) {
                KidsCard k = new KidsCard();
                k.setTitle(title[index]);
                k.setDownloadUrl(downloadUrl[index]);
                k.setPackageName(packageName[index]);
                k.setIconStringUri(ResourceHelpers.toStringUri(icon[index]));
                k.setBackgroundStringUri(ResourceHelpers.toStringUri(R.drawable.kids_bg_umn_kids));
                kids.add(k);
            }
        }
        return kids;
    }

}
