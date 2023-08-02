package com.umntv.launcher.main.row.umn_tv;

import com.umntv.launcher.util.ResourceHelpers;

import java.util.ArrayList;
import java.util.List;

import media.umn.tv.R;

public class UmnTv {

    public static final String TITLE_FAQ = "FAQ";
    public static final String TITLE_MEDIA_CENTER = "MEDIA CENTER";
    public static final String TITLE_DOWNLOAD_CENTER = "DOWNLOAD CENTER";
    public static final String TITLE_APP_DRAWER = "APP DRAWER";
    public static final String TITLE_REMOTE_SUPPORT = "REMOTE SUPPORT";
    public static final String TITLE_PRELOAD_TV = "PRELOAD TV";

    private static final List<UmnTvCard> umnTvCards = new ArrayList<>();

    public static List<UmnTvCard> setupUmnTv() {
        if (umnTvCards.isEmpty()) {
            String[] title = {
                    "UNIVERSAL MEDIA",
                    TITLE_MEDIA_CENTER,
                    TITLE_REMOTE_SUPPORT,
                    TITLE_PRELOAD_TV,
                    TITLE_APP_DRAWER,
                    TITLE_DOWNLOAD_CENTER,
            };
            String[] apkLinkDownload = {
                    "https://umntv.net/UMNTV/UMN LIVE [2.7.0] 100.apk",
                    null,
                    null,
                    null,
                    null,
                    null,
            };
            String[] link = {
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
            };
            int[] cardImage = {
                    R.drawable.umn_tv_ic_live_tv,
                    R.drawable.umn_tv_ic_media_center,
                    R.drawable.ic_utilities_remote_support,
                    R.drawable.ic_utilities_preload_tv_new,
                    R.drawable.ic_apps_app_drawer,
                    R.drawable.umn_tv_ic_download_center,
            };
            String[] packageName = {
                    "ar.tvplayer.tv",
                    null,
                    null,
                    null,
                    null,
                    null,
            };
            String[] backgroundImageUrl = {
                    ResourceHelpers.toStringUri(R.drawable.ic_umn_tv_live_tv_banner),
                    ResourceHelpers.toStringUri(R.drawable.ic_umn_tv_media_center_bg_dark),
                    ResourceHelpers.toStringUri(R.drawable.ic_utilities_bg),
                    ResourceHelpers.toStringUri(R.drawable.ic_utilities_bg),
                    ResourceHelpers.toStringUri(R.drawable.ic_apps_banner),
                    ResourceHelpers.toStringUri(R.drawable.umn_tv_bg_download_center),
            };

            for (int index = 0; index < title.length; ++index) {
                umnTvCards.add(
                        buildQuickAppInfo(
                                link[index],
                                title[index],
                                cardImage[index],
                                packageName[index],
                                backgroundImageUrl[index],
                                apkLinkDownload[index]
                        )
                );
            }
        }
        return umnTvCards;
    }

    private static UmnTvCard buildQuickAppInfo(String link, String title, int resourceId, String packageName, String backgroundImageUrl, String linkApkDownload) {
        UmnTvCard u = new UmnTvCard();
        u.setTitle(title);
        u.setLink(link);
        u.setPackageName(packageName);
        u.setBackgroundImageStringUri(backgroundImageUrl);
        u.setIconStringUri(ResourceHelpers.toStringUri(resourceId));
        u.setLinkApkDownload(linkApkDownload);
        return u;
    }
}
