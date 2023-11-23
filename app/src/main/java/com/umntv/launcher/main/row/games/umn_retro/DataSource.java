package com.umntv.launcher.main.row.games.umn_retro;

import com.umntv.launcher.main.base.ApkData;
import com.umntv.launcher.main.base.OverviewItem;

import java.util.List;

import media.umn.tv.R;

public class DataSource {

    private static final OverviewItem UMN_RETRO = new OverviewItem(
            R.drawable.ic_umn_retro_umn_retro,
            R.drawable.ic_umn_retro_umn_retro_bg,
            "UMN RETRO",
            "WELCOME TO UMN RETRO",
            OverviewItem.SUBTITLE_DEFAULT,
            "UMN Retro is a Kodi-based platform that allows users to play over 10,000+ vintage retro video games and original format.\nSee Instructors for more information.",
            new ApkData(
                    "https://umntvdealers.net/UMNTV/Apks/KODI 19/UMN_RETRO_UMNTV_1.apk",
                    "retro.umn.net",
                    false
            )
    );

    private static final OverviewItem UMN_PS_1 = new OverviewItem(
            R.drawable.ic_umn_retro_umn_games_ps1_new,
            R.drawable.ic_umn_retro_umn_games_ps1_new,
            "UMN_PS1",
            "WELCOME TO UMN_PS1",
            OverviewItem.SUBTITLE_DEFAULT,
            "UMN_PS1 offers unlimited online game-playing of the original Sony PlayStation. \n" +
                    "SD cards or memory sticks are recommended for game storage.\nSee Instructors for more information.",
            new ApkData(
                    "https://umntv.net/UMNTV_Builds/Images/UMN_PS1.apk",
                    "com.epsxe.ePSXe",
                    false
            )
    );

    private static final OverviewItem UMN_PSP = new OverviewItem(
            R.drawable.ic_retro_umn_games_umn_psp_bg,
            R.drawable.ic_retro_umn_games_umn_psp_bg,
            "UMN_PSP",
            "WELCOME TO UMN_PSP",
            OverviewItem.SUBTITLE_DEFAULT,
            "UMN_PSP offers unlimited online game-playing of the original Sony PlayStation Portable.\n" +
                    "SD cards or memory sticks are recommended for game storage. \n" +
                    "Some games users may need to adjust the frame skipping.\nSee Instructors for more information.",
            new ApkData(
                    "https://umntv.net/UMNTV_Builds/Images/UMN_PSP.apk",
                    "org.ppsspp.ppsspp",
                    false
            )
    );

    private static final OverviewItem UMN_ARCADE = new OverviewItem(
            R.drawable.ic_retro_umn_games_umn_arcade_bg,
            R.drawable.ic_retro_umn_games_umn_arcade_bg,
            "UMN_ARCADE",
            "WELCOME TO UMN_ARCADE",
            OverviewItem.SUBTITLE_DEFAULT,
            "UMN_ARCADE offers unlimited online game-playing of the original Retro Arcade Games.\n" +
                    "SD cards or memory sticks are recommended for game storage.\nSee Instructors for more information.",
            new ApkData(
                    "https://umntv.net/UMNTV_Builds/Images/UMN_Arcade.apk",
                    "com.seleuco.mame4droid",
                    false
            )
    );

    private static final OverviewItem UMN_N64 = new OverviewItem(
            R.drawable.ic_retro_umn_games_umn_n64,
            R.drawable.ic_retro_umn_games_umn_n64,
            "UMN_N64",
            "WELCOME TO UMN_N64",
            OverviewItem.SUBTITLE_DEFAULT,
            "UMN_N64 offers game-playing on the Nintendo 64.\n" +
                    "SD cards or memory sticks are recommended for game storage.\nSee Instructors for more information.",
            new ApkData(
                    "https://umntv.net/UMNTV_Builds/Images/UMN_N64.apk",
                    "org.mupen64plusae.v3.fzurita",
                    false
            )
    );

    private static final OverviewItem GAME_PAD = new OverviewItem(
            R.drawable.ic_retro_umn_games_gamepad,
            R.drawable.ic_retro_umn_games_gamepad,
            "GAMEPAD",
            "WELCOME TO GAMEPAD",
            OverviewItem.SUBTITLE_DEFAULT,
            "Panda Gamepad is a specifically designed keymapper for gamepad.\nSee Instructors for more information.",
            new ApkData(
                    "https://umntvdealers.net/UMNTV/Apks/KODI%2019/Panda_Gamepad.apk",
                    "com.panda.gamepad",
                    false
            )
    );

    public static final String ADB_REMOTE_COMMAND = "sh /sdcard/.chaozhuo.gameassistant2/inject.sh";

    private static final OverviewItem REMOTE_ADB = new OverviewItem(
            R.drawable.ic_retro_umn_games_remote_adb,
            R.drawable.ic_retro_umn_games_remote_adb,
            "REMOTE ADB",
            "WELCOME TO REMOTE ADB",
            OverviewItem.SUBTITLE_DEFAULT,
            "Remote ADB Shell is a terminal app that allows you to connect to the ADB shell service of other Android devices over the network and execute terminal commands.\n" +
                    "PLEASE NOTE: The ADB command link will be automatically copied once the remote ADB tab is selected.\nSee Instructors for more information.",
            new ApkData(
                    ADB_REMOTE_COMMAND + "=https://umntvdealers.net/UMNTV/Apks/KODI%2019/ADBSHELL.apk",
                    "com.cgutman.androidremotedebugger",
                    false
            )
    );

    public static final List<OverviewItem> items = List.of(
            UMN_RETRO,
            UMN_PS_1,
            UMN_PSP,
            UMN_ARCADE,
            UMN_N64,
            GAME_PAD,
            REMOTE_ADB
    );
}
