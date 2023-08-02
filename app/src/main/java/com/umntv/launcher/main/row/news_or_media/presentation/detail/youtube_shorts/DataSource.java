package com.umntv.launcher.main.row.news_or_media.presentation.detail.youtube_shorts;

import com.umntv.launcher.main.row.news_or_media.presentation.detail.OverviewItem;

import java.util.List;

import media.umn.tv.R;

public class DataSource {

    public static final String TITLE_ACTION_MICHAEL_JORDAN = "MICHAEL JORDAN";

    private static final OverviewItem YOUTUBE_SHORTS = new OverviewItem(
            R.drawable.news_and_media_ic_yotube_shorts,
            R.drawable.news_and_media_ic_yotube_shorts,
            "YOUTUBE SHORTS",
            "YOUTUBE SHORTS",
            "",
            "YouTube Shorts is a short-form video-sharing platform offered by YouTube. The platform hosts user content much like YouTube's primary service, but limits pieces to 60 seconds in length. Since its launch, YouTube Shorts has accumulated over 5 trillion views",
            "https://www.youtube.com/shorts",
            null
    );

    private static final OverviewItem CNN = new OverviewItem(
            R.drawable.bg_cnn,
            R.drawable.bg_cnn,
            "CNN SHORTS",
            "CNN SHORTS",
            "We are truth-seekers and storytellers.",
            "We are journalists, designers and technologists, united by a mission to inform, engage and empower the world.",
            "https://m.youtube.com/@cnnshorts54/shorts",
            null
    );

    private static final OverviewItem NFL = new OverviewItem(
            R.drawable.ic_nfl,
            R.drawable.ic_nfl,
            "NFL SHORTS",
            "NFL SHORTS",
            "The official YouTube page of the NFL.",
            "Subscribe to the NFL YouTube channel to see immediate in-game highlights from your favorite teams and players, daily fantasy football updates, all your favorite NFL podcasts, and more!",
            "https://m.youtube.com/@NFL/shorts",
            null
    );

    private static final OverviewItem MICHAEL_JORDAN = new OverviewItem(
            R.drawable.ic_sportsdisplay,
            R.drawable.ic_sportsdisplay,
            TITLE_ACTION_MICHAEL_JORDAN,
            "CHICAGO BULLS",
            "MJ23 His Airness Forever",
            "This channel is dedicated to the greatest player ever in basketball history - Michael Jordan.\n\nHis NBA career began in 1984 when he was drafted by the Chicago Bulls. He archived a three-peat twice in his career (1991-1993 & 1996-1998), establishing a dynasty in the 1990s. After the first three-peat, he retired and turned to professional baseball. He later returned to the NBA in 1995. Next season, he lead the Bulls to another three-peat. He then retired again but returned once more in 2001 as a Washington Wizard. He continued to play two more seasons and retired permanently. In 2009, he was introduced to the Basketball Hall of Fame.",
            "https://www.youtube.com/embed/3M2NCcSxKLY?list=PUxeoDNuApdMcmL3WUFoki2A",
            null
    );

    public static List<String> com_tcl_browser = List.of(
            YOUTUBE_SHORTS.titleAction, CNN.titleAction, NFL.titleAction
    );

    public static final List<OverviewItem> items = List.of(
            YOUTUBE_SHORTS,
            CNN,
            NFL,
            MICHAEL_JORDAN
    );
}
