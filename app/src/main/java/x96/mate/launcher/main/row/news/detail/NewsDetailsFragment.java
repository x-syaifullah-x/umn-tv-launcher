package x96.mate.launcher.main.row.news.detail;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.leanback.app.DetailsSupportFragment;
import androidx.leanback.app.DetailsSupportFragmentBackgroundController;
import androidx.leanback.widget.Action;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.ClassPresenterSelector;
import androidx.leanback.widget.DetailsOverviewRow;
import androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter;
import androidx.leanback.widget.FullWidthDetailsOverviewSharedElementHelper;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import x96.mate.launcher.R;
import x96.mate.launcher.base.CardVisitor;
import x96.mate.launcher.main.MainActivity;
import x96.mate.launcher.play.PlayActivity;
import x96.mate.launcher.util.Convert;
import x96.mate.launcher.main.row.news.News;
import x96.mate.launcher.main.row.news.NewsCard;

import java.util.ArrayList;
import java.util.Collections;

public class NewsDetailsFragment extends DetailsSupportFragment {
    private static final String TAG = "VideoDetailsFragment";

    private static final int DETAIL_THUMB_WIDTH = 274;
    private static final int DETAIL_THUMB_HEIGHT = 274;

    private NewsCard mSelectedNewsCard;

    private ArrayObjectAdapter mAdapter;
    private ClassPresenterSelector mPresenterSelector;

    private DetailsSupportFragmentBackgroundController mDetailsBackground;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDetailsBackground = new DetailsSupportFragmentBackgroundController(this);

        mSelectedNewsCard =
                (NewsCard) requireActivity().getIntent().getSerializableExtra(NewsDetailsActivity.ITEM);
        if (mSelectedNewsCard != null) {
            mPresenterSelector = new ClassPresenterSelector();
            mAdapter = new ArrayObjectAdapter(mPresenterSelector);
            setupDetailsOverviewRow();
            setupDetailsOverviewRowPresenter();
            setupRelatedListRow();
            setAdapter(mAdapter);
            initializeBackground(mSelectedNewsCard);
        } else {
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
        }
    }

    private void initializeBackground(NewsCard data) {
        mDetailsBackground.enableParallax();
        Glide.with(requireActivity())
                .asBitmap()
                .centerCrop()
                .error(R.drawable.default_background)
                .load(data.getBackgroundImageStringUri())
                .into(new CustomTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
                        mDetailsBackground.setCoverBitmap(bitmap);
                        mAdapter.notifyArrayItemRangeChanged(0, mAdapter.size());
                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {

                    }
                });
    }

    private void setupDetailsOverviewRow() {
        Log.d(TAG, "doInBackground: " + mSelectedNewsCard.toString());
        final DetailsOverviewRow row = new DetailsOverviewRow(mSelectedNewsCard);
        row.setImageDrawable(
                ContextCompat.getDrawable(requireActivity(), R.drawable.default_background));
        int width = Convert.dpToPixel(requireActivity().getApplicationContext(), DETAIL_THUMB_WIDTH);
        int height = Convert.dpToPixel(requireActivity().getApplicationContext(), DETAIL_THUMB_HEIGHT);
        Glide.with(requireActivity())
                .load(mSelectedNewsCard.getDetailImageStringUri())
                .centerCrop()
                .error(R.drawable.default_background)
                .into(new CustomTarget<Drawable>(width, height) {
                    @Override
                    public void onResourceReady(@NonNull Drawable drawable, @Nullable Transition<? super Drawable> transition) {
                        Log.d(TAG, "details overview card image url ready: " + drawable);
                        row.setImageDrawable(drawable);
                        mAdapter.notifyArrayItemRangeChanged(0, mAdapter.size());
                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {

                    }
                });

        ArrayObjectAdapter actionAdapter = new ArrayObjectAdapter();

        actionAdapter.add(new Action(0, getResources().getString(R.string.play_video)));
        row.setActionsAdapter(actionAdapter);

        mAdapter.add(row);
    }

    private void setupDetailsOverviewRowPresenter() {
        // Set detail background.
        FullWidthDetailsOverviewRowPresenter detailsPresenter = new FullWidthDetailsOverviewRowPresenter(new NewsDetailsDescriptionPresenter());
        detailsPresenter.setBackgroundColor(ContextCompat.getColor(requireActivity(), R.color.selected_background));

        // Hook up transition element.
        FullWidthDetailsOverviewSharedElementHelper sharedElementHelper = new FullWidthDetailsOverviewSharedElementHelper();
        sharedElementHelper.setSharedElementEnterTransition(getActivity(), NewsDetailsActivity.SHARED_ELEMENT_NAME);
        detailsPresenter.setListener(sharedElementHelper);
        detailsPresenter.setParticipatingEntranceTransition(true);

        detailsPresenter.setOnActionClickedListener(action -> {
            startActivity(PlayActivity.createIntent(requireActivity(), mSelectedNewsCard.getYoutubeId()));
        });
        mPresenterSelector.addClassPresenter(DetailsOverviewRow.class, detailsPresenter);
    }

    private void setupRelatedListRow() {
        String[] subcategories = {getString(R.string.related_news)};
        ArrayList<NewsCard> list = new ArrayList<>();
        for (NewsCard n : News.setup()) {
            if (!n.getTitle().equals(mSelectedNewsCard.getTitle())) {
                list.add(n);
            }
        }

        Collections.shuffle(list);
        ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(new NewsDetailsRelatedPresenter());
        listRowAdapter.addAll(0, list);

        HeaderItem header = new HeaderItem(0, subcategories[0]);
        mAdapter.add(new ListRow(header, listRowAdapter));
        mPresenterSelector.addClassPresenter(ListRow.class, new ListRowPresenter());
        setOnItemViewClickedListener(new ItemViewClickedListener());
    }

    private final class ItemViewClickedListener implements OnItemViewClickedListener {
        @Override
        public void onItemClicked(Presenter.ViewHolder itemViewHolder, Object item, RowPresenter.ViewHolder rowViewHolder, Row row) {
            if (item instanceof NewsCard) {
                NewsCard newsCard = (NewsCard) item;

                ((NewsCard) item).onClicked(new CardVisitor(requireContext()));

                if (newsCard.getPackageName() == null) {
                    requireActivity().finishAfterTransition();
                }
            }
        }
    }
}