package com.umntv.launcher.main.row.utilities.details.remote_support;

import android.graphics.Typeface;
import android.widget.TextView;

import androidx.leanback.widget.AbstractDetailsDescriptionPresenter;

public class DetailRemoteSupportDescriptionPresenter extends AbstractDetailsDescriptionPresenter {

    @Override
    protected void onBindDescription(ViewHolder viewHolder, Object item) {
        DetailRemoteSupportItem data = (DetailRemoteSupportItem) item;

        TextView title = viewHolder.getTitle();
        title.setTypeface(Typeface.DEFAULT_BOLD);
        title.setText(data.getTitle());

        TextView body = viewHolder.getBody();
        body.setText(data.getBody());
    }
}