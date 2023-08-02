package x96.mate.launcher.main.row.news.detail;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;
import androidx.leanback.app.DetailsSupportFragment;
import androidx.leanback.app.DetailsSupportFragmentBackgroundController;
import androidx.leanback.widget.Action;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.ClassPresenterSelector;
import androidx.leanback.widget.DetailsOverviewRow;
import androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter;
import androidx.leanback.widget.FullWidthDetailsOverviewSharedElementHelper;

import x96.mate.launcher.R;
import x96.mate.launcher.main.base.ApkData;
import x96.mate.launcher.play.PlayActivity;
import x96.mate.launcher.util.AndroidStore;

import java.util.List;

public class BaseDetailFragment extends DetailsSupportFragment {
    private final List<OverviewItem> items;

    public BaseDetailFragment(List<OverviewItem> items) {
        this.items = items;
    }

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
    }

    private void setupDetailsOverviewRow() {
        OverviewItem overviewItem = items.get(0);
        final DetailsOverviewRow row = new DetailsOverviewRow(overviewItem);
        row.setImageDrawable(ContextCompat.getDrawable(requireActivity(), R.drawable.default_background));
        row.setImageDrawable(ContextCompat.getDrawable(requireContext(), overviewItem.icon));
        initializeBackground(overviewItem.bg);

        ArrayObjectAdapter actionAdapter = new ArrayObjectAdapter();

        for (int index = 0; index < items.size(); index++) {
            String titleAction = items.get(index).titleAction;
            actionAdapter.add(new Action(index, titleAction));
        }
        row.setActionsAdapter(actionAdapter);
        mAdapter.add(row);
    }

    private void setupDetailsOverviewRowPresenter() {
        // Set detail background.
        FullWidthDetailsOverviewRowPresenter detailsPresenter = new FullWidthDetailsOverviewRowPresenter(
                new BaseDetailDescriptionPresenter()
        );
        detailsPresenter.setBackgroundColor(ContextCompat.getColor(requireActivity(), R.color.selected_background));

        // Hook up transition element.
        FullWidthDetailsOverviewSharedElementHelper sharedElementHelper = new FullWidthDetailsOverviewSharedElementHelper();
        sharedElementHelper.setSharedElementEnterTransition(getActivity(), "hero");
        detailsPresenter.setListener(sharedElementHelper);
        detailsPresenter.setParticipatingEntranceTransition(true);

        setOnItemViewSelectedListener((itemViewHolder, item, rowViewHolder, row) -> {
//            FullWidthDetailsOverviewRowPresenter.ViewHolder viewHolder = (FullWidthDetailsOverviewRowPresenter.ViewHolder) rowViewHolder;
            DetailsOverviewRow detailsOverviewRow = (DetailsOverviewRow) row;
            Action action = (Action) item;
            if (action != null) {
                int index = ((int) action.getId());
                OverviewItem data = items.get(index);
                detailsOverviewRow.setImageDrawable(ContextCompat.getDrawable(requireContext(), data.icon));
                changeBackground(data.bg);
                detailsOverviewRow.setItem(data);
            }
        });

        detailsPresenter.setOnActionClickedListener(action -> {
            int index = (int) action.getId();
            OverviewItem overviewItem = items.get(index);

            if (overviewItem.apkData != null) {
                openOrDownload(overviewItem.apkData);
                return;
            }

            if (!overviewItem.url.contains("https://")) {
                startActivity(PlayActivity.createIntent(requireActivity(), overviewItem.url));
            } else {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(overviewItem.url));
                i.setPackage("com.android.chrome");
                startActivity(i);
            }
        });
        mPresenterSelector.addClassPresenter(DetailsOverviewRow.class, detailsPresenter);
    }

    private void openOrDownload(ApkData apkData) {
        if (apkData.url.isEmpty() || apkData.packageName.isEmpty()) {
            Toast.makeText(requireContext(), "Coming soon", Toast.LENGTH_SHORT).show();
        } else {
            Intent launchIntent = requireContext()
                    .getPackageManager()
                    .getLaunchIntentForPackage(apkData.packageName);
            try {
                if (launchIntent == null) {
                    launchIntent = new Intent();
                    launchIntent.setPackage(apkData.packageName);
                    launchIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                }
//                launchIntent.addCategory("android.intent.category.LEANBACK_LAUNCHER");
                requireContext().startActivity(launchIntent);
            } catch (Throwable e) {
                AndroidStore.open(requireContext(), apkData.packageName);
                e.printStackTrace();
            }
        }
    }

    private void initializeBackground(int id) {
        Bitmap b = BitmapFactory.decodeResource(getResources(), id);
        mDetailsBackground.setCoverBitmap(b);
    }

    private void changeBackground(@DrawableRes int drawable) {
        Bitmap b = BitmapFactory.decodeResource(getResources(), drawable);
        mDetailsBackground.setCoverBitmap(b);
        mDetailsBackground.enableParallax();
    }
}
