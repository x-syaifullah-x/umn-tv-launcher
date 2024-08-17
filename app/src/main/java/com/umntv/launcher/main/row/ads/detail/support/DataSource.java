package com.umntv.launcher.main.row.ads.detail.support;

import com.umntv.launcher.main.base.ApkData;
import com.umntv.launcher.main.base.OverviewItem;

import java.util.List;

import media.umn.tv.R;

public class DataSource {

    private static final OverviewItem DINERO_DATA = new OverviewItem(
            R.drawable.asian_media_jade_cinema_ic_abc,
            R.drawable.asian_media_jade_cinema_ic_abc_bg,
            "DINERO DATA",
            "VENDORS SUPPORT",
            "Find info about your local vendor",
            "Data that works for you\n\nsupport@dinerodata.net",
            new ApkData(
                    "https://dinerodata.net/?page_id=13",
                    "jade.umn.net",
                    false
            )
    );

    private static final OverviewItem TECH_SUPPORT = new OverviewItem(
            R.drawable.ic_ads_your_add_here,
            R.drawable.ic_ads_your_add_here,
            "TECH SUPPORT",
            "TECH SUPPORT",
            "Please contact us if you need any support",
            "",
            new ApkData(
                    "https://n0render.com/tech-support",
                    "jade.umn.net",
                    false
            )
    );

    private static final OverviewItem ORAMAL_ENTERPRISES = new OverviewItem(
            R.drawable.asian_media_jade_cinema_ic_abc,
            R.drawable.asian_media_jade_cinema_ic_abc_bg,
            "ORAMAL ENTERPRISES",
            "VENDORS SUPPORT",
            "Find info about your local vendor",
            "Data that works for you\n\nsupport@dinerodata.net",
            new ApkData(
                    "http://oramal.com/?page_id=18",
                    "jade.umn.net",
                    false
            )
    );

    public static final List<OverviewItem> items = List.of(
            DINERO_DATA,
            TECH_SUPPORT,
            ORAMAL_ENTERPRISES
    );
}
