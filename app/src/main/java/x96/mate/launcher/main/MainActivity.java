package x96.mate.launcher.main;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.fragment.app.FragmentActivity;

import x96.mate.launcher.R;

public class MainActivity extends FragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            handler.postDelayed(() -> {
                setContentView(R.layout.activity_main);
                setTheme(R.style.Theme_Browse);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_browse_fragment, new MainFragment())
                        .commitNow();
            }, 1000);
        }
    }
}