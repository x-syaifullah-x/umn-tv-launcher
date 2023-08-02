package x96.mate.launcher.main.row.news.detail;

import androidx.annotation.DrawableRes;

import x96.mate.launcher.main.base.ApkData;

public class OverviewItem {

    @DrawableRes
    public final int icon;
    @DrawableRes
    public final int bg;
    public final String titleAction;
    public final String title;
    public final String subTitle;
    public final String body;
    public final String url;
    public final ApkData apkData;

    public OverviewItem(int icon, int bg, String titleAction, String title, String subTitle, String body, String url, ApkData apkData) {
        this.icon = icon;
        this.bg = bg;
        this.titleAction = titleAction;
        this.title = title;
        this.subTitle = subTitle;
        this.body = body;
        this.url = url;
        this.apkData = apkData;
    }
}