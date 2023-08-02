package com.umntv.launcher.main.row.umn_tv.detail.download_center;

public class DownloadCenterItem {

    private final String title;

    private final String subTitle;

    private final String body;

    public DownloadCenterItem(String title, String subTitle, String body) {
        this.title = title;
        this.subTitle = subTitle;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getBody() {
        return body;
    }
}
