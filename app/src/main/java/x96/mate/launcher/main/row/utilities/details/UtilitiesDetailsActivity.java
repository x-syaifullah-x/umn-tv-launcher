package x96.mate.launcher.main.row.utilities.details;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import x96.mate.launcher.main.row.utilities.details.remote_support.DetailRemoteSupporTvFragment;

public class UtilitiesDetailsActivity extends FragmentActivity {

    public static final String DATA_EXTRA_REMOTE_SUPPORT = "DATA_EXTRA_REMOTE_SUPPORT";
    public static final String DATA_EXTRA_PRELOAD_TV = "DATA_EXTRA_PRELOAD_TV";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            if (getIntent().getBooleanExtra(DATA_EXTRA_REMOTE_SUPPORT, false)) {
                getSupportFragmentManager().beginTransaction()
                        .replace(android.R.id.content, DetailRemoteSupporTvFragment.class, null)
                        .commitNow();
            }
        }
    }
}
