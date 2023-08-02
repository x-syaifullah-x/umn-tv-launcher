package com.umntv.launcher.main.row.games.umn_games;

import android.os.Bundle;

import com.umntv.launcher.main.base.BaseDetailFragment;
import com.umntv.launcher.util.Admob;

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
}
