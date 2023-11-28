package com.umntv.launcher.main.row.games;

import media.umn.tv.R;

import com.umntv.launcher.main.row.games.umn_games.UmnGamesDetailFragment;
import com.umntv.launcher.main.row.games.umn_retro.UmnRetroDetailFragment;
import com.umntv.launcher.util.ResourceHelpers;

import java.util.ArrayList;
import java.util.List;

public class Games {

    private static final List<GamesCardApp> games = new ArrayList<>();

    public static List<GamesCardApp> setup() {
        if (games.isEmpty()) {
            String[] title = {
                    "UMN RETRO",
                    "UMN GAMES",
                    "UMN_PS1",
                    "UMN_PSP",
                    "UMN_ARCADE",
                    "UMN_N64",
            };
            int[] resourceId = {
                    R.drawable.ic_umn_retro_umn_retro,
                    R.drawable.ic_games_umn_games_new,
                    R.drawable.ic_umn_retro_umn_games_ps1_new,
                    R.drawable.ic_retro_umn_games_umn_psp_bg,
                    R.drawable.ic_retro_umn_games_umn_arcade_bg,
                    R.drawable.ic_retro_umn_games_umn_n64,
            };
            String[] packageName = {
                    null,
                    null,
                    "com.epsxe.ePSXe",
                    "org.ppsspp.ppsspp",
                    "com.seleuco.mame4droid",
                    "org.mupen64plusae.v3.fzurita",
            };

            String[] apkLinkDownload = {
                    null,
                    null,
                    "https://umntv.net/UMNTV_Builds/Images/UMN_PS1.apk",
                    "https://umntv.net/UMNTV_Builds/Images/UMN_PSP.apk",
                    "https://umntv.net/UMNTV_Builds/Images/UMN_Arcade.apk",
                    "https://umntv.net/UMNTV_Builds/Images/UMN_N64.apk"
            };
            Class[] a = {
                    UmnRetroDetailFragment.class,
                    UmnGamesDetailFragment.class,
                    null,
                    null,
                    null,
                    null
            };

            for (int index = 0; index < title.length; ++index) {
                games.add(
                        buildQuickAppInfo(
                                a[index],
                                title[index],
                                resourceId[index],
                                packageName[index],
                                apkLinkDownload[index]
                        )
                );
            }
        }
        return games;
    }

    private static GamesCardApp buildQuickAppInfo(Class a, String title, int resourceId, String packageName, String linkApkDownload) {
        GamesCardApp umn = new GamesCardApp();
        umn.setDetail(a);
        umn.setTitle(title);
        umn.setPackageName(packageName);
        umn.setBackgroundStringUri(ResourceHelpers.toStringUri(R.drawable.games_bg_umn_games));
        umn.setIconStringUri(ResourceHelpers.toStringUri(resourceId));
        umn.setLinkApkDownload(linkApkDownload);
        return umn;
    }
}
