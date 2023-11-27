package com.umntv.launcher.main.row.radio;

import com.umntv.launcher.util.ResourceHelpers;

import java.util.ArrayList;
import java.util.List;

import media.umn.tv.R;

public final class Radio {

    public final static String TRAP_BEATS_NAME = "TRAP BEATS";
    public final static String HMONG_SONGS = "HMONG PLAYLIST";
    public final static String THAI_LAO_KARAOKE = "THAI/LAO PLAYLIST";
    public final static String UMN_PLAYLIST = "UMN PLAYLIST";
    public final static String STUDY_MUSIC = "STUDY MUSIC";

    private static final List<RadioCard> radio = new ArrayList<>();

    public static List<RadioCard> setup() {
        if (radio.isEmpty()) {
            String[] apkLinkDownloadApk = {
                    "https://umntv.net/UMNTV_Builds/Builds19/UMN_Radio_UMNTV_1.apk",
                    null,
                    null,
                    null,
                    null,
                    null
            };

            String[] packageName = {
                    "radio.umn.net",
                    null,
                    null,
                    null,
                    null,
                    null
            };

            String[] youtubeId = {
                    null, null, "jfKfPfyJRdk https://www.youtube.com/shorts 5yx6BWlEVcY", null, null, null
            };

            String[] title = {
                    "UMN RADIO",
                    UMN_PLAYLIST,
                    STUDY_MUSIC,
                    TRAP_BEATS_NAME,
                    HMONG_SONGS,
                    THAI_LAO_KARAOKE,
            };

            String[] description = {
                    null,
                    null,
                    "",
                    "",
                    "",
                    "",
            };

            String[] link = {
                    null,
                    "https://www.youtube.com/watch_popup?v=05UsJyQC3n8 https://www.youtube.com/watch_popup?v=9JF5sIMxJ_U https://www.youtube.com/watch_popup?v=0cDlBvqrkDU  https://www.youtube.com/watch_popup?v=nCrKk-g8kXg  https://www.youtube.com/watch_popup?v=G-6fxr7alng https://www.youtube.com/watch_popup?v=F4aby5WN1Rw ",
                    null,
                    "https://www.youtube.com/embed/j3AhWUx7IqA?list=PLjk8Jdc9PVxuqIzqiST9h1bZQtLcJQFV3 https://www.youtube.com/embed/ehCBXmvSxhs?list=PLrteebjlQmI9eyxcVAVtiM3Ue43dUBpxt https://www.youtube.com/embed/bEKUOx_owFk?list=PLHKAN8O8G3sc8K9XdSTzh6QRISFgUvE8_ https://www.youtube.com/embed/VeRGx1lDWBI?list=PL3Gd7XKQifYdEiUvgmjLyeZZ1dzUyKqN8",
                    "https://www.youtube.com/embed/Zp2g1MFWqJk?app=desktop&feature=emb_imp_woyt&list=PLG-JAis-cw0IU_-GHrJ0Q7CPsU1oGNg3_ https://www.youtube.com/embed/ukdZ4DTALBo?app=desktop&feature=emb_imp_woyt&list=PL0651CF9C8154D178 https://www.youtube.com/embed/960HaJ4J0kk?app=desktop&feature=emb_imp_woyt&list=PLJ6dsbVCaLPhtQ3e3-OHl_sW20JLhkRL1 https://www.youtube.com/embed/b2s5FYpH_y4?app=desktop&feature=emb_imp_woyt&list=PLAGiZc-0D7Jm_9PwXU9bCtGLPWORNsQtL",
                    "https://www.youtube.com/embed/PunLBJwAiX0?list=PLXR4R2rvC8Z5i9SURXbjVMV6icSVUWk2w https://www.youtube.com/embed/Ds7sDGAPl5I?list=PLispDnzIMNq70c3k6xAAuEjdzA6ENJMbf https://www.youtube.com/embed/3rT8gyV5RX0?list=PLdZzClTcgSlU_YzWu99YJPPqcEMEpIKBw https://www.youtube.com/embed/wqJsZYibWcI?list=PLeQlgf5H84mfXRDGtaFiGOOef-szLM7Ov",
            };

            String[] cardImageUrl = {
                    ResourceHelpers.toStringUri(R.drawable.radio_ic_umn_radio),
                    ResourceHelpers.toStringUri(R.drawable.ic_radio_karaoke),
                    ResourceHelpers.toStringUri(R.drawable.ic_radio_studio_music),
                    ResourceHelpers.toStringUri(R.drawable.ic_radio_trap_beats),
                    ResourceHelpers.toStringUri(R.drawable.ic_radio_hmong_songs),
                    ResourceHelpers.toStringUri(R.drawable.ic_radio_thai),
            };

            for (int index = 0; index < title.length; ++index) {
                radio.add(
                        buildRadioInfo(
                                youtubeId[index],
                                packageName[index],
                                apkLinkDownloadApk[index],
                                title[index],
                                description[index],
                                link[index],
                                cardImageUrl[index]
//                                detailImageUrl[index]
                        )
                );
            }
        }
        return radio;
    }

    private static RadioCard buildRadioInfo(
            String youtubeId,
            String packageName,
            String linkDownloadApk,
            String title,
            String description,
            String link,
            String cardImageUrl
    ) {
        RadioCard r = new RadioCard();
        r.setYoutubeId(youtubeId);
        r.setPackageName(packageName);
        r.setLinkApkDownload(linkDownloadApk);
        r.setTitle(title);
        r.setDetailDescription(description);
        r.setIconStringUri(cardImageUrl);
        r.setBackgroundStringUri(ResourceHelpers.toStringUri(R.drawable.radio_bg_umn_radio));
        r.setLink(link);
        return r;
    }
}