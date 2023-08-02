package x96.mate.launcher.main.row.umn_tv;

import androidx.annotation.Nullable;

import x96.mate.launcher.base.CardAppAndLink;
import x96.mate.launcher.base.CardVisitor;

public class UmnTvCard extends CardAppAndLink {

    private String linkApkDownload;

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
