package x96.mate.launcher.main.row.games;

import java.util.ArrayList;
import java.util.List;

import x96.mate.launcher.util.ResourceHelpers;
import x96.mate.launcher.R;

public class Games {

    private static final List<GamesCardApp> games = new ArrayList<>();

    public static List<GamesCardApp> setup() {
        if (games.isEmpty()) {
            String[] title = {
//                    "UMN GAMES",
                    "MINECRAFT",
                    "UNKILLED",
                    "PAC-MAN256",
                    "CHESS",
            };
            int[] resourceId = {
//                    R.drawable.games_umn_games_ic,
                    R.drawable.ic_games_minecraft,
                    R.drawable.ic_games_unkilled,
                    R.drawable.ic_games_pacman_256,
                    R.drawable.ic_games_chess,
            };
            String[] packageName = {
//                    "tv.umn.retro",
//                    null,
                    "com.mojang.minecraftpe",
                    "com.madfingergames.unkilled",
                    "eu.bandainamcoent.pacman256",
                    "com.pirinel.chess",
            };

            String[] apkLinkDownload = {
//                    "https://umntv.net/UMNTV/umntv_RETRO_5.apk",
//                    null,
                    "https://umntv.net/UMNTV/MINECTt.apk",
                    null,
                    null,
                    null
            };
            for (int index = 0; index < title.length; ++index) {
                games.add(
                        buildQuickAppInfo(
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

    private static GamesCardApp buildQuickAppInfo(String title, int resourceId, String packageName, String linkApkDownload) {
        GamesCardApp umn = new GamesCardApp();
        umn.setTitle(title);
        umn.setPackageName(packageName);
        umn.setBackgroundImageStringUri(ResourceHelpers.toStringUri(R.drawable.bg_ironman_replace));
        umn.setIconStringUri(ResourceHelpers.toStringUri(resourceId));
        umn.setLinkApkDownload(linkApkDownload);
        return umn;
    }
}
