package com.umntv.launcher.main.row.news_or_media.domain.model;

import com.umntv.launcher.base.CardApp;
import com.umntv.launcher.base.CardVisitor;

public class NewsMediaModel extends CardApp {

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