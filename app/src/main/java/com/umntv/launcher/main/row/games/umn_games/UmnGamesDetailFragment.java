package com.umntv.launcher.main.row.games.umn_games;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.umntv.launcher.main.base.ApkData;
import com.umntv.launcher.main.base.BaseDetailFragment;
import com.umntv.launcher.main.base.OverviewItem;
import com.umntv.launcher.main.row.games.umn_games.DataSource;
import com.umntv.launcher.util.Admob;
import com.umntv.launcher.util.AndroidStore;
import com.umntv.launcher.util.view.dialog.ApkUtil;

import media.umn.tv.R;

public class UmnGamesDetailFragment extends BaseDetailFragment {
    public UmnGamesDetailFragment() {
        super(DataSource.items);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Admob.setup(requireActivity().findViewById(R.id.adView));
    }

    @Override
    protected void onActionClickListener(OverviewItem overviewItem) {
        ApkData apkData = overviewItem.apkData;
        Intent launchIntent = requireContext()
                .getPackageManager()
                .getLaunchIntentForPackage(apkData.packageName);
        try {
            if (launchIntent == null) {
                launchIntent = new Intent();
                launchIntent.setPackage(apkData.packageName);
                launchIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            }
            launchIntent.setData(Uri.parse(apkData.url));
//                launchIntent.addCategory("android.intent.category.LEANBACK_LAUNCHER");
            requireContext().startActivity(launchIntent);
        } catch (Throwable e) {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setPackage("com.jio.web.androidtv");
            i.setData(Uri.parse(apkData.url));
            startActivity(i);
        }
    }
}
