package com.umntv.launcher.main.row.ads.detail;

import androidx.leanback.widget.AbstractDetailsDescriptionPresenter;

import com.umntv.launcher.main.row.ads.AdsCard;

public class AdsDetailsDescriptionPresenter extends AbstractDetailsDescriptionPresenter {

    @Override
    protected void onBindDescription(ViewHolder viewHolder, Object item) {
        AdsCard image = (AdsCard) item;

        if (image != null) {
            viewHolder.getTitle().setText(image.getTitle());
            viewHolder.getBody().setText(image.getDetailDescription());
            viewHolder.getSubtitle().setText(image.getSubtitle());
        }
    }
}
