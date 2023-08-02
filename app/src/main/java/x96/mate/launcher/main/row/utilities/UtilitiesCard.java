package x96.mate.launcher.main.row.utilities;

import androidx.annotation.Nullable;

import x96.mate.launcher.base.CardApp;
import x96.mate.launcher.base.CardVisitor;

public class UtilitiesCard extends CardApp {

    private String linkApkDownload;

    private String extra;

    public String getDataExtra() {
        return extra;
    }

    public void setDataExtra(String detailsClass) {
        this.extra = detailsClass;
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
