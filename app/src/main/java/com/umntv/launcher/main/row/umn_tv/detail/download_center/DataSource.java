package com.umntv.launcher.main.row.umn_tv.detail.download_center;

import com.umntv.launcher.main.base.ApkData;
import com.umntv.launcher.main.base.OverviewItem;

import java.util.List;

import media.umn.tv.R;

public class DataSource {

    private static final String PACKAGE_NAME_DOWNLOAD_ONLY = "-";

    private static final OverviewItem UPDATE_LAUNCHER = new OverviewItem(
            R.drawable.ic_umn_tv_download_center_new,
            R.drawable.ic_umn_tv_download_center_new,
            "UPDATE LAUNCHER",
            "WELCOME TO UMN DOWNLOAD CENTER",
            "",
            "Some of these apps are available in the Google play-store\n\n" +
                    "UPDATE LAUNCHER INTEL. Please Clear Launcher data after installation\n" +
                    "Setting < Apps < UMN_LAUNCHER < Clear data",
            new ApkData(
                    "https://umntvdealers.net/UMNTV/Apks/LAUNCHERPRO9-1.apk",
//                    "com.umntv.launcher",
                    PACKAGE_NAME_DOWNLOAD_ONLY,
                    false
            )
    );

    private static final OverviewItem UMN_LITE = new OverviewItem(
            R.drawable.ic_umn_tv_download_center_new,
            R.drawable.ic_umn_tv_download_center_new,
            "UMN LITE",
            "WELCOME TO UMN DOWNLOAD CENTER",
            "",
            "Some of these apps are available in the Google play-store\n\n" +
                    "UPDATE LAUNCHER INTEL. Please Clear Launcher data after installation\n" +
                    "Setting < Apps < UMN_LAUNCHER < Clear data",
            new ApkData(
                    "https://umntvdealers.net/UMNTV/Apks/UMNLTIE.apk",
                    "com.umntv.launcher.lite",
                    false
            )
    );

    private static final OverviewItem FIRE_TRUCK = new OverviewItem(
            R.drawable.ic_umn_tv_download_center_new,
            R.drawable.ic_umn_tv_download_center_new,
            "HD CINEMA",
            "WELCOME TO UMN DOWNLOAD CENTER",
            "",
            "Some of these apps are available in the Google play-store\n\n" +
                    "UPDATE LAUNCHER INTEL. Please Clear Launcher data after installation\n" +
                    "Setting < Apps < UMN_LAUNCHER < Clear data",
            new ApkData(
                    "https://umntvdealers.net/UMNTV/Apks/2.4.apk",
                    "com.yoku.marumovie.analytics",
                    false
            )
    );

    private static final OverviewItem ATV_MANAGER = new OverviewItem(
            R.drawable.ic_umn_tv_download_center_new,
            R.drawable.ic_umn_tv_download_center_new,
            "STREMIO",
            "WELCOME TO UMN DOWNLOAD CENTER",
            "",
            "Some of these apps are available in the Google play-store\n\n" +
                    "UPDATE LAUNCHER INTEL. Please Clear Launcher data after installation\n" +
                    "Setting < Apps < UMN_LAUNCHER < Clear data",
            new ApkData(
                    "https://umntvdealers.net/UMNTV/Apks/stremio..apk",
                    "com.stremio.one",
                    false
            )
    );

    private static final OverviewItem POLICE_SCANNER = new OverviewItem(
            R.drawable.ic_umn_tv_download_center_new,
            R.drawable.ic_umn_tv_download_center_new,
            "POLICE SCANNER",
            "WELCOME TO UMN DOWNLOAD CENTER",
            "",
            "Some of these apps are available in the Google play-store\n\n" +
                    "UPDATE LAUNCHER INTEL. Please Clear Launcher data after installation\n" +
                    "Setting < Apps < UMN_LAUNCHER < Clear data",
            new ApkData(
                    "https://umntv.net/UMNTV/Police Scanner.apk",
                    "com.criticalhitsoftware.policeradio",
                    false
            )
    );

    private static final OverviewItem EARTH_CAM = new OverviewItem(
            R.drawable.ic_umn_tv_download_center_new,
            R.drawable.ic_umn_tv_download_center_new,
            "EARTH CAM",
            "WELCOME TO UMN DOWNLOAD CENTER",
            "",
            "Some of these apps are available in the Google play-store\n\n" +
                    "UPDATE LAUNCHER INTEL. Please Clear Launcher data after installation\n" +
                    "Setting < Apps < UMN_LAUNCHER < Clear data",
            new ApkData(
                    "https://play.google.com/store/apps/details?id=com.earthcam.earthcamtv.android&hl=en_US&gl=US",
                    "com.earthcam.earthcamtv.android",
                    false
            )
    );

    private static final OverviewItem BLACK_AND_SEXY = new OverviewItem(
            R.drawable.ic_umn_tv_download_center_new,
            R.drawable.ic_umn_tv_download_center_new,
            "BLACK & SEXY",
            "WELCOME TO UMN DOWNLOAD CENTER",
            "",
            "Some of these apps are available in the Google play-store\n\n" +
                    "UPDATE LAUNCHER INTEL. Please Clear Launcher data after installation\n" +
                    "Setting < Apps < UMN_LAUNCHER < Clear data",
            new ApkData(
                    "https://play.google.com/store/apps/details?id=tv.vhx.blackandsexy&hl=en_US&gl=US",
                    "tv.vhx.blackandsexy",
                    false
            )
    );

    private static final OverviewItem OLD_ASS_MOVIES = new OverviewItem(
            R.drawable.ic_umn_tv_download_center_new,
            R.drawable.ic_umn_tv_download_center_new,
            "OLD ASS MOVIES",
            "WELCOME TO UMN DOWNLOAD CENTER",
            "",
            "Some of these apps are available in the Google play-store\n\n" +
                    "UPDATE LAUNCHER INTEL. Please Clear Launcher data after installation\n" +
                    "Setting < Apps < UMN_LAUNCHER < Clear data",
            new ApkData(
                    "https://play.google.com/store/apps/details?id=com.acowboys.oldmovies&hl=en_US&gl=US",
                    "com.acowboys.oldmovies",
                    false
            )
    );
    public static final List<OverviewItem> items = List.of(
            UPDATE_LAUNCHER,
            UMN_LITE,
            FIRE_TRUCK,
            ATV_MANAGER,
            POLICE_SCANNER,
            EARTH_CAM,
            BLACK_AND_SEXY,
            OLD_ASS_MOVIES
    );
}