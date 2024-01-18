package com.umntv.launcher.main.row.umn_tv.detail.download_center;

import com.umntv.launcher.main.base.ApkData;
import com.umntv.launcher.main.base.OverviewItem;

import java.util.List;

import media.umn.tv.R;

public class DataSource {

    public static final String PACKAGE_NAME_N0_RENDER = "com.umn.n0.render";
    public static final String PACKAGE_NAME_N0_BROWSER = "com.umn.n0.browser";

    public static final String URL_GAME_BROWSER = "https://umntv.net/UMNTV/Game_Browser.apk";

    private static final OverviewItem DOWNLOAD_CENTER = new OverviewItem(
            R.drawable.ic_umn_tv_download_center_new,
            R.drawable.ic_umn_tv_download_center_new,
            "DOWNLOAD CENTER",
            "WELCOME TO UMN DOWNLOAD CENTER",
            "",
            "Expand your way of thinking by exploring the UMN Download Center.",
            new ApkData(
                    "https://umntv.net/UMNTV/N0Browser.apk",
                    PACKAGE_NAME_N0_BROWSER,
                    false
            )
    );

    private static final OverviewItem N0_BROWSER = new OverviewItem(
            R.drawable.ic_umn_tv_download_center_new,
            R.drawable.ic_umn_tv_download_center_new,
            "N0BROWSER",
            "WELCOME TO UMN DOWNLOAD CENTER",
            "",
            "Expand your way of thinking by exploring the UMN Download Center.",
            new ApkData(
                    "https://umntv.net/UMNTV/N0Browser.apk",
                    PACKAGE_NAME_N0_BROWSER,
                    false
            )
    );

    private static final OverviewItem N0_RENDER = new OverviewItem(
            R.drawable.ic_umn_tv_download_center_new,
            R.drawable.ic_umn_tv_download_center_new,
            "GAME BROWSER",
            "WELCOME TO UMN DOWNLOAD CENTER",
            "",
            "Expand your way of thinking by exploring the UMN Download Center.",
            new ApkData(
                    URL_GAME_BROWSER,
                    PACKAGE_NAME_N0_RENDER,
                    false
            )
    );

    private static final OverviewItem JIO_BROWSER = new OverviewItem(
            R.drawable.ic_umn_tv_download_center_new,
            R.drawable.ic_umn_tv_download_center_new,
            "JIO BROWSER",
            "WELCOME TO UMN DOWNLOAD CENTER",
            "",
            "Expand your way of thinking by exploring the UMN Download Center.",
            new ApkData(
                    "https://umntv.net/UMNTV/Browser.apk",
                    "com.jio.web.androidtv",
                    false
            )
    );

    private static final OverviewItem UPDATE_LAUNCHER = new OverviewItem(
            R.drawable.ic_umn_tv_download_center_new,
            R.drawable.ic_umn_tv_download_center_new,
            "UPDATE LAUNCHER",
            "WELCOME TO UMN DOWNLOAD CENTER",
            "",
            "After installing & updating your launcher please clear the launcher data in the system settings. (Settings>Apps>MATE LAUNCHER> Clear data.",
            new ApkData(
                    "https://umntvdealers.net/UMNTV/Apks/T95%20Launcher.apk",
//                    "com.umntv.launcher",
                    "-",
                    false
            )
    );

    private static final OverviewItem UMN_LITE = new OverviewItem(
            R.drawable.ic_umn_tv_download_center_new,
            R.drawable.ic_umn_tv_download_center_new,
            "UMN LITE",
            "WELCOME TO UMN DOWNLOAD CENTER",
            "",
            "After installing & updating your launcher please clear the launcher data in the system settings. (Settings>Apps>MATE LAUNCHER> Clear data.",
            new ApkData(
                    "https://umntv.net/UMNTV/T95%20Launcher%20LT.apk",
                    "com.umntv.launcher.lite",
                    false
            )
    );

    public static final List<OverviewItem> items = List.of(
            DOWNLOAD_CENTER,
            UPDATE_LAUNCHER,
            UMN_LITE,
            N0_BROWSER,
            N0_RENDER,
            JIO_BROWSER
    );
}