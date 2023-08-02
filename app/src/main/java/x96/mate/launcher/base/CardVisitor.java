package x96.mate.launcher.base;

import android.content.Context;
import android.content.Intent;

import x96.mate.launcher.main.row.apps.AppsCard;
import x96.mate.launcher.main.row.apps.app_drawer.AppDrawerActivity;
import x96.mate.launcher.main.row.apps.app_drawer.AppDrawerCard;
import x96.mate.launcher.main.row.apps.app_drawer.LaunchApp;
import x96.mate.launcher.main.row.asian_media.AsianMediaCard;
import x96.mate.launcher.main.row.games.GamesCardApp;
import x96.mate.launcher.main.row.kids.KidsCard;
import x96.mate.launcher.main.row.news.NewsCard;
import x96.mate.launcher.main.row.news.detail.NewsDetailsActivity;
import x96.mate.launcher.main.row.radio.RadioCard;
import x96.mate.launcher.main.row.radio.detail.RadioDetailsActivity;
import x96.mate.launcher.main.row.umn_tv.UmnTvCard;
import x96.mate.launcher.main.row.utilities.UtilitiesCard;
import x96.mate.launcher.main.row.utilities.details.UtilitiesDetailsActivity;
import x96.mate.launcher.util.AndroidStore;

public class CardVisitor {

    private final Context mContext;

    public CardVisitor(Context context) {
        mContext = context;
    }

    public void click(LaunchApp launchApp) {
        Intent launchIntent = mContext.getPackageManager().getLaunchIntentForPackage(launchApp.getPackageName());
        if (launchIntent != null) {
            mContext.startActivity(launchIntent);
        }
    }

    public void click(AppDrawerCard appDrawerCard) {
        Intent intent = new Intent(mContext, AppDrawerActivity.class);
        mContext.startActivity(intent);
    }

    public void click(NewsCard newsCard) {
        if (newsCard.getPackageName() != null) {
            Intent launchIntent = mContext.getPackageManager().getLaunchIntentForPackage(newsCard.getPackageName());
            if (launchIntent != null) {
                mContext.startActivity(launchIntent);
            } else {
                AndroidStore.open(mContext, newsCard.getPackageName());
            }
        } else {
            Intent intent = new Intent(mContext, NewsDetailsActivity.class);
            intent.putExtra(NewsDetailsActivity.ITEM, newsCard);
            mContext.startActivity(intent);
        }
    }


    public void click(RadioCard radioCard) {
        if (radioCard.getPackageName() != null) {
            Intent launchIntent = mContext.getPackageManager().getLaunchIntentForPackage(radioCard.getPackageName());
            if (launchIntent != null) {
                /* open application */
                mContext.startActivity(launchIntent);
            } else {
                AndroidStore.open(mContext, radioCard.getPackageName());
            }
        } else {
            Intent intent = new Intent(mContext, RadioDetailsActivity.class);
            intent.putExtra(RadioDetailsActivity.ITEM, radioCard);
            mContext.startActivity(intent);
        }
    }

    public void click(UtilitiesCard utilitiesCard) {
        if (utilitiesCard.getDataExtra() != null) {
            Intent i = new Intent(mContext, UtilitiesDetailsActivity.class);
            i.putExtra(utilitiesCard.getDataExtra(), true);
            mContext.startActivity(i);
        } else if (utilitiesCard.getPackageName() != null) {
            Intent launchIntent = mContext.getPackageManager().getLaunchIntentForPackage(utilitiesCard.getPackageName());
            if (launchIntent != null) {
                mContext.startActivity(launchIntent);
            } else {
                AndroidStore.open(mContext, utilitiesCard.getPackageName());
            }
        }
    }

    public void click(KidsCard kidsCard) {
        Intent launchIntent = mContext.getPackageManager().getLaunchIntentForPackage(kidsCard.getPackageName());
        if (launchIntent != null) {
            mContext.startActivity(launchIntent);
        } else {
            AndroidStore.open(mContext, kidsCard.getPackageName());
        }
    }

    public void click(UmnTvCard umnTvCard) {
        if (umnTvCard.getPackageName() != null) {
            /* open application or download apk */
            Intent launchIntent = mContext.getPackageManager().getLaunchIntentForPackage(umnTvCard.getPackageName());
            if (launchIntent != null) {
                /* open application */
                mContext.startActivity(launchIntent);
            } else {
                AndroidStore.open(mContext, umnTvCard.getPackageName());
            }
        }
    }

    public void click(GamesCardApp gamesCardApp) {
        Intent launchIntent = mContext.getPackageManager().getLaunchIntentForPackage(gamesCardApp.getPackageName());
        if (launchIntent != null) {
            mContext.startActivity(launchIntent);
        } else {
            AndroidStore.open(mContext, gamesCardApp.getPackageName());
        }
    }

    public void click(AsianMediaCard asianMediaCard) {
        Intent launchIntent = mContext.getPackageManager().getLaunchIntentForPackage(asianMediaCard.getPackageName());
        if (launchIntent != null) {
            mContext.startActivity(launchIntent);
        } else {
            AndroidStore.open(mContext, asianMediaCard.getPackageName());
        }
    }

    public void click(AppsCard appsCard) {
        if (appsCard.getPackageName() != null) {
            Intent launchIntent = mContext.getPackageManager().getLaunchIntentForPackage(appsCard.getPackageName());
            if (launchIntent != null) {
                mContext.startActivity(launchIntent);
            } else {
                AndroidStore.open(mContext, appsCard.getPackageName());
            }
        } else {
            try {
                mContext.startActivity(new Intent(mContext, Class.forName(appsCard.getClassNameActivityDetail())));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
