package com.umntv.launcher.main.row.games.umn_games;

import com.umntv.launcher.main.base.ApkData;
import com.umntv.launcher.main.base.OverviewItem;

import java.util.List;

import media.umn.tv.R;

public class DataSource {

    private static final OverviewItem RETRO = new OverviewItem(
            R.drawable.games_umn_games_ic,
            R.drawable.ic_games_umn_games_retro,
            "UMN RETRO",
            "WELCOME TO UMN RETRO",
            OverviewItem.SUBTITLE_DEFAULT,
            "UMN Retro is a Kodi-based platform that allows users to play over 10,000+ vintage retro video games and original format.",
            new ApkData(
                    "https://umntvdealers.net/UMNTV/Apks/KODI 19/UMN_RETRO_UMNTV_1.apk",
                    "retro.umn.net",
                    false
            )
    );

    private static final OverviewItem ROBLOX = new OverviewItem(
            R.drawable.ic_games_umn_games_roblox,
            R.drawable.ic_games_umn_games_roblox,
            "ROBLOX",
            "WELCOME TO ROBLOX",
            OverviewItem.SUBTITLE_DEFAULT,
            "Roblox is the ultimate virtual universe that lets you create, share experiences with friends, and be anything you can imagine. Join millions of people and discover an infinite variety of immersive experiences created by a global community!",
            new ApkData(
                    "https://umntvdealers.net/UMNTV/Apks/KODI 19/Roblox_v2.543.566_apkpure.com.apk",
                    "com.roblox.client",
                    false
            )
    );

    private static final OverviewItem PUBG = new OverviewItem(
            R.drawable.ic_games_umn_games_pubg,
            R.drawable.ic_games_umn_games_pubg,
            "PUBG",
            "WELCOME TO PUBG",
            OverviewItem.SUBTITLE_DEFAULT,
            "Lots of events for you to explore.Climb to the top in PUBG MOBILE and fire at will. PUBG MOBILE is an original battle royale mobile game and one of the best mobile shooting games.",
            new ApkData(
                    "https://umntvdealers.net/UMNTV/Apks/KODI 19/com.tencent.ig_2.1.0-16490_minAPI18(armeabi-v7a)(nodpi)_apkmirror.com.apk",
                    "com.tencent.ig",
                    false
            )
    );

    private static final OverviewItem CALL_OF_DUTY = new OverviewItem(
            R.drawable.ic_games_umn_games_call_of_duty,
            R.drawable.ic_games_umn_games_call_of_duty,
            "CALL OF DUTY",
            "WELCOME TO CALL OF DUTY",
            OverviewItem.SUBTITLE_DEFAULT,
            "The CALL OF DUTY® you know and love now on your mobile device. With multiplayer (MP) modes such as Team Deathmatch, Domination, and Kill-Confirmed on iconic maps such as Shipment, Raid, and Standoff, as well as 100 player Battle Royale (BR), CALL OF DUTY®: MOBILE has it all! Play Multiplayer (MP) and Battle Royale (BR)!",
            new ApkData(
                    "https://umntvdealers.net/UMNTV/Apks/KODI 19/com.activision.callofduty.shooter_1.0.34-APK_Award.apk",
                    "com.activision.callofduty.shooter",
                    false
            )
    );

    private static final OverviewItem GAMEPAD = new OverviewItem(
            R.drawable.ic_games_umn_games_gamepad,
            R.drawable.ic_games_umn_games_gamepad,
            "GAMEPAD",
            "WELCOME TO GAMEPAD",
            OverviewItem.SUBTITLE_DEFAULT,
            "Panda Gamepad is a specifically designed keymapper for gamepad.",
            new ApkData(
                    "https://umntvdealers.net/UMNTV/Apks/KODI%2019/Panda_Gamepad.apk",
                    "com.panda.gamepad",
                    false
            )
    );

    public static final String ADB_REMOTE_COMMAND = "sh /sdcard/.chaozhuo.gameassistant2/inject.sh";

    private static final OverviewItem REMOTE_ADB = new OverviewItem(
            R.drawable.ic_games_umn_games_remote_adb,
            R.drawable.ic_games_umn_games_remote_adb,
            "REMOTE ADB",
            "WELCOME TO REMOTE ADB",
            OverviewItem.SUBTITLE_DEFAULT,
            "Remote ADB Shell is a terminal app that allows you to connect to the ADB shell service of other Android devices over the network and execute terminal commands.\n" +
                    "PLEASE NOTE: The ADB command link will be automatically copied once the remote ADB tab is selected.",
            new ApkData(
                    ADB_REMOTE_COMMAND + "=https://umntvdealers.net/UMNTV/Apks/KODI%2019/ADBSHELL.apk",
                    "com.cgutman.androidremotedebugger",
                    false
            )
    );

    public static final List<OverviewItem> items = List.of(
            RETRO,
            ROBLOX,
            PUBG,
            CALL_OF_DUTY,
            GAMEPAD,
            REMOTE_ADB
    );
}
