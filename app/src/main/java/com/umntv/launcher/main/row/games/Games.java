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
                    "MINECRAFT",
                    "UNKILLED",
                    "PAC-MAN256",
                    "CHESS",
            };
            int[] resourceId = {
                    R.drawable.ic_umn_retro_umn_retro,
                    R.drawable.ic_games_umn_games_new,
                    R.drawable.ic_games_minecraft,
                    R.drawable.ic_games_unkilled,
                    R.drawable.ic_games_pacman_256,
                    R.drawable.ic_games_chess,
            };
            String[] packageName = {
                    null,
                    null,
                    "com.mojang.minecraftpe",
                    "com.madfingergames.unkilled",
                    "eu.bandainamcoent.pacman256",
                    "com.pirinel.chess",
            };

            String[] apkLinkDownload = {
                    null,
                    null,
                    "https://umntv.net/UMNTV/MINECTt.apk",
                    null,
                    null,
                    null
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
        umn.setBackgroundImageStringUri(ResourceHelpers.toStringUri(R.drawable.games_bg_umn_games));
        umn.setIconStringUri(ResourceHelpers.toStringUri(resourceId));
        umn.setLinkApkDownload(linkApkDownload);
        return umn;
    }
}
