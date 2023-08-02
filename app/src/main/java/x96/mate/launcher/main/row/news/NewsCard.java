package x96.mate.launcher.main.row.news;

import x96.mate.launcher.base.CardApp;
import x96.mate.launcher.base.CardVisitor;

public class NewsCard extends CardApp {

    private String youtubeId;

    public String getYoutubeId() {
        return youtubeId;
    }

    public void setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
    }

    @Override
    public void onClicked(CardVisitor visitor) {
        visitor.click(this);
    }
}