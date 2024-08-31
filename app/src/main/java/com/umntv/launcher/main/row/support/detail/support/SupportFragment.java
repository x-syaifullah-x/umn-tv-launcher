package com.umntv.launcher.main.row.support.detail.support;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.umntv.launcher.main.base.ApkData;
import com.umntv.launcher.main.base.BaseDetailFragment;
import com.umntv.launcher.util.Admob;

import net.n0ender.com.R;

public class SupportFragment extends BaseDetailFragment {

    public SupportFragment() {
        super(DataSource.items);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Admob.setup(requireActivity().findViewById(R.id.adView));
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