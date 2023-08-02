package com.umntv.launcher.main.row.utilities.details.preload_tv;

import android.graphics.Typeface;
import android.widget.TextView;

import androidx.leanback.widget.AbstractDetailsDescriptionPresenter;

public class DetailPreloadDescriptionPresenter extends AbstractDetailsDescriptionPresenter {

    @Override
    protected void onBindDescription(ViewHolder viewHolder, Object item) {
        DetailPreloadItem data = (DetailPreloadItem) item;

        TextView title = viewHolder.getTitle();
        title.setTypeface(Typeface.DEFAULT_BOLD);
        title.setText(data.getTitle());

        TextView body = viewHolder.getBody();
        body.setText(data.getBody());
    }
}