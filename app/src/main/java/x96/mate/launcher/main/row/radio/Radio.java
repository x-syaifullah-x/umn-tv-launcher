package x96.mate.launcher.main.row.radio;

import x96.mate.launcher.R;
import x96.mate.launcher.util.ResourceHelpers;

import java.util.ArrayList;
import java.util.List;

public final class Radio {

    public final static String TRAP_BEATS_NAME = "TRAP BEATS";
    public final static String HMONG_SONGS = "HMONG SONGS";
    public final static String THAI_LAO_KARAOKE = "THAI/LAO KARAOKE";

    private static final List<RadioCard> radio = new ArrayList<>();

    public static List<RadioCard> setup() {
        if (radio.isEmpty()) {
            String[] apkLinkDownloadApk = {
//                    "https://umntv.net/UMNTV_Builds/Builds19/UMN_Radio_UMNTV_1.apk",
                    null,
                    null,
                    null,
                    null,
                    null
            };

            String[] packageName = {
//                    "radio.umn.net",
                    null,
                    null,
                    null,
                    null,
                    "com.famousbluemedia.yokee"
            };

            String[] youtubeId = {
//                    null, "5qap5aO4i9A https://www.youtube.com/embed/0-fnoR20TQQ", null, null, null, null
                    "jfKfPfyJRdk https://www.youtube.com/shorts 5yx6BWlEVcY", null, null, null, null
            };

            String[] title = {
//                    "UMN RADIO",
                    "STUDY MUSIC",
                    TRAP_BEATS_NAME,
                    HMONG_SONGS,
                    THAI_LAO_KARAOKE,
                    "KARAOKE"
            };

            String[] description = {
//                    null,
                    "\uD83E\uDD17 Thank you for listening, I hope you will have a good time here ✔️ | This music is free to use in your livestreams & videos",
                    "Beat are available for purchase from these sources via YouTube\nThis content is provided by these sources via YouTube\nTo view commercial free please select to view in \"Chrome\"",
                    "This content is provided by these sources via YouTube\nTo view commercial free please select to view in \"Chrome\"",
                    "This content is provided by these sources via YouTube\nTo view commercial free please select to view in \"Chrome\"",
                    null
            };

            String[] link = {
//                    null,
                    null,
                    "https://www.youtube.com/embed/j3AhWUx7IqA?list=PLjk8Jdc9PVxuqIzqiST9h1bZQtLcJQFV3 https://www.youtube.com/embed/ehCBXmvSxhs?list=PLrteebjlQmI9eyxcVAVtiM3Ue43dUBpxt https://www.youtube.com/embed/bEKUOx_owFk?list=PLHKAN8O8G3sc8K9XdSTzh6QRISFgUvE8_ https://www.youtube.com/embed/VeRGx1lDWBI?list=PL3Gd7XKQifYdEiUvgmjLyeZZ1dzUyKqN8",
                    "https://www.youtube.com/embed/Zp2g1MFWqJk?app=desktop&feature=emb_imp_woyt&list=PLG-JAis-cw0IU_-GHrJ0Q7CPsU1oGNg3_ https://www.youtube.com/embed/ukdZ4DTALBo?app=desktop&feature=emb_imp_woyt&list=PL0651CF9C8154D178 https://www.youtube.com/embed/960HaJ4J0kk?app=desktop&feature=emb_imp_woyt&list=PLJ6dsbVCaLPhtQ3e3-OHl_sW20JLhkRL1 https://www.youtube.com/embed/b2s5FYpH_y4?app=desktop&feature=emb_imp_woyt&list=PLAGiZc-0D7Jm_9PwXU9bCtGLPWORNsQtL",
                    "https://www.youtube.com/embed/PunLBJwAiX0?list=PLXR4R2rvC8Z5i9SURXbjVMV6icSVUWk2w https://www.youtube.com/embed/Ds7sDGAPl5I?list=PLispDnzIMNq70c3k6xAAuEjdzA6ENJMbf https://www.youtube.com/embed/3rT8gyV5RX0?list=PLdZzClTcgSlU_YzWu99YJPPqcEMEpIKBw https://www.youtube.com/embed/wqJsZYibWcI?list=PLeQlgf5H84mfXRDGtaFiGOOef-szLM7Ov",
                    null,
            };

            String[] backgroundImageUrl = {
//                    ResourceHelpers.toStringUri(R.drawable.radio_bg_umn_radio),
                    ResourceHelpers.toStringUri(R.drawable.ic_radio_studio_music_bg),
                    ResourceHelpers.toStringUri(R.drawable.ic_radio_trap_beats),
                    ResourceHelpers.toStringUri(R.drawable.ic_radio_hmong_songs),
                    ResourceHelpers.toStringUri(R.drawable.ic_radio_thai),
                    ResourceHelpers.toStringUri(R.drawable.ic_radio_umn_radio)
            };
            String[] cardImageUrl = {
//                    ResourceHelpers.toStringUri(R.drawable.radio_ic_umn_radio),
                    ResourceHelpers.toStringUri(R.drawable.ic_radio_studio_music),
                    ResourceHelpers.toStringUri(R.drawable.ic_radio_trap_beats),
                    ResourceHelpers.toStringUri(R.drawable.ic_radio_hmong_songs),
                    ResourceHelpers.toStringUri(R.drawable.ic_radio_thai),
                    ResourceHelpers.toStringUri(R.drawable.ic_radio_karaoke),
            };
            String[] detailImageUrl = {
//                    null,
                    ResourceHelpers.toStringUri(R.drawable.ic_radio_studio_music_detail),
                    ResourceHelpers.toStringUri(R.drawable.ic_radio_trap_beats),
                    ResourceHelpers.toStringUri(R.drawable.ic_radio_hmong_songs),
                    ResourceHelpers.toStringUri(R.drawable.ic_radio_thai),
                    null
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
                                cardImageUrl[index],
                                detailImageUrl[index]
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
            String cardImageUrl,
            String detailImageUrl) {
        RadioCard r = new RadioCard();
        r.setYoutubeId(youtubeId);
        r.setPackageName(packageName);
        r.setLinkApkDownload(linkDownloadApk);
        r.setTitle(title);
        r.setDetailDescription(description);
        r.setIconStringUri(cardImageUrl);
        r.setBackgroundImageStringUri(ResourceHelpers.toStringUri(R.drawable.bg_ironman_replace));
        r.setDetailImageStringUri(detailImageUrl);
        r.setLink(link);
        return r;
    }
}