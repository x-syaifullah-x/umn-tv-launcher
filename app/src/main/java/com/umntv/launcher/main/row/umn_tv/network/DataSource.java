package com.umntv.launcher.main.row.umn_tv.network;

import com.umntv.launcher.main.base.ApkData;
import com.umntv.launcher.main.base.OverviewItem;

import java.util.List;

import media.umn.tv.R;

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

    private static final OverviewItem ITEM_GLOBAL_GIRL_NET = new OverviewItem(
            R.drawable.ic_umn_tv_network_detail_global_girl_net,
            R.drawable.ic_umn_tv_network_detail_global_girl_net,
            "GLOBAL GIRLS NET",
            "WELCOME TO GLOBAL GIRLS NET",
            OverviewItem.SUBTITLE_DEFAULT,
            "Join the social media revolution!\n" +
                    "Download it on your mobile device today.\n" +
                    "Network with our global community.",
            new ApkData(
                    "https://globelgirl-2c269.web.app",
                    null,
                    false
            )
    );

    private static final OverviewItem ITEM_GGN_SHOPPING = new OverviewItem(
            R.drawable.ic_umn_tv_network_detail_ggn_shopping,
            R.drawable.ic_umn_tv_network_detail_ggn_shopping,
            "GGN SHOPPING",
            "WELCOME TO GGN SHOPPING",
            OverviewItem.SUBTITLE_DEFAULT,
            "Check out the newest and the latest products on the market.\n" +
                    "Shop for your business, shop for your family, shopping for adventure.",
            new ApkData(
                    "https://globalgnet.net",
                    null,
                    false
            )
    );

    private static final OverviewItem ITEM_GGN_ACCOUNTING = new OverviewItem(
            R.drawable.ic_umn_tv_network_detail_ggn_accounting,
            R.drawable.ic_umn_tv_network_detail_ggn_accounting,
            "GGN ACCOUNTING",
            "WELCOME TO GGN ACCOUNTING",
            OverviewItem.SUBTITLE_DEFAULT,
            "Home and business accounting software!\n" +
                    "Organize your home and/or business with user-friendly accounting software",
            new ApkData(
                    "https://account.globalgnet.net",
                    null,
                    false
            )
    );

    public static final List<OverviewItem> items = List.of(
            ITEM_WHATS_NEWS,
            ITEM_GLOBAL_GIRL_NET,
            ITEM_GGN_SHOPPING,
            ITEM_GGN_ACCOUNTING
    );
}
