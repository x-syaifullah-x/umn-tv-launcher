package com.umntv.launcher.main.row.umn_tv.network;

import com.umntv.launcher.main.base.ApkData;
import com.umntv.launcher.main.base.OverviewItem;

import java.util.List;

import net.n0ender.com.R;

public class DataSource {

    private static final OverviewItem ITEM_WHATS_NEWS = new OverviewItem(
            R.drawable.ic_umn_tv_network_detail_whats_new,
            R.drawable.ic_umn_tv_network_detail_whats_new,
            "WHAT'S NEW",
            "WELCOME TO WHAT'S NEW",
            OverviewItem.SUBTITLE_DEFAULT,
            "Check out the latest devices and accessories! Stay in touch with the latest movies and TV show reviews and more.",
            new ApkData(
                    "https://umntvdealers.net/?page_id=34",
                    null,
                    false
            )
    );

    public static final List<OverviewItem> items = List.of(
            ITEM_WHATS_NEWS
    );
}
