package x96.mate.launcher.main.row.games;

import androidx.annotation.Nullable;

import x96.mate.launcher.base.CardApp;
import x96.mate.launcher.base.CardVisitor;

public class GamesCardApp extends CardApp {
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
