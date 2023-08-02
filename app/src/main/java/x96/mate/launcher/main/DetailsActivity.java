package x96.mate.launcher.main;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

public class DetailsActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            try {
                String fragmentClassName = getIntent().getAction();
                @SuppressWarnings("unchecked")
                Class<Fragment> fragmentClass = (Class<Fragment>) Class.forName(fragmentClassName);
                if (fragmentClassName.isEmpty()) {
                    throw new Error("Please set action in intent");
                }
                getSupportFragmentManager().beginTransaction()
                        .replace(android.R.id.content, fragmentClass, null, null)
                        .commit();
            } catch (Throwable t) {
                t.printStackTrace();
                finishAfterTransition();
            }
        }
    }
}
