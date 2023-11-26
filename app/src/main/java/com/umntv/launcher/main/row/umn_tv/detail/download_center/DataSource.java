package com.umntv.launcher.main.row.umn_tv.detail.download_center;

import com.umntv.launcher.main.base.ApkData;
import com.umntv.launcher.main.base.OverviewItem;

import java.util.List;

import media.umn.tv.R;

public class DataSource {

    public static final String PACKAGE_NAME_N0_RENDER = "com.umn.n0.render";
    public static final String PACKAGE_NAME_N0_BROWSER = "com.umn.n0.browser";

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
                    "https://umntv.net/UMNTV/Game_Browser.apk",
                    PACKAGE_NAME_N0_RENDER,
                    false
            )
    );

    public static final List<OverviewItem> items = List.of(
            N0_BROWSER,
            N0_RENDER
    );
}