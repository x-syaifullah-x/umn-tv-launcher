package com.umntv.launcher.base;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import com.umntv.launcher.main.DetailsActivity;
import com.umntv.launcher.main.row.apps.AppsActivity;
import com.umntv.launcher.main.row.apps.app_drawer.AppDrawerFragment;
import com.umntv.launcher.main.row.apps.app_drawer.LaunchApp;
import com.umntv.launcher.main.row.umn_tv.UmnTv;
import com.umntv.launcher.main.row.umn_tv.UmnTvCard;
import com.umntv.launcher.main.row.umn_tv.detail.download_center.DownloadCenterDetailFragment;
import com.umntv.launcher.main.row.umn_tv.media_center.MediaCenterDetailFragment;
import com.umntv.launcher.main.row.utilities.UtilitiesCard;
import com.umntv.launcher.main.row.utilities.details.UtilitiesDetailsActivity;
import com.umntv.launcher.main.row.utilities.details.preload_tv.DetailPreloadTvFragment;
import com.umntv.launcher.main.row.utilities.details.remote_support.DetailRemoteSupporTvFragment;
import com.umntv.launcher.util.AndroidStore;
import com.umntv.launcher.util.view.dialog.ApkUtil;

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
                    case UmnTv.TITLE_DOWNLOAD_CENTER:
                        intent.setAction(DownloadCenterDetailFragment.class.getName());
                        break;
                    case UmnTv.TITLE_MEDIA_CENTER:
                        intent.setAction(MediaCenterDetailFragment.class.getName());
                        break;
                    case UmnTv.TITLE_APP_DRAWER:
                        intent = new Intent(mContext, AppsActivity.class);
                        intent.setAction(AppDrawerFragment.class.getName());
                        break;
                    case UmnTv.TITLE_REMOTE_SUPPORT:
                        intent.setAction(DetailRemoteSupporTvFragment.class.getName());
                        break;
                    case UmnTv.TITLE_PRELOAD_TV:
                        intent.setAction(DetailPreloadTvFragment.class.getName());
                        break;
                }
                mContext.startActivity(intent);
            }
        }
    }
}
