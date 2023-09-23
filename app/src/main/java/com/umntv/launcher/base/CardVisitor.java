package com.umntv.launcher.base;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import com.umntv.launcher.main.DetailsActivity;
import com.umntv.launcher.main.row.ads.AdsCard;
import com.umntv.launcher.main.row.ads.detail.AdsDetailsActivity;
import com.umntv.launcher.main.row.apps.AppsActivity;
import com.umntv.launcher.main.row.apps.AppsCard;
import com.umntv.launcher.main.row.apps.app_drawer.AppDrawerCard;
import com.umntv.launcher.main.row.apps.app_drawer.AppDrawerFragment;
import com.umntv.launcher.main.row.apps.app_drawer.LaunchApp;
import com.umntv.launcher.main.row.asian_media.AsianMediaCard;
import com.umntv.launcher.main.row.asian_media.detail.jade_cinema.DetailFragment;
import com.umntv.launcher.main.row.games.GamesCardApp;
import com.umntv.launcher.main.row.games.umn_games.UmnGamesDetailFragment;
import com.umntv.launcher.main.row.kids.KidsCard;
import com.umntv.launcher.main.row.movies_apps.MoviesAppsCard;
import com.umntv.launcher.main.row.news_or_media.domain.model.NewsMediaModel;
import com.umntv.launcher.main.row.news_or_media.presentation.detail.IntNewsFragment;
import com.umntv.launcher.main.row.news_or_media.presentation.detail.NewsDetailsActivity;
import com.umntv.launcher.main.row.news_or_media.presentation.detail.youtube_shorts.YoutubeShortsFragment;
import com.umntv.launcher.main.row.radio.RadioCard;
import com.umntv.launcher.main.row.radio.detail.RadioDetailsActivity;
import com.umntv.launcher.main.row.umn_tv.UmnTv;
import com.umntv.launcher.main.row.umn_tv.UmnTvCard;
import com.umntv.launcher.main.row.umn_tv.detail.download_center.DownloadCenterDetailFragment;
import com.umntv.launcher.main.row.umn_tv.faq.FaqDetailFragment;
import com.umntv.launcher.main.row.umn_tv.media_center.MediaCenterDetailFragment;
import com.umntv.launcher.main.row.umn_tv.network.NetworkDetailFragment;
import com.umntv.launcher.main.row.utilities.UtilitiesCard;
import com.umntv.launcher.main.row.utilities.details.UtilitiesDetailsActivity;
import com.umntv.launcher.util.AndroidStore;
import com.umntv.launcher.util.view.dialog.ApkUtil;

public class CardVisitor {

    private final Context mContext;

    public CardVisitor(Context context) {
        mContext = context;
    }

    public void click(MoviesAppsCard card) {
        String packageName = card.getPackageName();
        if (packageName != null) {
            Intent launchIntent = mContext.getPackageManager().getLaunchIntentForPackage(packageName);
            if (launchIntent != null) {
                mContext.startActivity(launchIntent);
            } else {
                String apkUrl = card.getApkUrl();
                if (apkUrl != null) {
                    ApkUtil.downloadToCacheDirAndInstall(mContext, apkUrl);
                } else {
                    AndroidStore.open(mContext, packageName);
                }
            }
        }
    }

    public void click(LaunchApp launchApp) {
        Intent launchIntent = mContext.getPackageManager().getLaunchIntentForPackage(launchApp.getPackageName());
        if (launchIntent != null) {
            mContext.startActivity(launchIntent);
        }
    }

    public void click(AppDrawerCard appDrawerCard) {
        Intent intent = new Intent(mContext, AppsActivity.class);
        mContext.startActivity(intent);
    }

    public void click(AdsCard adsCard) {
        Intent intent = new Intent(mContext, AdsDetailsActivity.class);
        intent.putExtra(AdsDetailsActivity.ITEM, adsCard);
        mContext.startActivity(intent);
    }

    public void click(NewsMediaModel newsMediaModel) {
        String packageName = newsMediaModel.getPackageName();
        if (packageName != null) {
            Intent launchIntent = mContext.getPackageManager().getLaunchIntentForPackage(packageName);
            if (launchIntent != null) {
                mContext.startActivity(launchIntent);
            } else {
                String apkUrl = newsMediaModel.getApkUrl();
                if (apkUrl != null) {
                    ApkUtil.downloadToCacheDirAndInstall(mContext, apkUrl);
                } else {
                    AndroidStore.open(mContext, packageName);
                }
            }
        } else {
            if (newsMediaModel.getTitle().equals("INT NEWS")) {
                Intent intent = new Intent(mContext, DetailsActivity.class);
                intent.setAction(IntNewsFragment.class.getName());
                mContext.startActivity(intent);
            } else if (newsMediaModel.getTitle().equals("YOUTUBE SHORTS")) {
                Intent intent = new Intent(mContext, DetailsActivity.class);
                intent.setAction(YoutubeShortsFragment.class.getName());
                mContext.startActivity(intent);
            } else {
                Intent intent = new Intent(mContext, NewsDetailsActivity.class);
                intent.putExtra(NewsDetailsActivity.ITEM, newsMediaModel);
                mContext.startActivity(intent);
            }
        }
    }


