package com.umntv.launcher.main.row.ads.detail.global_girl_net;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import com.umntv.launcher.main.base.ApkData;
import com.umntv.launcher.main.base.BaseDetailFragment;

public class GlobalGirlNetFragment extends BaseDetailFragment {

    public GlobalGirlNetFragment() {
        super(DataSource.items);
    }

    @Override
    protected void openOrDownload(ApkData apkData) {
        try {
            Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(apkData.url));
            requireContext().startActivity(myIntent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(getContext(), "No application can handle this request." + " Please install a webbrowser", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}