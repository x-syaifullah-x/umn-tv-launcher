package com.umntv.launcher.main.row.umn_tv.network;

import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import com.umntv.launcher.main.base.ApkData;
import com.umntv.launcher.main.base.BaseDetailFragment;

public class NetworkDetailFragment extends BaseDetailFragment {

    public NetworkDetailFragment() {
        super(DataSource.items);
    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        Admob.setup(requireActivity().findViewById(R.id.adView));
//    }

    @Override
    public void openOrDownload(ApkData apkData) {
        if (apkData.url.isEmpty() || apkData.packageName == null || apkData.packageName.isEmpty()) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            try {
                intent.setData(Uri.parse(apkData.url));
                intent.setPackage("com.jio.web.androidtv");
                startActivity(intent);
            } catch (Throwable t) {
                Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                String uriString = apkData.url;
                intent.setData(Uri.parse(uriString));
                startActivity(intent);
            }
        } else {
            super.openOrDownload(apkData);
        }
    }
}
