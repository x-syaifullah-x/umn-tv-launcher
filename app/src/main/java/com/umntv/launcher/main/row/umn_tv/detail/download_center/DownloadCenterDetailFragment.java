package com.umntv.launcher.main.row.umn_tv.detail.download_center;

import android.os.Bundle;

import com.umntv.launcher.main.base.BaseDetailFragment;
import com.umntv.launcher.util.Admob;

import media.umn.tv.R;

public class DownloadCenterDetailFragment extends BaseDetailFragment {
    public DownloadCenterDetailFragment() {
        super(DataSource.items);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Admob.setup(requireActivity().findViewById(R.id.adView));
    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        RssView.show(requireView());
//    }
}
