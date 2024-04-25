package com.umntv.launcher.main.row.umn_tv.media_center;

import media.umn.tv.R;

import com.umntv.launcher.main.base.ApkData;
import com.umntv.launcher.main.base.OverviewItem;

import java.util.List;

public class DataSource {

    private static final OverviewItem MEDIA_CENTER = new OverviewItem(
            R.drawable.umn_tv_ic_media_center,
            R.drawable.ic_umn_tv_media_center_icon_new,
            "MEDIA CENTER",
            "WELCOME TO UMN MEDIA CENTER",
            OverviewItem.SUBTITLE_DEFAULT,
            "UMN Media Center is a Kodi-based platform that allows users to search the web for content.\n\nSpecial Thanks to XBMC | Abu Bakar | Syaifullah | IC Network",
            new ApkData(
                    "https://umntvdealers.net/UMNTV/Apks/KODI 19/Media_Center_UMNTV_1.apk",
                    "mc.umn.net",
                    false
            )
    );

    private static final OverviewItem TOPAZ_CINEMA = new OverviewItem(
            R.drawable.ic_umn_tv_media_center_bg_topaz_cinema_new,
            R.drawable.ic_umn_tv_media_center_bg_topaz_cinema_new,
            "TOPAZ CINEMA",
            "WELCOME TO TOPAZ CINEMA",
            OverviewItem.SUBTITLE_DEFAULT,
            "Topaz Cinema is a Universal Media exclusive application.\nIt allows users to browse their favorite topaz-colored people mainly from the Americas.",
            new ApkData(
                    "https://umntvdealers.net/UMNTV/Apks/KODI 19/Topaz_Cinema_UMNTV_1.apk",
                    "tc.umn.net",
                    false
            )
    );

    private static final OverviewItem WORLD_START_TV = new OverviewItem(
            R.drawable.ic_umn_tv_media_center_world_start_tv_bg_new,
            R.drawable.ic_umn_tv_media_center_world_start_tv_bg_new,
            "UMN SPORTS",
            "WELCOME TO UMN SPORTS",
            OverviewItem.SUBTITLE_DEFAULT,
            "You can find live sports events. Live pay-per-view events and replays",
//            "UMN SPORTS is an 18 + application that allows users to browse for the latest funniest, violent, and toxic videos trending on social media.",
            new ApkData(
                    "https://umntvdealers.net/UMNTV/Apks/KODI 19/World_Star_UMNTV_1.apk",
                    "ws.umn.net",
                    false
            )
    );

    private static final OverviewItem PLUS_18_LIVE_CHAT = new OverviewItem(
            R.drawable.ic_umn_tv_media_center_18_plus_bg,
            R.drawable.ic_umn_tv_media_center_18_plus_bg,
            "18+ LIVE CHAT",
            "WELCOME TO 18+ LIVE CHAT",
            OverviewItem.SUBTITLE_DEFAULT,
            "Universal Media 18 + live chat allows users to view and chat with live nude women, men, or couples from around the world.\nIt also gives you access to an unlimited supply of XXX videos, clips, and movies.",
            new ApkData(
                    "https://umntvdealers.net/UMNTV/Apks/KODI 19/Live_Chat_UMNTV_1.apk",
                    "lc.umn.net",
                    true
            )
    );

    public static final List<OverviewItem> items = List.of(
            MEDIA_CENTER,
            TOPAZ_CINEMA,
            WORLD_START_TV,
            PLUS_18_LIVE_CHAT
    );
}
