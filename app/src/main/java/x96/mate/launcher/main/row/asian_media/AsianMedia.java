package x96.mate.launcher.main.row.asian_media;

import x96.mate.launcher.R;
import x96.mate.launcher.util.ResourceHelpers;

import java.util.ArrayList;
import java.util.List;

public class AsianMedia {

    private static final List<AsianMediaCard> asianMediaCards = new ArrayList<>();

    public static List<AsianMediaCard> setup() {
        if (asianMediaCards.isEmpty()) {
            String[] title = {
//                    "UMN ASIAN MEDIA",
//                    "JADE CINEMA",
                    "VIKI",
                    "CRUNCHYROLL",
                    "FUNIMATION",
                    "IQIYI",
                    "应用宝官网"
            };
            int[] resourceId = {
//                    R.drawable.asian_media_jade_cinema_ic,
                    R.drawable.ic_asian_media_viki,
                    R.drawable.ic_asian_media_crunchyroll,
                    R.drawable.ic_asian_media_funimation,
                    R.drawable.ic_asian_media_iqiyi,
                    R.drawable.ic_asian_media_tencent,
            };
            String[] packageName = {
//                    null,
                    "com.viki.android",
                    "com.crunchyroll.crunchyroid",
                    "com.Funimation.FunimationNow.androidtv",
                    "com.iqiyi.i18n.tv",
                    "com.tencent.android.qqdownloader",
            };

            String[] apkLinkDownload = {
//                    null,
                    "https://umntvdealers.net/UMNTV/Apks/VIKI.apk",
                    null,
                    "https://umntvdealers.net/UMNTV/Apks/Funimation_.com.apk",
                    null,
                    "https://umntvdealers.net/UMNTV/Apks/应用宝官网.apk"
            };

            for (int index = 0; index < title.length; ++index) {
                AsianMediaCard a = new AsianMediaCard();
                a.setTitle(title[index]);
                a.setPackageName(packageName[index]);
                a.setBackgroundImageStringUri(ResourceHelpers.toStringUri(R.drawable.bg_ironman_replace));
                a.setIconStringUri(ResourceHelpers.toStringUri(resourceId[index]));
                a.setLinkApkDownload(apkLinkDownload[index]);
                asianMediaCards.add(a);
            }
        }
        return asianMediaCards;
    }
}
