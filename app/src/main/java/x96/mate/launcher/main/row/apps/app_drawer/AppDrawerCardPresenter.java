package x96.mate.launcher.main.row.apps.app_drawer;

import x96.mate.launcher.base.CardPresenter;
import x96.mate.launcher.base.CardView;

public class AppDrawerCardPresenter extends CardPresenter {
    private int mWidth;
    private int mHeight;

    public AppDrawerCardPresenter(int width, int height) {
        mWidth = width;
        mHeight = height;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {
        super.onBindViewHolder(viewHolder, item);

        CardView cardView = (CardView) viewHolder.view;
//        cardView.setMainImageDimensions(mWidth, mHeight);

    }
}
