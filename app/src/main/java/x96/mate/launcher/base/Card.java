package x96.mate.launcher.base;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public abstract class Card implements Serializable {

    private String title;
    private Drawable iconDrawable;
    private String iconStringUri;
    private String detailImageStringUri;
    private String backgroundImageStringUri;
    private String detailDescription;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Drawable getIconDrawable() {
        return this.iconDrawable;
    }

    public void setIconDrawable(Drawable paramDrawable) {
        this.iconDrawable = paramDrawable;
    }

    public String getBackgroundImageStringUri() {
        return backgroundImageStringUri;
    }

    public void setBackgroundImageStringUri(String bgImageUrl) {
        this.backgroundImageStringUri = bgImageUrl;
    }

    public String getIconStringUri() {
        return iconStringUri;
    }

    public void setIconStringUri(String uriString) {
        this.iconStringUri = uriString;
    }

    public String getDetailImageStringUri() {
        return detailImageStringUri;
    }

    public void setDetailImageStringUri(String detailImageStringUri) {
        this.detailImageStringUri = detailImageStringUri;
    }

    public String getDetailDescription() {
        return detailDescription;
    }

    public void setDetailDescription(String detailDescription) {
        this.detailDescription = detailDescription;
    }

    public abstract void onClicked(CardVisitor visitor);
}
