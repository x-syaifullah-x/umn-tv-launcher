package x96.mate.launcher.main.row.news;

import x96.mate.launcher.R;
import x96.mate.launcher.util.ResourceHelpers;

import java.util.ArrayList;
import java.util.List;

public final class News {

    private static final List<NewsCard> v = new ArrayList<>();

    public static List<NewsCard> setup() {
        if (v.isEmpty()) {
            String[] title = {
//                    "INT NEWS",
                    "YOUTUBE",
//                    "YOUTUBE SHORTS",
                    "TIKTOK",
                    "HAYSTACK NEWS",
//                    "AFRICAN NEWS",
//                    "ASIAN NEWS",
//                    "BLOOMBERG",
            };
            String[] description = {
//                    "",
                    null,
//                    null,
                    null,
                    null,
//                    "Channels Television is a leading 24-hour news channel broadcasting live from Lagos, Nigeria - West Africa. Our mission" +
//                            " is to produce and broadcast television programs of quality and integrity that recognize and challenge, the " +
//                            "intelligence and curiosity of our viewers.",
//                    "Watch CNA's 24-hour live coverage of the latest headlines and top stories from Singapore, Asia and around the world, as" +
//                            " well as documentaries and features that bring you a deeper look at Singapore and Asian issues.",
//                    null,
            };

            String[] packageName = {
//                    null,
                    "com.google.android.youtube.tv",
//                    null,
                    "com.tiktok.tv",
                    "com.haystack.android",
//                    null,
//                    null,
//                    "com.bloomberg.btva",
            };

            String[] youtubeId = {
//                    null,
                    null,
//                    null,
                    null,
                    null,
//                    "-c8LoR84Xjs",
//                    "XWq5kBlakcQ",
//                    null,
            };
            String[] bannerImage = {
//                    ResourceHelpers.toStringUri(R.drawable.news_and_media_bg_int_news),
                    ResourceHelpers.toStringUri(R.drawable.bg_ironman_replace),
//                    ResourceHelpers.toStringUri(R.drawable.news_and_media_bg_yotube_shorts),
                    ResourceHelpers.toStringUri(R.drawable.bg_ironman_replace),
                    ResourceHelpers.toStringUri(R.drawable.bg_ironman_replace),
//                    ResourceHelpers.toStringUri(R.drawable.ic_news_african_news_banner),
//                    ResourceHelpers.toStringUri(R.drawable.ic_news_asian_news_banner),
//                    ResourceHelpers.toStringUri(R.drawable.ic_news_bloomberg),
            };
            String[] cardImage = {
//                    ResourceHelpers.toStringUri(R.drawable.news_or_media_ic_int_news),
                    ResourceHelpers.toStringUri(R.drawable.news_or_media_ic_youtube),
//                    ResourceHelpers.toStringUri(R.drawable.news_and_media_ic_yotube_shorts),
                    ResourceHelpers.toStringUri(R.drawable.news_or_media_ic_titok),
                    ResourceHelpers.toStringUri(R.drawable.news_or_media_ic_haystack_news),
//                    ResourceHelpers.toStringUri(R.drawable.ic_news_african_news),
//                    ResourceHelpers.toStringUri(R.drawable.ic_news_asian_news),
//                    ResourceHelpers.toStringUri(R.drawable.ic_news_bloomberg),
            };
            String[] iconDetailImage = {
//                    ResourceHelpers.toStringUri(R.drawable.bg_int_news),
                    null,
//                    null,
                    null,
                    null,
//                    ResourceHelpers.toStringUri(R.drawable.ic_news_african_news_detail_icon),
//                    ResourceHelpers.toStringUri(R.drawable.ic_news_asian_news_detail_icon),
//                    null,
            };

            for (int index = 0; index < title.length; ++index) {
                v.add(
                        buildNewsInfo(
                                title[index],
                                description[index],
                                youtubeId[index],
                                cardImage[index],
                                bannerImage[index],
                                iconDetailImage[index],
                                packageName[index]
                        )
                );
            }
        }
        return v;
    }

    private static NewsCard buildNewsInfo(
            String title,
            String description,
            String youtubeId,
            String cardImageUrl,
            String backgroundImageUrl,
            String detailImageUrl,
            String packageName) {
        NewsCard newsCard = new NewsCard();
        newsCard.setPackageName(packageName);
        newsCard.setTitle(title);
        newsCard.setDetailDescription(description);
        newsCard.setIconStringUri(cardImageUrl);
        newsCard.setBackgroundImageStringUri(backgroundImageUrl);
        newsCard.setDetailImageStringUri(detailImageUrl);
        newsCard.setYoutubeId(youtubeId);
        return newsCard;
    }
}