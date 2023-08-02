package x96.mate.launcher.main.row.umn_tv;

import java.util.ArrayList;
import java.util.List;

import x96.mate.launcher.util.ResourceHelpers;
import x96.mate.launcher.R;

public class UmnTv {

    private static final List<UmnTvCard> umnTvCards = new ArrayList<>();

    public static List<UmnTvCard> setupUmnTv() {
        if (umnTvCards.isEmpty()) {
            String[] apkLinkDownload = {
                    "https://umntv.net/UMNTV/UMN LIVE [2.7.0] 100.apk",
//                    "https://umntv.net/UMNTV/UMN MS [3.1.2].apk",
//                    null,
//                    null,
//                    null
            };
            String[] link = {
                    null,
//                    null,
//                    null,
//                    null,
//                    "https://umntvdealers.net/?page_id=34",
            };
            String[] title = {
                    "LIVE TV",
//                    "MOVIES & SERIES",
//                    TITLE_MEDIA_CENTER,
//                    TITLE_DOWNLOAD_CENTER,
//                    "NETWORK",
            };
            int[] resourceId = {
//                    R.drawable.umn_tv_ic_live_tv,
//                    R.drawable.umn_tv_ic_movies_and_series,
                    R.drawable.aaaa,
//                    R.drawable.aaaa
//                    R.drawable.umn_tv_ic_media_center,
//                    R.drawable.umn_tv_ic_download_center,
//                    R.drawable.umn_tv_ic_network,
            };
            String[] packageName = {
                    "ar.tvplayer.tv",
//                    "com.umnmovies.umnmoviesiptvbox",
//                    null,
//                    null,
//                    null,
            };
            String[] backgroundImageUrl = {
                    ResourceHelpers.toStringUri(R.drawable.bg_ironman_replace),
//                    ResourceHelpers.toStringUri(R.drawable.ic_umn_tv_live_tv_banner),
//                    ResourceHelpers.toStringUri(R.drawable.bg_ironman_replace),
//                    ResourceHelpers.toStringUri(R.drawable.ic_umn_tv_media_center_bg_dark),
//                    ResourceHelpers.toStringUri(R.drawable.ic_umn_tv_media_center_icon_new),
//                    ResourceHelpers.toStringUri(R.drawable.umn_tv_bg_download_center),
//                    ResourceHelpers.toStringUri(R.drawable.umn_tv_bg_network)
            };

            for (int index = 0; index < title.length; ++index) {
                umnTvCards.add(
                        buildQuickAppInfo(
                                link[index],
                                title[index],
                                resourceId[index],
                                packageName[index],
                                backgroundImageUrl[index],
                                apkLinkDownload[index]
                        )
                );
            }
        }
        return umnTvCards;
    }

    private static UmnTvCard buildQuickAppInfo(String link, String title, int resourceId, String packageName, String backgroundImageUrl, String linkApkDownload) {
        UmnTvCard u = new UmnTvCard();
        u.setTitle(title);
        u.setLink(link);
        u.setPackageName(packageName);
        u.setBackgroundImageStringUri(backgroundImageUrl);
        u.setIconStringUri(ResourceHelpers.toStringUri(resourceId));
        u.setLinkApkDownload(linkApkDownload);
        return u;
    }
}
