package com.umntv.launcher.main.row.games.umn_retro;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.umntv.launcher.main.base.ApkData;
import com.umntv.launcher.main.base.BaseDetailFragment;
import com.umntv.launcher.main.base.OverviewItem;
import com.umntv.launcher.util.Admob;

import media.umn.tv.R;

public class UmnRetroDetailFragment extends BaseDetailFragment {
    public UmnRetroDetailFragment() {
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
        if (apkData.url.contains(DataSource.ADB_REMOTE_COMMAND)) {
            String[] a = apkData.url.split("=");
            String command = a[0];
            String url = a[1];
            ClipboardManager clipboard = (ClipboardManager) requireContext().getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("command", command);
            clipboard.setPrimaryClip(clip);
            Toast.makeText(getContext(), "Successfully copy link", Toast.LENGTH_LONG).show();
            openOrDownload(
                    new ApkData(url, apkData.packageName, apkData.isPrivate)
            );
        } else {
            super.onActionClickListener(overviewItem);
        }
    }
}
