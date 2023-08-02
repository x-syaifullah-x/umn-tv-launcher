package x96.mate.launcher.main.row.apps.app_drawer;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import x96.mate.launcher.R;

public class AppDrawerActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_app_drawer);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.app_drawer_fragment, new AppDrawerFragment())
                    .commitNow();
        }
    }
}
