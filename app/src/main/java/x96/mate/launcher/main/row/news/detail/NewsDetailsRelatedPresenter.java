package x96.mate.launcher.main.row.news.detail;

import androidx.leanback.widget.Presenter;

import x96.mate.launcher.base.CardPresenter;
import x96.mate.launcher.base.CardView;

public class NewsDetailsRelatedPresenter extends CardPresenter {
    private static final int CARD_WIDTH = 313;
    private static final int CARD_HEIGHT = 176;

    @Override
    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object item) {
        super.onBindViewHolder(viewHolder, item);

        CardView cardView = (CardView) viewHolder.view;
        cardView.setMainImageDimensions(CARD_WIDTH, CARD_HEIGHT);
    }
}
