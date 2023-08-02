package x96.mate.launcher.main.row.apps.movies_apps;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.leanback.app.DetailsSupportFragment;
import androidx.leanback.app.DetailsSupportFragmentBackgroundController;
import androidx.leanback.widget.Action;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.ClassPresenterSelector;
import androidx.leanback.widget.DetailsOverviewRow;
import androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter;
import androidx.leanback.widget.FullWidthDetailsOverviewSharedElementHelper;

import java.util.Locale;

import x96.mate.launcher.util.AndroidStore;
import x96.mate.launcher.util.view.dialog.Download;
import x96.mate.launcher.R;

public class MoviesDetailFragment extends DetailsSupportFragment {

    ActivityResultLauncher<String> requestPermission = registerForActivityResult(new ActivityResultContracts.RequestPermission(), result -> {
        if (result) {

        } else {
            /*  */
        }
    });

    private DetailsSupportFragmentBackgroundController mDetailsBackground;

    private ClassPresenterSelector mPresenterSelector;

    private ArrayObjectAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDetailsBackground = new DetailsSupportFragmentBackgroundController(this);
        mPresenterSelector = new ClassPresenterSelector();
        mAdapter = new ArrayObjectAdapter(mPresenterSelector);

        setupDetailsOverviewRow();
        setupDetailsOverviewRowPresenter();

        setAdapter(mAdapter);
        initializeBackground();
    }

    private void setupDetailsOverviewRow() {
        String title = "ENJOY YOUR MOVIE APPS";

        final DetailsOverviewRow row = new DetailsOverviewRow(
                new MoviesItemCard(title, null)
        );
        row.setImageDrawable(ContextCompat.getDrawable(requireActivity(), R.drawable.default_background));
        row.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_apps_movies_apps_detail));

        ArrayObjectAdapter actionAdapter = new ArrayObjectAdapter();

        for (int i = 0; i < data.length; i++) {
            actionAdapter.add(new Action(i, data[i][0]));
        }

        row.setActionsAdapter(actionAdapter);

        mAdapter.add(row);
    }

    private void setupDetailsOverviewRowPresenter() {
        // Set detail background.
        FullWidthDetailsOverviewRowPresenter detailsPresenter =
                new FullWidthDetailsOverviewRowPresenter(new MoviesDetailDescriptionPresenter());
        detailsPresenter.setBackgroundColor(ContextCompat.getColor(requireActivity(), R.color.selected_background));

        // Hook up transition element.
        FullWidthDetailsOverviewSharedElementHelper sharedElementHelper = new FullWidthDetailsOverviewSharedElementHelper();
        sharedElementHelper.setSharedElementEnterTransition(getActivity(), "hero");
        detailsPresenter.setListener(sharedElementHelper);
        detailsPresenter.setParticipatingEntranceTransition(true);

        detailsPresenter.setOnActionClickedListener(action -> {
            String packageName = data[(int) action.getId()][1];
            String link = data[(int) action.getId()][2];
            if (packageName != null) {
                Intent launchIntent = requireContext().getPackageManager().getLaunchIntentForPackage(packageName);
                if (launchIntent != null) {
                    requireContext().startActivity(launchIntent);
                } else {
                    AndroidStore.open(requireContext(), packageName);
                }
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    Download.toPublicDirectoryDownload(requireContext(), link);
                } else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        int checkSelfPermission = ActivityCompat.checkSelfPermission(
                                requireContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE
                        );
                        boolean isGranted = checkSelfPermission == PackageManager.PERMISSION_GRANTED;

                        if (isGranted) {
                            Download.toPublicDirectoryDownload(requireContext(), link);
                        } else {
                            requestPermission.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE);
                        }
                    } else {
                        Download.toPublicDirectoryDownload(requireContext(), link);
                    }
                }
            }
        });
        mPresenterSelector.addClassPresenter(DetailsOverviewRow.class, detailsPresenter);
    }

    private final String[][] data = {
            {"XFINITY", "com.xfinity.cloudtvr", "https://umntvdealers.net/UMNTV/Apks/Xfinity Streamcom.apk"},
            {"NETFLIX", "com.netflix.mediaclient", null},
            {"HULU", "com.HULU.LIVINGROOMPLUS".toLowerCase(Locale.ROOT), null},
            {"AMAZON PRIME", "com.AMAZON.AVOD.THIRDPARTYCLIENT".toLowerCase(Locale.ROOT), null},
            {"APPLE TV", "com.apple.atve.androidtv.appletv", null}
    };

    private void initializeBackground() {
        mDetailsBackground.enableParallax();
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.ic_apps_movies_apps_banner);
        mDetailsBackground.setCoverBitmap(b);
    }
}
