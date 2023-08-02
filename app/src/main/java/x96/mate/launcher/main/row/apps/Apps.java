package x96.mate.launcher.main.row.apps;

import x96.mate.launcher.R;
import x96.mate.launcher.main.row.apps.app_drawer.AppDrawerActivity;
import x96.mate.launcher.base.Card;
import x96.mate.launcher.main.row.apps.movies_apps.MoviesActivity;
import x96.mate.launcher.util.ResourceHelpers;

import java.util.ArrayList;
import java.util.List;

public class Apps {

    private static final List<Card> list = new ArrayList<>();

    public static List<Card> setup() {
        if (!list.isEmpty()) return list;

        String[] title = {
                "APP DRAWER",
                "Google Play",
                "CHROME ",
                "MOVIE APPS",
                "FACEBOOK WATCH",
        };
        int[] resourceId = {
                R.drawable.ic_apps_app_drawer,
                R.drawable.ic_apps_google_play,
                R.drawable.ic_apps_chrome,
                R.drawable.ic_apps_movies_apps,
                R.drawable.ic_apps_facebook_watch,
        };
        String[] packageName = {
                null,
                "com.android.vending",
                "com.android.chrome",
                null,
                "com.facebook.katana",
        };

        String backgroundImageUrl = ResourceHelpers.toStringUri(R.drawable.bg_ironman_replace);

        String[] detailClass = {
                AppDrawerActivity.class.getName(),
                null,
                null,
                MoviesActivity.class.getName(),
                null,
        };

        for (int index = 0; index < title.length; ++index) {
            AppsCard a = new AppsCard();
            a.setClassNameActivityDetail(detailClass[index]);
            a.setTitle(title[index]);
            a.setPackageName(packageName[index]);
            a.setBackgroundImageStringUri(backgroundImageUrl);
            a.setIconStringUri(ResourceHelpers.toStringUri(resourceId[index]));
            list.add(a);
        }
        return list;
    }
}
