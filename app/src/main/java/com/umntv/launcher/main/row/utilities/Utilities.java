package com.umntv.launcher.main.row.utilities;

import media.umn.tv.R;
import com.umntv.launcher.main.row.utilities.details.UtilitiesDetailsActivity;
import com.umntv.launcher.util.ResourceHelpers;

import java.util.ArrayList;
import java.util.List;

public class Utilities {

    private final static List<UtilitiesCard> data = new ArrayList<>();

    public static List<UtilitiesCard> setup() {
        if (!data.isEmpty())
            return data;

        String[] extras = {
                null,
                UtilitiesDetailsActivity.DATA_EXTRA_REMOTE_SUPPORT,
                null,
                null,
                UtilitiesDetailsActivity.DATA_EXTRA_PRELOAD_TV,
                null,
//                UtilitiesDetailsActivity.DATA_EXTRA_REMOTE_SUPPORT,
                null
        };

        String[] title = {
                "FX FILE EXPLORER",
                "REMOTE SUPPORT",
                "FTP FILE MANAGER",
                "SEND FILES TO TV",
                "PRELOAD TV",
                "SCREEN CAST",
//                "REMOTE SUPPORT",
                "DOWNLOADER"
        };
        int[] resourceId = {
                R.drawable.ic_utilities_fx,
                R.drawable.ic_utilities_remote_support,
                R.drawable.ic_utilities_ftp,
                R.drawable.ic_utilities_send_files_to_tv,
                R.drawable.ic_utilities_preload_tv_new,
                R.drawable.ic_utilities_screen_cast,
//                R.drawable.ic_utilities_remote_support,
                R.drawable.ic_utilities_downloader,
        };
        String[] packageName = {
                "nextapp.fx",
                null,
                "io.github.visnkmr.wirelessexplorer",
                "com.yablio.sendfilestotv",
                null,
                "com.ionitech.airscreen",
//                null,
                "com.esaba.downloader"
        };

        String[] linkApkDownload = {
                "https://umntvdealers.net/UMNTV/Apks/FX-8.0.3.0.apk",
                null,
                null,
                null,
                null,
                null,
//                null,
                null
        };

        for (int index = 0; index < title.length; ++index) {
            UtilitiesCard card = new UtilitiesCard();
            card.setTitle(title[index]);
            card.setLinkApkDownload(linkApkDownload[index]);
            card.setPackageName(packageName[index]);
            card.setBackgroundImageStringUri(ResourceHelpers.toStringUri(R.drawable.ic_utilities_bg));
            card.setIconStringUri(ResourceHelpers.toStringUri(resourceId[index]));
            card.setDataExtra(extras[index]);
            data.add(card);
        }
        return data;
    }
}
