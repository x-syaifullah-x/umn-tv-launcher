package x96.mate.launcher.main.row.radio.detail;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
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
import x96.mate.launcher.main.row.radio.Radio;
import x96.mate.launcher.main.row.radio.RadioCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RadioDetailsFragment extends DetailsSupportFragment {
    private static final String TAG = "RadioDetailsFragment";

    private static final int DETAIL_THUMB_WIDTH = 274;
    private static final int DETAIL_THUMB_HEIGHT = 274;

    private RadioCard mSelectedRadio;

    private ArrayObjectAdapter mAdapter;
    private ClassPresenterSelector mPresenterSelector;

    private DetailsSupportFragmentBackgroundController mDetailsBackground;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDetailsBackground = new DetailsSupportFragmentBackgroundController(this);

        mSelectedRadio = (RadioCard) requireActivity().getIntent().getSerializableExtra(RadioDetailsActivity.ITEM);

        if (mSelectedRadio != null) {
            mPresenterSelector = new ClassPresenterSelector();
            mAdapter = new ArrayObjectAdapter(mPresenterSelector);
            setupDetailsOverviewRow();
            setupDetailsOverviewRowPresenter();
            setupRelatedListRow();
            setAdapter(mAdapter);
            initializeBackground(mSelectedRadio);
        } else {
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
        }
    }

    private void initializeBackground(RadioCard data) {
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
        DetailsOverviewRow row = new DetailsOverviewRow(mSelectedRadio);
        row.setImageDrawable(ContextCompat.getDrawable(requireActivity(), R.drawable.default_background));
        int width = Convert.dpToPixel(requireActivity().getApplicationContext(), DETAIL_THUMB_WIDTH);
        int height = Convert.dpToPixel(requireActivity().getApplicationContext(), DETAIL_THUMB_HEIGHT);
        Glide.with(requireActivity())
                .load(mSelectedRadio.getDetailImageStringUri())
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

        if (mSelectedRadio.getLink() != null) {
            switch (mSelectedRadio.getTitle()) {
                case Radio.TRAP_BEATS_NAME:
                    actionAdapter.add(new Action(0, getResources().getString(R.string.play_video_trap_beats_1)));
                    actionAdapter.add(new Action(1, getResources().getString(R.string.play_video_trap_beats_2)));
                    actionAdapter.add(new Action(2, getResources().getString(R.string.play_video_trap_beats_3)));
                    actionAdapter.add(new Action(3, getResources().getString(R.string.play_video_trap_beats_4)));
                    break;
                case Radio.HMONG_SONGS:
                    actionAdapter.add(new Action(0, getResources().getString(R.string.play_video_hmong_song_1)));
                    actionAdapter.add(new Action(1, getResources().getString(R.string.play_video_hmong_song_2)));
                    actionAdapter.add(new Action(2, getResources().getString(R.string.play_video_hmong_song_3)));
                    actionAdapter.add(new Action(3, getResources().getString(R.string.play_video_hmong_song_4)));
                    break;
                case Radio.THAI_LAO_KARAOKE:
                    actionAdapter.add(new Action(0, getResources().getString(R.string.play_video_thai_lao_karaoke_1)));
                    actionAdapter.add(new Action(1, getResources().getString(R.string.play_video_thai_lao_karaoke_2)));
                    actionAdapter.add(new Action(2, getResources().getString(R.string.play_video_thai_lao_karaoke_3)));
                    actionAdapter.add(new Action(3, getResources().getString(R.string.play_video_thai_lao_karaoke_4)));
                    break;
            }
        } else {
            actionAdapter.add(new Action(0, "LOFI HIP HOP"));
            actionAdapter.add(new Action(1, "YOUTUBE SHORTS"));
            actionAdapter.add(new Action(2, "CHILLHOP"));
        }
        row.setActionsAdapter(actionAdapter);

        mAdapter.add(row);
    }

    private void setupDetailsOverviewRowPresenter() {
        // Set detail background.
        FullWidthDetailsOverviewRowPresenter detailsPresenter = new FullWidthDetailsOverviewRowPresenter(new RadioDetailsDescriptionPresenter());
        detailsPresenter.setBackgroundColor(ContextCompat.getColor(requireActivity(), R.color.selected_background));

        // Hook up transition element.
        FullWidthDetailsOverviewSharedElementHelper sharedElementHelper = new FullWidthDetailsOverviewSharedElementHelper();
        sharedElementHelper.setSharedElementEnterTransition(getActivity(), RadioDetailsActivity.SHARED_ELEMENT_NAME);
        detailsPresenter.setListener(sharedElementHelper);
        detailsPresenter.setParticipatingEntranceTransition(true);

        detailsPresenter.setOnActionClickedListener(action -> {
            if (mSelectedRadio.getLink() != null) {
                String[] url = mSelectedRadio.getLink().split(" ");
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url[(int) action.getId()]));
                startActivity(i);
            } else {
                String[] data = mSelectedRadio.getYoutubeId().split(" ");
                String link = data[(int) action.getId()];
                /* open browser */
                if (link.contains("https")) {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(link));
                    startActivity(i);
                } else {
                    startActivity(PlayActivity.createIntent(requireActivity(), link));
                }
            }
        });

        mPresenterSelector.addClassPresenter(DetailsOverviewRow.class, detailsPresenter);
    }

    private void setupRelatedListRow() {
        String[] subcategories = {getString(R.string.related_radio)};

        List<RadioCard> list = new ArrayList<>();

        for (RadioCard n : Radio.setup()) {
            if (!n.getTitle().equals(mSelectedRadio.getTitle())) {
                list.add(n);
            }
        }

        Collections.shuffle(list);
        ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(new RadioDetailsRelatedPresenter());
        listRowAdapter.addAll(0, list);

        HeaderItem header = new HeaderItem(0, subcategories[0]);
        mAdapter.add(new ListRow(header, listRowAdapter));
        mPresenterSelector.addClassPresenter(ListRow.class, new ListRowPresenter());
        setOnItemViewClickedListener(new ItemViewClickedListener());
    }

    private final class ItemViewClickedListener implements OnItemViewClickedListener {
        @Override
        public void onItemClicked(Presenter.ViewHolder itemViewHolder, Object item, RowPresenter.ViewHolder rowViewHolder, Row row) {
            if (item instanceof RadioCard) {
                RadioCard r = (RadioCard) item;
                ((RadioCard) item).onClicked(new CardVisitor(requireContext()));

                if (r.getPackageName() == null) {
                    requireActivity().finishAfterTransition();
                }
            }
        }
    }
}