package com.umntv.launcher.main.row.asian_media.detail.jade_cinema;

import android.text.Html;

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


    public static String URL_EXOTIC_KOREAN = "https://koreanpornmovie.com";

    public static String TITLE_EXOTIC_KOREAN = "EXOTIC KOREAN";

    private static final OverviewItem ITEM_EXOTIC_KOREAN = new OverviewItem(
            R.drawable.asian_media_jade_cinema_18_plus_jade_chat_bg,
            R.drawable.asian_media_jade_cinema_18_plus_jade_chat_bg,
            TITLE_EXOTIC_KOREAN,
            "WELCOME TO " + TITLE_EXOTIC_KOREAN,
            OverviewItem.SUBTITLE_DEFAULT,
            "Exotic Movies allow users to enjoy the latest exotic movies from multiple different countries and languages.",
            new ApkData(
                    URL_EXOTIC_KOREAN,
                    "",
                    true
            )
    );

    public static String URL_KOREAN_SOFT_CORE = "https://fullxcinema.com/tag/korean-erotic-movies";

    public static String TITLE_KOREAN_SOFT_CORE = "KOREAN SOFTCORE";

    private static final OverviewItem ITEM_KOREAN_SOFT_CORE = new OverviewItem(
            R.drawable.asian_media_jade_cinema_18_plus_jade_chat_bg,
            R.drawable.asian_media_jade_cinema_18_plus_jade_chat_bg,
            TITLE_KOREAN_SOFT_CORE,
            "WELCOME TO " + TITLE_KOREAN_SOFT_CORE,
            OverviewItem.SUBTITLE_DEFAULT,
            "Erotic Korean allows users to enjoy the latest exotic movies from Korea.",
            new ApkData(
                    URL_KOREAN_SOFT_CORE,
                    "",
                    true
            )
    );

    private static final OverviewItem ITEM_KOREAN_SUB = new OverviewItem(
            R.drawable.asian_media_jade_cinema_18_plus_jade_chat_bg,
            R.drawable.asian_media_jade_cinema_18_plus_jade_chat_bg,
            "KOREAN SUB",
            "WELCOME TO KOREAN SUB",
            OverviewItem.SUBTITLE_DEFAULT,
            "Korean sub allows users to enjoy the latest exotic movies from Korea." + "<br><br>\t\t\t\t\t\t\t\t\t\t\t" + "<b>(AD BLOCKER DISABLE NEEDED)</b>",
            new ApkData(
                    "https://krx18.com/genre/eng-sub",
                    "",
                    true
            )
    );

    public static String URL_LIST_CRAWLER = "https://listcrawler.eu/";

    private static final OverviewItem ITEM_LIST_CRAWLER = new OverviewItem(
            R.drawable.asian_media_jade_cinema_18_plus_jade_chat_bg,
            R.drawable.asian_media_jade_cinema_18_plus_jade_chat_bg,
            "LIST CRAWLER",
            "WELCOME TO LIST CRAWLER",
            OverviewItem.SUBTITLE_DEFAULT,
            "WE TAKE ON RESPONSIBILITY" + "<br><br>\t\t\t\t\t\t\t\t\t\t\t" + "<b>(AD BLOCKER DISABLE NEEDED)</b>",
            new ApkData(
                    URL_LIST_CRAWLER,
                    "",
                    true
            )
    );

    public static final List<OverviewItem> items = List.of(
            ITEM_JADE_CINEMA,
            ITEM_JADE_ANIME,
            ITEM_18_PLUS_JADE_CHAT,
            ITEM_EXOTIC_KOREAN,
            ITEM_KOREAN_SOFT_CORE,
            ITEM_KOREAN_SUB,
            ITEM_LIST_CRAWLER
    );
}
