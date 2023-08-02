package x96.mate.launcher.main.row.apps.movies_apps;

import android.graphics.Typeface;

import androidx.leanback.widget.AbstractDetailsDescriptionPresenter;

public class MoviesDetailDescriptionPresenter extends AbstractDetailsDescriptionPresenter {

    @Override
    protected void onBindDescription(ViewHolder viewHolder, Object item) {
        MoviesItemCard umnTvItemCard = (MoviesItemCard) item;

        viewHolder.getTitle().setTypeface(Typeface.DEFAULT_BOLD);
        viewHolder.getTitle().setTextSize(25);
        viewHolder.getTitle().setText(umnTvItemCard.getTitle());
    }
}