package x96.mate.launcher.main.row.radio;

import androidx.annotation.Nullable;

import x96.mate.launcher.base.CardAppAndLink;
import x96.mate.launcher.base.CardVisitor;

public class RadioCard extends CardAppAndLink {

    private String linkApkDownload;

    private String youtubeId;

    public String getYoutubeId() {
        return youtubeId;
    }

    public void setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
    }

    @Nullable
    public String getLinkApkDownload() {
        return linkApkDownload;
    }

    public void setLinkApkDownload(String linkApkDownload) {
        this.linkApkDownload = linkApkDownload;
    }

    @Override
    public void onClicked(CardVisitor visitor) {
        visitor.click(this);
    }
}