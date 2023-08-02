package x96.mate.launcher.main;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.leanback.app.BackgroundManager;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.BrowseFrameLayout;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.OnItemViewSelectedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import x96.mate.launcher.R;
import x96.mate.launcher.base.Card;
import x96.mate.launcher.base.CardPresenter;
import x96.mate.launcher.base.CardVisitor;
import x96.mate.launcher.main.row.apps.Apps;
import x96.mate.launcher.main.row.asian_media.AsianMedia;
import x96.mate.launcher.main.row.asian_media.AsianMediaCard;
import x96.mate.launcher.main.row.games.Games;
import x96.mate.launcher.main.row.games.GamesCardApp;
import x96.mate.launcher.main.row.kids.Kids;
import x96.mate.launcher.main.row.kids.KidsCard;
import x96.mate.launcher.main.row.news.News;
import x96.mate.launcher.main.row.news.NewsCard;
import x96.mate.launcher.main.row.radio.Radio;
import x96.mate.launcher.main.row.radio.RadioCard;
import x96.mate.launcher.main.row.umn_tv.UmnTv;
import x96.mate.launcher.main.row.umn_tv.UmnTvCard;
import x96.mate.launcher.main.row.utilities.Utilities;
import x96.mate.launcher.main.row.utilities.UtilitiesCard;
import x96.mate.launcher.util.AndroidStore;

public class MainFragment extends BrowseSupportFragment {
    private static final String TAG = "MainFragment";

    private static final int BACKGROUND_UPDATE_DELAY = 300;

