package x96.mate.launcher.main.row.news.detail;

import x96.mate.launcher.R;

import java.util.List;

public class DataSource {

    private static final OverviewItem AFRICAN_NEWS = new OverviewItem(
            R.drawable.news_or_media_ic_int_news,
            R.drawable.news_or_media_int_news_bg_int_news,
            "NIGERIA",
            "AFRICAN NEWS",
            "",
            "Channels Television is a leading 24-hour news channel broadcasting live from Lagos, Nigeria - West Africa. Our mission" +
                    " is to produce and broadcast television programs of quality and integrity that recognize and challenge, the " +
                    "intelligence and curiosity of our viewers.",
            "-c8LoR84Xjs",
            null
    );

    private static final OverviewItem ASIAN_NEWS = new OverviewItem(
            R.drawable.news_or_media_ic_int_news,
            R.drawable.news_or_media_int_news_bg_int_news,
            "SINGAPORE",
            "ASIAN NEWS",
            "",
            "Watch CNA's 24-hour live coverage of the latest headlines and top stories from Singapore, Asia and around the world, as" +
                    " well as documentaries and features that bring you a deeper look at Singapore and Asian issues.",
            "XWq5kBlakcQ",
            null
    );

    private static final OverviewItem INDIA = new OverviewItem(
            R.drawable.news_or_media_ic_int_news,
            R.drawable.news_or_media_int_news_bg_int_news,
            "INDIA",
            "INDIA NEWS",
            "",
            "India Today TV is India's leading English News Channel. India Today YouTube channel offers latest news videos on Politics, Business, Cricket, Bollywood, Lifestyle, Auto, Technology, Travel, Entertainment and a lot more.",
            "lyeyoqwXm5o",
            null
    );

    private static final OverviewItem KENYA = new OverviewItem(
            R.drawable.news_or_media_ic_int_news,
            R.drawable.news_or_media_int_news_bg_int_news,
            "KENYA",
            "KENYA NEWS",
            "",
            "KTN News is a 24-hour news and current affairs channel. It has great content that include sports, ground breaking documentaries and investigative features. The station was launched in June 2015 and it has regional reach on Dstv- 274. It can also be accessed on GoTv-94 and Zuku-14. It broadcasts in Swahili and English, http://ktnnews.com",
            "BxwA_yKUlKg",
            null
    );

    private static final OverviewItem UK = new OverviewItem(
            R.drawable.news_or_media_ic_int_news,
            R.drawable.news_or_media_int_news_bg_int_news,
            "UK",
            "UK NEWS",
            "",
            "The best of Sky News video from the UK and around the world.",
            "9Auq9mYxFEE",
            null
    );

    public static final List<OverviewItem> items = List.of(
            AFRICAN_NEWS,
            ASIAN_NEWS,
            INDIA,
            KENYA,
            UK
    );
}
