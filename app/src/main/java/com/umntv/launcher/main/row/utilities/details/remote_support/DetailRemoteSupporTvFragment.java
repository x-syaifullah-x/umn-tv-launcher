package com.umntv.launcher.main.row.utilities.details.remote_support;

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

import media.umn.tv.R;
import com.umntv.launcher.util.AndroidStore;
import com.umntv.launcher.util.view.dialog.ApkUtil;
import com.umntv.launcher.util.view.dialog.Download;

public class DetailRemoteSupporTvFragment extends DetailsSupportFragment {

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
        String title = "REMOTE SUPPORT";
        String body = "";
//        String body = "Some of these apps are available in the Google play-store\n\n\nUPDATE LAUNCHER INTEL. Please Clear Launcher data after installation";
        final DetailsOverviewRow row = new DetailsOverviewRow(
                new DetailRemoteSupportItem(title, body)
        );
        row.setImageDrawable(ContextCompat.getDrawable(requireActivity(), R.drawable.default_background));
        row.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_utilities_remote_support));

        ArrayObjectAdapter actionAdapter = new ArrayObjectAdapter();

        for (int i = 0; i < data.length; i++) {
            actionAdapter.add(new Action(i, data[i][0]));
        }

        row.setActionsAdapter(actionAdapter);
        mAdapter.add(row);
    }

    private static final int DATA_LINK = 1;
    private static final int DATA_PACKAGE_NAME = 2;

    private final String[][] data = new String[][]{
            /* ID 1 */
            {"ANYDESK", null, "com.anydesk.anydeskandroid"},
            /* ID 2 */
            {"TEAMVIEWER", "https://umntvdealers.net/UMNTV/Apks/QuickSupport-15.21.113.apk", "com.teamviewer.quicksupport.market"},
            /* ID 3 */
            {"TV ADDON", "https://umntvdealers.net/UMNTV/Apks/QuickSupport Add-On-10.0.3086.apk", "com.teamviewer.quicksupport.addon.aosp"},
            /* ID 4 */
            {"ZIP-UPLOAD", "https://umntvdealers.net/UMNTV/Apks/zip-upload.zip", null},
            /* ID 5 */
            {"APK-UPLOAD", "https://umntvdealers.net/UMNTV/Apks/apk-upload.apk", null},
            /* ID 6 */
            {"BUTTON MAP", "https://umntvdealers.net/UMNTV/Apks/Button-Mapper-Pro).apk", "flar2.homebutton"},
    };

    private void setupDetailsOverviewRowPresenter() {
        // Set detail background.
        FullWidthDetailsOverviewRowPresenter detailsPresenter = new FullWidthDetailsOverviewRowPresenter(
                new DetailRemoteSupportDescriptionPresenter()
        );

        detailsPresenter.setBackgroundColor(ContextCompat.getColor(requireActivity(), R.color.selected_background));

        // Hook up transition element.
        FullWidthDetailsOverviewSharedElementHelper sharedElementHelper = new FullWidthDetailsOverviewSharedElementHelper();
        sharedElementHelper.setSharedElementEnterTransition(getActivity(), "hero");
        detailsPresenter.setListener(sharedElementHelper);
        detailsPresenter.setParticipatingEntranceTransition(true);

        detailsPresenter.setOnActionClickedListener(action -> {

            int id = (int) action.getId();
            String link = data[id][DATA_LINK];
            String packageName = data[id][DATA_PACKAGE_NAME];
            boolean isApk = packageName != null;

            if (isApk) {
                Intent launchIntent = requireContext().getPackageManager().getLaunchIntentForPackage(packageName);
                if (launchIntent != null) {
                    requireContext().startActivity(launchIntent);
                } else if (link != null) {
                    ApkUtil.downloadToCacheDirAndInstall(requireContext(), link);
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
                            this.link = link;
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

    String link = null;

    ActivityResultLauncher<String> requestPermission = registerForActivityResult(new ActivityResultContracts.RequestPermission(), result -> {
        if (result) {
            Download.toPublicDirectoryDownload(requireContext(), link);
        } else {
            /*  */
        }
    });

    private void initializeBackground() {
        mDetailsBackground.enableParallax();
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.ic_utilities_remote_support);
        mDetailsBackground.setCoverBitmap(b);
    }
}