    public void click(RadioCard radioCard) {
        if (radioCard.getPackageName() != null) {
            Intent launchIntent = mContext.getPackageManager().getLaunchIntentForPackage(radioCard.getPackageName());
            if (launchIntent != null) {
                /* open application */
                mContext.startActivity(launchIntent);
            } else {
                if (radioCard.getLinkApkDownload() != null) {
                    /* download apk */
                    ApkUtil.downloadToCacheDirAndInstall(mContext, radioCard.getLinkApkDownload());
                } else {
                    /* open play store */
                    AndroidStore.open(mContext, radioCard.getPackageName());
                }
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
                if (utilitiesCard.getLinkApkDownload() != null) {
                    ApkUtil.downloadToCacheDirAndInstall(mContext, utilitiesCard.getLinkApkDownload());
                } else {
                    /* open play store */
                    AndroidStore.open(mContext, utilitiesCard.getPackageName());
                }
            }
        }
    }

    public void click(KidsCard kidsCard) {
        Intent launchIntent = mContext.getPackageManager().getLaunchIntentForPackage(kidsCard.getPackageName());
        if (launchIntent != null) {
            mContext.startActivity(launchIntent);
        } else {
            if (kidsCard.getLinkApkDownload() != null) {
                ApkUtil.downloadToCacheDirAndInstall(mContext, kidsCard.getLinkApkDownload());
            } else {
                /* open play store */
                AndroidStore.open(mContext, kidsCard.getPackageName());
            }
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
                ApkUtil.downloadToCacheDirAndInstall(mContext, umnTvCard.getLinkApkDownload());
            }
        } else {
            /* open browser or open detail */
            if (umnTvCard.getLink() != null) {
                /* open browser */
                try {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(umnTvCard.getLink()));
                    myIntent.setPackage("com.android.chrome");
                    mContext.startActivity(myIntent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(mContext, "No application can handle this request." + " Please install a web browser", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            } else {
                String title = umnTvCard.getTitle();
                Intent intent = new Intent(mContext, DetailsActivity.class);
                switch (title) {
                    case UmnTv.TITLE_NETWORK:
                        intent.setAction(NetworkDetailFragment.class.getName());
                        System.out.println("masuk");
                        break;
                    case UmnTv.TITLE_DOWNLOAD_CENTER:
                        intent.setAction(DownloadCenterDetailFragment.class.getName());
                        break;
                    case UmnTv.TITLE_MEDIA_CENTER:
                        intent.setAction(MediaCenterDetailFragment.class.getName());
                        break;
                    case UmnTv.TITLE_FAQ:
                        intent.setAction(FaqDetailFragment.class.getName());
                        break;
                    case UmnTv.TITLE_APP_DRAWER:
                        intent = new Intent(mContext, AppsActivity.class);
                        intent.setAction(AppDrawerFragment.class.getName());
                        break;
                }
                mContext.startActivity(intent);
            }
        }
    }

    public void click(GamesCardApp gamesCardApp) {
        if (gamesCardApp.getPackageName() == null) {
            Intent intent = new Intent(mContext, DetailsActivity.class);
            intent.setAction(UmnGamesDetailFragment.class.getName());
            mContext.startActivity(intent);
        } else {
            Intent launchIntent = mContext.getPackageManager().getLaunchIntentForPackage(gamesCardApp.getPackageName());
            if (launchIntent != null) {
                mContext.startActivity(launchIntent);
            } else {
                if (gamesCardApp.getLinkApkDownload() != null) {
                    ApkUtil.downloadToCacheDirAndInstall(mContext, gamesCardApp.getLinkApkDownload());
                } else {
                    AndroidStore.open(mContext, gamesCardApp.getPackageName());
                }
            }
        }
    }

    public void click(AsianMediaCard asianMediaCard) {
        if (asianMediaCard.getPackageName() == null) {
            Intent intent = new Intent(mContext, DetailsActivity.class);
            intent.setAction(DetailFragment.class.getName());
            mContext.startActivity(intent);
            return;
        }

        Intent launchIntent = mContext.getPackageManager().getLaunchIntentForPackage(asianMediaCard.getPackageName());
        if (launchIntent != null) {
            mContext.startActivity(launchIntent);
        } else {
            if (asianMediaCard.getLinkApkDownload() != null) {
                ApkUtil.downloadToCacheDirAndInstall(mContext, asianMediaCard.getLinkApkDownload());
            } else {
                AndroidStore.open(mContext, asianMediaCard.getPackageName());
            }
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
            Intent intent = new Intent(mContext, AppsActivity.class);
            intent.setAction(appsCard.getClassNameActivityDetail());
            mContext.startActivity(intent);
        }
    }
}