    private final Handler mHandler = new Handler();
    private DisplayMetrics mMetrics;
    private Timer mBackgroundTimer;
    private String mBackgroundUri;
    private BackgroundManager mBackgroundManager;
    private final ArrayObjectAdapter rowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());

    //    private ImageButton mPowerOff;
    private ImageButton mSettings;
    private ImageButton mClean;
    private ImageButton mNetPlusTv;
    private ImageButton mSound;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prepareBackgroundManager();
        setupUIElements();
        loadRows();
        setupEventListeners();
        setupGoogleAdMob();
    }

    @Override
    public void onResume() {
        super.onResume();
        loadRows();
        refreshRows();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        linkUIElements();

        linkEventListeners();

        workaroundFocus();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (null != mBackgroundTimer) {
            Log.d(TAG, "onDestroy: " + mBackgroundTimer);
            mBackgroundTimer.cancel();
        }
    }

    private void loadRows() {
        if (rowsAdapter.size() == 0) {
            addUmnTvRow();
            addNewsRow();
            addKidsRow();
            addGamesRow();
            addRadioRow();
            addAsianMediaRow();
            addAppsRow();
            addUtilitiesRow();
            setAdapter(rowsAdapter);
        }
    }

    private void addAsianMediaRow() {
        List<AsianMediaCard> list = AsianMedia.setup();
        ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(new CardPresenter());
        listRowAdapter.addAll(0, list);

        HeaderItem header = new HeaderItem(getString(R.string.asian_series));
        rowsAdapter.add(new ListRow(header, listRowAdapter));
    }

    private void addRadioRow() {
        List<RadioCard> list = Radio.setup();
        ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(new CardPresenter());
        listRowAdapter.addAll(0, list);

        HeaderItem header = new HeaderItem(getString(R.string.radio));
        rowsAdapter.add(new ListRow(header, listRowAdapter));
    }

    private void addGamesRow() {
        List<GamesCardApp> list = Games.setup();
        ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(new CardPresenter());
        listRowAdapter.addAll(0, list);

        HeaderItem header = new HeaderItem(getString(R.string.games));
        rowsAdapter.add(new ListRow(header, listRowAdapter));
    }

    private void addKidsRow() {
        List<KidsCard> list = Kids.setup();
        ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(new CardPresenter());
        listRowAdapter.addAll(0, list);

        HeaderItem header = new HeaderItem(getString(R.string.kids));
        rowsAdapter.add(new ListRow(header, listRowAdapter));
    }

    private void addUmnTvRow() {
        List<UmnTvCard> list = UmnTv.setupUmnTv();
        ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(new CardPresenter());
        listRowAdapter.addAll(0, list);

        HeaderItem header = new HeaderItem(getString(R.string.umntv));
        rowsAdapter.add(new ListRow(header, listRowAdapter));
    }

    private void addNewsRow() {
        List<NewsCard> list = News.setup();
        ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(new CardPresenter());
        listRowAdapter.addAll(0, list);

        HeaderItem header = new HeaderItem(0, getString(R.string.news));
        rowsAdapter.add(new ListRow(header, listRowAdapter));
    }

    private void addUtilitiesRow() {
        List<UtilitiesCard> list = Utilities.setup();
        ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(new CardPresenter());
        listRowAdapter.addAll(0, list);

        HeaderItem header = new HeaderItem(getString(R.string.utility));
        rowsAdapter.add(new ListRow(header, listRowAdapter));
    }

    private void addAppsRow() {
        ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(new CardPresenter());

        List<Card> list = Apps.setup();
        listRowAdapter.addAll(0, list);

        HeaderItem header = new HeaderItem(2, getString(R.string.app));
        rowsAdapter.add(new ListRow(header, listRowAdapter));
    }

    private void prepareBackgroundManager() {
        mBackgroundManager = BackgroundManager.getInstance(requireActivity());
        mBackgroundManager.attach(requireActivity().getWindow());

//        mBackgroundUri = getString(R.string.background);
        mMetrics = new DisplayMetrics();
        requireActivity().getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
    }

    private void setupUIElements() {
        // setBadgeDrawable(getActivity().getResources().getDrawable(
        // R.drawable.videos_by_google_banner));
//        setTitle(getString(R.string.browse_title)); // Badge, when set, takes precedent
        // over title
//        setHeadersState(HEADERS_DISABLED);
        setHeadersTransitionOnBackEnabled(true);

        // set fastLane (or headers) background color
        setBrandColor(ContextCompat.getColor(requireActivity(), R.color.fastlane_background));
        // set search icon color
        setSearchAffordanceColor(ContextCompat.getColor(requireActivity(), R.color.search_opaque));
//        setOnSearchClickedListener(view -> {});
    }

    private void setupEventListeners() {
        setOnItemViewClickedListener(new ItemViewClickedListener());
        setOnItemViewSelectedListener(new ItemViewSelectedListener());
    }

    private void setupGoogleAdMob() {
        try {
            MobileAds.initialize(requireContext(), initializationStatus -> {

            });

            AdView mAdView = requireActivity().findViewById(R.id.adView);
            mAdView.bringToFront();

            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    private void refreshRows() {
        for (int i = 0; i < getAdapter().size(); i++) {
            ListRow listRow = ((ListRow) getAdapter().get(i));
            ArrayObjectAdapter listRowAdapter = ((ArrayObjectAdapter) listRow.getAdapter());
            if (listRowAdapter.size() > 0) {
                listRowAdapter.notifyArrayItemRangeChanged(0, listRowAdapter.size());
            }
        }
    }

    private void linkUIElements() {
//        mPowerOff = requireView().findViewById(R.id.power_off);
        mSettings = requireView().findViewById(R.id.title_settings);
        mClean = requireView().findViewById(R.id.title_clean);
        mSound = requireActivity().findViewById(R.id.title_sound);
//        mInfo = requireActivity().findViewById(R.id.info);
        mNetPlusTv = requireActivity().findViewById(R.id.net_plus_tv);
//        adjustScreen = requireActivity().findViewById(R.id.adjust_screen);
    }

    private void linkEventListeners() {

        mNetPlusTv.setOnClickListener(view -> promptNetPlusTv());

        mSound.setOnClickListener(view -> promptSounds());

//        mPowerOff.setOnClickListener(view -> {
//            promptPowerOff();
//        });

        mSettings.setOnClickListener(view -> promptSettings());

        mClean.setOnClickListener(view -> promptClean());
    }

    private void workaroundFocus() {
        BrowseFrameLayout browseFrameLayout = requireView().findViewById(R.id.browse_frame);
        FrameLayout frameLayout = requireView().findViewById(R.id.browse_title_group);

        browseFrameLayout.setOnFocusSearchListener((focused, direction) -> {
            if (direction == View.FOCUS_UP) {
                return frameLayout;
            } else {
                return null;
            }
        });
    }

    private void updateBackground(String uri) {
        int width = mMetrics.widthPixels;
        int height = mMetrics.heightPixels;
        Glide.with(requireActivity())
                .load(uri)
                .centerCrop()
                .placeholder(R.drawable.default_card_imag)
//                .error(mDefaultBackground)
                .into(new CustomTarget<Drawable>(width, height) {
                    @Override
                    public void onResourceReady(@NonNull Drawable drawable, @Nullable Transition<? super Drawable> transition) {
                        mBackgroundManager.setDrawable(drawable);
                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {

                    }
                });
        mBackgroundTimer.cancel();
    }

    private void startBackgroundTimer() {
        if (null != mBackgroundTimer) {
            mBackgroundTimer.cancel();
        }
        mBackgroundTimer = new Timer();
        mBackgroundTimer.schedule(new UpdateBackgroundTask(), BACKGROUND_UPDATE_DELAY);
    }

    private final class ItemViewClickedListener implements OnItemViewClickedListener {
        @Override
        public void onItemClicked(Presenter.ViewHolder itemViewHolder, Object item, RowPresenter.ViewHolder rowViewHolder, Row row) {
            Card card = (Card) item;
            card.onClicked(new CardVisitor(getContext()));
        }
    }

    private final class ItemViewSelectedListener implements OnItemViewSelectedListener {
        @Override
        public void onItemSelected(Presenter.ViewHolder itemViewHolder, Object item, RowPresenter.ViewHolder rowViewHolder, Row row) {
            if (item != null) {
                Card card = (Card) item;
                mBackgroundUri = card.getBackgroundImageStringUri();
                startBackgroundTimer();
            }
        }
    }

    private class UpdateBackgroundTask extends TimerTask {

        @Override
        public void run() {
            mHandler.post(() -> updateBackground(mBackgroundUri));
        }
    }

    private void promptNetPlusTv() {
        String packageName = "com.teamviewer.quicksupport.market";
        Intent launchIntent = requireActivity().getPackageManager().getLaunchIntentForPackage(packageName);
        if (launchIntent != null) {
            requireActivity().startActivity(launchIntent);
        } else {
            AndroidStore.open(requireContext(), packageName);
        }
    }

    private void promptSounds() {
        String packageName = "mobi.omegacentauri.SpeakerBoost";
        Intent launchIntent = requireActivity().getPackageManager().getLaunchIntentForPackage(packageName);
        if (launchIntent != null) {
            requireActivity().startActivity(launchIntent);
        } else {
            AndroidStore.open(requireContext(), packageName);
        }
    }

    private void promptSettings() {
        Intent intent = new Intent(Settings.ACTION_SETTINGS);
        startActivity(intent);
    }

    private void promptClean() {
        Intent intent = new Intent(Settings.ACTION_INTERNAL_STORAGE_SETTINGS);
        startActivity(intent);
    }
}