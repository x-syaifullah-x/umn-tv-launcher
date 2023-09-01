package com.umntv.launcher.main.row.asian_media.detail.jade_cinema;

import media.umn.tv.R;
import com.umntv.launcher.main.base.ApkData;
import com.umntv.launcher.main.base.OverviewItem;

import java.util.List;

public class DataSource {

    private static final OverviewItem ITEM_JADE_CINEMA = new OverviewItem(
            R.drawable.asian_media_jade_cinema_ic,
            R.drawable.ic_asian_media_jade_cinema_detail_bg,
            "JADE CINEMA",
            "WELCOME TO JADE CINEMA",
            OverviewItem.SUBTITLE_DEFAULT,
            "Jade Cinema is a Kodi-based platform that allows users to search for TV shows and movies specifically in Asian countries.\n\nSpecial Thanks to XBMC | Abu Bakar | Syaifullah | IC Network",
            new ApkData(
                    "https://umntvdealers.net/UMNTV/Apks/KODI 19/JADE_Cinema_UMNTV_1.apk",
                    "jade.umn.net",
                    false
            )
    );
    
    private static final OverviewItem ITEM_JADE_ANIME = new OverviewItem(
            R.drawable.ic_asian_media_jade_anime_detail_bg,
            R.drawable.ic_asian_media_jade_anime_detail_bg,
            "JADE ANIME",
            "WELCOME TO JADE ANIME",
            OverviewItem.SUBTITLE_DEFAULT,
            "Jade anime allows users to search for their favorite anime movies and series.",
            new ApkData(
                    "https://umntvdealers.net/UMNTV/Apks/KODI 19/JADE_Anime_UMNTV_1.apk",
                    "anime.umn.net",
                    false
            )
    );

    private static final OverviewItem ITEM_18_PLUS_JADE_CHAT = new OverviewItem(
            R.drawable.asian_media_jade_cinema_18_plus_jade_chat_bg,
            R.drawable.asian_media_jade_cinema_18_plus_jade_chat_bg,
            "18+ JADE CHAT",
            "WELCOME TO 18+ JADE CHAT",
            OverviewItem.SUBTITLE_DEFAULT,
            "Jade Cinema 18 + live chat allows users to view and chat with live Asian women, men, and couples. It also gives you an unlimited supply of xxx, videos, movies, and clips.",
            new ApkData(
                    "https://umntvdealers.net/UMNTV/Apks/KODI 19/JADE_CHAT_UMNTV_1.apk",
                    "jc.umn.net",
                    true
            )
    );

    
    private static final OverviewItem ITEM_EXOTIC_MOVIES = new OverviewItem(
            R.drawable.asian_media_jade_cinema_18_plus_jade_chat_bg,
            R.drawable.asian_media_jade_cinema_18_plus_jade_chat_bg,
            "EXOTIC MOVIES",
            "WELCOME TO EXOTIC MOVIES",
            OverviewItem.SUBTITLE_DEFAULT,
            "Jade Cinema 18 + live chat allows users to view and chat with live Asian women, men, and couples. It also gives you an unlimited supply of xxx, videos, movies, and clips.",
            new ApkData(
                    "https://eroticmv.com",
                    "",
                    true
            )
    );

    private static final OverviewItem ITEM_HAME_EROTIC_KOREAN = new OverviewItem(
            R.drawable.asian_media_jade_cinema_18_plus_jade_chat_bg,
            R.drawable.asian_media_jade_cinema_18_plus_jade_chat_bg,
            "HAME EROTIC KOREAN",
            "WELCOME TO HAME EROTIC KOREAN",
            OverviewItem.SUBTITLE_DEFAULT,
            "Jade Cinema 18 + live chat allows users to view and chat with live Asian women, men, and couples. It also gives you an unlimited supply of xxx, videos, movies, and clips.",
            new ApkData(
                    "https://fullxcinema.com/tag/korean-erotic-movies",
                    "",
                    true
            )
    );
    
    public static final List<OverviewItem> items = List.of(
            ITEM_JADE_CINEMA,
            ITEM_JADE_ANIME,
            ITEM_18_PLUS_JADE_CHAT,
            ITEM_EXOTIC_MOVIES,
            ITEM_HAME_EROTIC_KOREAN
    );
}
