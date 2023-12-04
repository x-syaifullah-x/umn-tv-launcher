package com.umntv.launcher.main.row.games.umn_games;

import com.umntv.launcher.main.base.ApkData;
import com.umntv.launcher.main.base.OverviewItem;

import java.util.List;

import media.umn.tv.R;

public class DataSource {

    private static final OverviewItem UMN_PS_1 = new OverviewItem(
            R.drawable.ic_games_umn_games_ps1,
            R.drawable.ic_games_umn_games_ps1,
            "UMN_PS1",
            "WELCOME TO UMN_PS1",
            OverviewItem.SUBTITLE_DEFAULT,
            "UMN_PS1 offers unlimited online game-playing of the original Sony PlayStation.<br/>" +
                    "SD cards or memory sticks are recommended for game storage.<br/>See Instructors for more information.<br/><br/><font color='black'>NOTE: YOU WILL NEED TO DOWNLOAD THE PS1 BIOS FILE BEFORE PLAYING</font>",
            new ApkData(
                    "https://n0render.com/ps1/",
                    "com.umn.n0.render",
                    false
            )
    );

    private static final OverviewItem UMN_PSP = new OverviewItem(
            R.drawable.ic_games_umn_games_psp,
            R.drawable.ic_games_umn_games_psp,
            "UMN_PSP",
            "WELCOME TO UMN_PSP",
            OverviewItem.SUBTITLE_DEFAULT,
            "UMN_PSP offers unlimited online game-playing of the original Sony PlayStation Portable.<br/>" +
                    "SD cards or memory sticks are recommended for game storage.<br/>" +
                    "See Instructors for more information.<br/><br/><font color='black'>NOTE: SOME GAMES USERS WILL NEED TO ADJUST FAME SKIPPING</font>",
            new ApkData(
                    "https://n0render.com/psp/",
                    "com.umn.n0.render",
                    false
            )
    );

    private static final OverviewItem UMN_ARCADE = new OverviewItem(
            R.drawable.ic_games_umn_games_arcade,
            R.drawable.ic_games_umn_games_arcade,
            "UMN_ARCADE",
            "WELCOME TO UMN_ARCADE",
            OverviewItem.SUBTITLE_DEFAULT,
            "UMN_ARCADE offers unlimited online game-playing of the original Retro Arcade Games.\n" +
                    "SD cards or memory sticks are recommended for game storage.\nSee Instructors for more information.",
            new ApkData(
                    "https://n0render.com/arcade/",
                    "com.umn.n0.render",
                    false
            )
    );

    private static final OverviewItem UMN_N64 = new OverviewItem(
            R.drawable.ic_games_umn_games_n64,
            R.drawable.ic_games_umn_games_n64,
            "UMN_N64",
            "WELCOME TO UMN_N64",
            OverviewItem.SUBTITLE_DEFAULT,
            "UMN_N64 offers game-playing on the Nintendo 64.\n" +
                    "SD cards or memory sticks are recommended for game storage.\nSee Instructors for more information.",
            new ApkData(
                    "https://n0render.com/n64/",
                    "com.umn.n0.render",
                    false
            )
    );

    private static final OverviewItem INSTRUCTIONS = new OverviewItem(
            R.drawable.ic_games_umn_games_instructions,
            R.drawable.ic_games_umn_games_instructions,
            "INSTRUCTIONS",
            "WELCOME TO INSTRUCTIONS",
            OverviewItem.SUBTITLE_DEFAULT,
            "",
            new ApkData(
                    "https://n0render.com/inst/",
                    "com.umn.n0.render",
                    false
            )
    );

    public static final List<OverviewItem> items = List.of(
            UMN_PS_1,
            UMN_PSP,
            UMN_ARCADE,
            UMN_N64,
            INSTRUCTIONS
    );
}
