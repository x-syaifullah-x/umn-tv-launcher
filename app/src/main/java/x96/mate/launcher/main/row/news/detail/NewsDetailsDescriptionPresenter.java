package x96.mate.launcher.main.row.news.detail;

import androidx.leanback.widget.AbstractDetailsDescriptionPresenter;

import x96.mate.launcher.main.row.news.NewsCard;

public class NewsDetailsDescriptionPresenter extends AbstractDetailsDescriptionPresenter {

    @Override
    protected void onBindDescription(ViewHolder viewHolder, Object item) {
        NewsCard newsCard = (NewsCard) item;

        if (newsCard != null) {
            viewHolder.getTitle().setText(newsCard.getTitle());
//            viewHolder.getSubtitle().setText(video.getStudio());
            viewHolder.getBody().setText(newsCard.getDetailDescription());
        }
    }
}