package com.umntv.launcher.main;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import media.umn.tv.R;

public class DetailsActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            try {
                String fragmentClassName = getIntent().getAction();
                @SuppressWarnings("unchecked")
                Class<Fragment> fragmentClass = (Class<Fragment>) Class.forName(fragmentClassName);
                if (fragmentClassName.isEmpty()) {
                    throw new Error("Please set action in intent");
                }
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_browse_fragment, fragmentClass, null, null)
                        .commit();
            } catch (Throwable t) {
                t.printStackTrace();
                finishAfterTransition();
            }
        }
    }
}
