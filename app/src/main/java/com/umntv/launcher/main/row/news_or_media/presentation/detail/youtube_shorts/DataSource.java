package com.umntv.launcher.main.row.news_or_media.presentation.detail.youtube_shorts;

import com.umntv.launcher.main.row.news_or_media.presentation.detail.OverviewItem;

import java.util.List;

import media.umn.tv.R;

public class DataSource {

    public static final OverviewItem YOUTUBE_SHORTS = new OverviewItem(
            R.drawable.news_and_media_ic_yotube_shorts,
            R.drawable.news_and_media_ic_yotube_shorts,
            "YOUTUBE SHORTS",
            "YOUTUBE SHORTS",
            "",
            "YouTube Shorts is a short-form video-sharing platform offered by YouTube. The platform hosts user content much like YouTube's primary service, but limits pieces to 60 seconds in length. Since its launch, YouTube Shorts has accumulated over 5 trillion views",
            "https://www.youtube.com/shorts",
            null
    );

    private static final OverviewItem RELAXING_MUSIC = new OverviewItem(
            R.drawable.news_and_media_ic_relaxing_music,
            R.drawable.news_and_media_ic_relaxing_music,
            "RELAXING MUSIC",
            "RELAXING MUSIC",
            "",
            "Enjoy live and pre-record relaxing music via YouTube.",
            "https://www.youtube.com/results?search_query=Relaxing+music",
            null
    );

    private static final OverviewItem KEVIN_HARTS_LOL = new OverviewItem(
            R.drawable.ic_lollolo,
            R.drawable.ic_lollolo,
            "LOL NETWORK!",
            "LOL NETWORK!",
            "Kevin Heart's lol Network",
            "Enjoy Kevin Heart's lol Network live stand-up comedy 24/7 commercial-free",
            "https://www.youtube.com/embed/slQ3XKhB_IY",
            null
    );

    private static final OverviewItem LOL_Network2 = new OverviewItem(
            R.drawable.ic_lollolo2,
            R.drawable.ic_lollolo2,
            "LOL NETWORK 24/7",
            "LOL Network 24/7",
            "Enjoy Kevin Heart's lol Network",
            "Enjoy Kevin Heart's lol Network live Free TV commercial-free",
            "https://www.youtube.com/embed/gssRk8PpiX8",
            null
    );
    public static List<String> com_tcl_browser = List.of(
            YOUTUBE_SHORTS.titleAction
    );

    public static final List<OverviewItem> items = List.of(
            YOUTUBE_SHORTS,
            RELAXING_MUSIC,
            KEVIN_HARTS_LOL,
            LOL_Network2
    );
}
