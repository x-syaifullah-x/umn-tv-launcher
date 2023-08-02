package com.umntv.launcher.main.row.umn_tv.detail.download_center;

import android.graphics.Typeface;

import androidx.leanback.widget.AbstractDetailsDescriptionPresenter;

public class DownloadCenterDetailDescriptionPresenter extends AbstractDetailsDescriptionPresenter {

    @Override
    protected void onBindDescription(ViewHolder viewHolder, Object item) {
        DownloadCenterItem downloadCenterItem = (DownloadCenterItem) item;

        viewHolder.getTitle().setTypeface(Typeface.DEFAULT_BOLD);
        viewHolder.getTitle().setTextSize(25);
        viewHolder.getTitle().setText(downloadCenterItem.getTitle());

        viewHolder.getSubtitle().setTypeface(Typeface.DEFAULT_BOLD);
        viewHolder.getBody().setTextSize(14);
        viewHolder.getSubtitle().setText(downloadCenterItem.getSubTitle());

        viewHolder.getBody().setTextSize(16);
        viewHolder.getBody().setText(downloadCenterItem.getBody());
    }
}