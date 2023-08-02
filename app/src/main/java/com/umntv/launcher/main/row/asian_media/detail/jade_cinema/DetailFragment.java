package com.umntv.launcher.main.row.asian_media.detail.jade_cinema;

import android.os.Bundle;

import com.umntv.launcher.main.base.BaseDetailFragment;
import com.umntv.launcher.util.Admob;

import media.umn.tv.R;

public class DetailFragment extends BaseDetailFragment {
    public DetailFragment() {
        super(DataSource.items);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Admob.setup(requireActivity().findViewById(R.id.adView));
    }
}