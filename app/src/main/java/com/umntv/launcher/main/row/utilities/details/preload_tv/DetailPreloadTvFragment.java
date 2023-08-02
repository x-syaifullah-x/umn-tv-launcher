package com.umntv.launcher.main.row.utilities.details.preload_tv;

import android.Manifest;
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
import com.umntv.launcher.util.view.dialog.Download;

public class DetailPreloadTvFragment extends DetailsSupportFragment {

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
        String title = "LIVE TV SETTINGS<GENERAL<RESTORE";
        String body = "LIVE TV < SETTINGS < GENERAL < RESTORE < (Select local backup)<(Internal shared storage) < download < PRELOADED#";
//        String body = "Some of these apps are available in the Google play-store\n\n\nUPDATE LAUNCHER INTEL. Please Clear Launcher data after installation";
        final DetailsOverviewRow row = new DetailsOverviewRow(
                new DetailPreloadItem(title, body)
        );
        row.setImageDrawable(ContextCompat.getDrawable(requireActivity(), R.drawable.default_background));
        row.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_utilities_preload_tv));

        ArrayObjectAdapter actionAdapter = new ArrayObjectAdapter();

        for (int i = 0; i < data.length; i++) {
            actionAdapter.add(new Action(i, data[i][0]));
        }

        row.setActionsAdapter(actionAdapter);
        mAdapter.add(row);
    }

    private final String[][] data = new String[][]{
//            {"PRELOAD 1", "https://drive.google.com/uc?export=download&id=1dD2HL8J3t-iV75SfuG_cw79WDklZ11pZ"},
//            {"PRELOAD 2", "https://drive.google.com/uc?export=download&id=1inWdqZIC7hRTkSFfP5aGoT7QabG2hPWA"},
//            {"PRELOAD 3", "https://drive.google.com/uc?export=download&id=10hZdOjjUk3tnZN8fcGp9q3cb2wUX8w0i"},
//            {"PRELOAD 4", "https://drive.google.com/uc?export=download&id=1TyPVgq2WmnnCt-4ObZAtsNBEomGUPEsP"},
//            {"PRELOAD 5", "https://drive.google.com/uc?export=download&id=1ELtZMRFNZ3rHclJwHS_NvUT-Jrst5rP9"},

            {"Standard", "https://drive.google.com/uc?export=download&id=17AUtwlkvtz-c9W9BbA-mZaOVA6ZVu9Wm"},
            {"UNIVERSAL", "https://drive.google.com/uc?export=download&id=1ALtxZ1SIn5tIYLU4gpt4epQNHn0qDubA"},
            {"DOMESTIC", "https://drive.google.com/uc?export=download&id=1Teu5bZ8jpxZvHyOvet3uqWbtIrsNnBIH"},
            {"CUSTOMER 1", "https://drive.google.com/uc?export=download&id=1kUA69jkju6v8lbPw9IymyFUNQMhHAlqB"},
            {"CUSTOMER 2", "https://drive.google.com/uc?export=download&id=1OcZAtM3kT17qPiNad63PDB8s7h7yXW_b"},
    };

    private void setupDetailsOverviewRowPresenter() {
        // Set detail background.
        FullWidthDetailsOverviewRowPresenter detailsPresenter = new FullWidthDetailsOverviewRowPresenter(
                new DetailPreloadDescriptionPresenter()
        );

        detailsPresenter.setBackgroundColor(ContextCompat.getColor(requireActivity(), R.color.selected_background));

        // Hook up transition element.
        FullWidthDetailsOverviewSharedElementHelper sharedElementHelper = new FullWidthDetailsOverviewSharedElementHelper();
        sharedElementHelper.setSharedElementEnterTransition(getActivity(), "hero");
        detailsPresenter.setListener(sharedElementHelper);
        detailsPresenter.setParticipatingEntranceTransition(true);

        detailsPresenter.setOnActionClickedListener(action -> {

            String link = data[(int) action.getId()][1];

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
        });
        mPresenterSelector.addClassPresenter(DetailsOverviewRow.class, detailsPresenter);
    }

    private String link = null;

    ActivityResultLauncher<String> requestPermission = registerForActivityResult(new ActivityResultContracts.RequestPermission(), result -> {
        if (result) {
            Download.toPublicDirectoryDownload(requireContext(), link);
        } else {
            /*  */
        }
    });

    private void initializeBackground() {
        mDetailsBackground.enableParallax();
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.ic_utilities_preload_tv);
        mDetailsBackground.setCoverBitmap(b);
    }
}
