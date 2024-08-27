package com.umntv.launcher.main.row.utilities.details.preload_tv;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
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

import net.n0ender.com.R;

import com.umntv.launcher.main.base.ApkData;
import com.umntv.launcher.main.base.BaseDetailFragment;
import com.umntv.launcher.main.base.OverviewItem;
import com.umntv.launcher.util.view.dialog.DialogEnterCode;
import com.umntv.launcher.util.view.dialog.DialogPassword;
import com.umntv.launcher.util.view.dialog.Download;

import java.util.List;

public class DetailPreloadTvFragment extends BaseDetailFragment {

//    private DetailsSupportFragmentBackgroundController mDetailsBackground;
//
//    private ClassPresenterSelector mPresenterSelector;
//
//    private ArrayObjectAdapter mAdapter;

    public DetailPreloadTvFragment() {
        super(DataSource.items);
    }

    @Override
    protected void openOrDownload(ApkData apkData) {
        if (apkData.url.equalsIgnoreCase(DataSource.URL_SELF_LOAD)) {
            new DialogEnterCode(requireContext())
                    .setOnConfirmListener(code -> {
                        download(apkData.url + "/" + code + ".tmb");
                    }).show();
            return;
        }

        if (apkData.url.equalsIgnoreCase(DataSource.URL_CODE_REQUEST)) {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(apkData.url));
            startActivity(i);
            return;
        }

        download(apkData.url);
    }

    //    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        mDetailsBackground = new DetailsSupportFragmentBackgroundController(this);
//        mPresenterSelector = new ClassPresenterSelector();
//        mAdapter = new ArrayObjectAdapter(mPresenterSelector);
//
//        setupDetailsOverviewRow();
//        setupDetailsOverviewRowPresenter();
//
//        setAdapter(mAdapter);
//        initializeBackground();
//    }

//    private void setupDetailsOverviewRow() {
//        String title = "LIVE TV SETTINGS<GENERAL<RESTORE";
//        String body = "LIVE TV < SETTINGS < GENERAL < RESTORE < (Select local backup)<(Internal shared storage) < download < PRELOADED#";
////        String body = "Some of these apps are available in the Google play-store\n\n\nUPDATE LAUNCHER INTEL. Please Clear Launcher data after installation";
//        final DetailsOverviewRow row = new DetailsOverviewRow(
//                new DetailPreloadItem(title, body)
//        );
//        row.setImageDrawable(ContextCompat.getDrawable(requireActivity(), R.drawable.default_background));
//        row.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_utilities_preload_tv_new));
//
//        ArrayObjectAdapter actionAdapter = new ArrayObjectAdapter();
//
//        for (int i = 0; i < data.length; i++) {
//            actionAdapter.add(new Action(i, data[i][0]));
//        }
//
//        row.setActionsAdapter(actionAdapter);
//        mAdapter.add(row);
//    }

//    private static final String LINK_SELF_LOAD = "https://n0render.com/Selfload";

//    private static final String CODE_REQUEST = "https://n0render.com/self-loaded-preload";

    /**
     * [0] TITLE
     * [1] LINK
     * [2] PASSWORD
     */
//    private final String[][] data = new String[][]{
//            {"WELCOME", "https://n0render.com/N0Launcher/Preloads/welcome.tmb", "_+N0"},
//            {"WELCOME BACK", "https://n0render.com/N0Launcher/Preloads/welcome2.tmb", "_+N0"},
//            {"MAC", "https://n0render.com/N0Launcher/Preloads/mac.tmb", "_+N0"},
//            {"CUSTOMER 1", "https://n0render.com/N0Launcher/Preloads/cus1.tmb", "_+N0"},
//            {"CUSTOMER 2", "https://n0render.com/N0Launcher/Preloads/cus2.tmb", "_+N0"},
//            {"SELF LOAD", LINK_SELF_LOAD, ""},
//            {"Code Request", CODE_REQUEST, ""},
//    };

//    private void setupDetailsOverviewRowPresenter() {
//        // Set detail background.
//        FullWidthDetailsOverviewRowPresenter detailsPresenter = new FullWidthDetailsOverviewRowPresenter(
//                new DetailPreloadDescriptionPresenter()
//        );
//
//        detailsPresenter.setBackgroundColor(ContextCompat.getColor(requireActivity(), R.color.selected_background));
//
//        // Hook up transition element.
//        FullWidthDetailsOverviewSharedElementHelper sharedElementHelper = new FullWidthDetailsOverviewSharedElementHelper();
//        sharedElementHelper.setSharedElementEnterTransition(getActivity(), "hero");
//        detailsPresenter.setListener(sharedElementHelper);
//        detailsPresenter.setParticipatingEntranceTransition(true);
//
//        detailsPresenter.setOnActionClickedListener(action -> {
//
//            String title = data[(int) action.getId()][0];
//            String link = data[(int) action.getId()][1];
//            String password = data[(int) action.getId()][2];
//
//            if (password.isEmpty() && link.equalsIgnoreCase(CODE_REQUEST)) {
//                Intent i = new Intent(Intent.ACTION_VIEW);
//                i.setData(Uri.parse(link));
//                startActivity(i);
//                return;
//            }
//
//            if (password.isEmpty() && link.equalsIgnoreCase(LINK_SELF_LOAD)) {
//                new DialogEnterCode(requireContext())
//                        .setOnConfirmListener(code -> {
//                            download(LINK_SELF_LOAD + code + ".tmb");
//                        }).show();
//                return;
//            }
//
//            new DialogPassword(requireContext(), password)
//                    .setInputPasswordHint("Please enter the password to access " + title)
//                    .setOnConfirmListener(() -> download(link))
//                    .show();
//        });
//        mPresenterSelector.addClassPresenter(DetailsOverviewRow.class, detailsPresenter);
//    }
    private void download(String link) {
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

    private String link = null;

    ActivityResultLauncher<String> requestPermission = registerForActivityResult(new ActivityResultContracts.RequestPermission(), result -> {
        if (result) {
            Download.toPublicDirectoryDownload(requireContext(), link);
        } else {
            /*  */
        }
    });

//    private void initializeBackground() {
//        mDetailsBackground.enableParallax();
//        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.ic_utilities_preload_tv_new);
//        mDetailsBackground.setCoverBitmap(b);
//    }
}
