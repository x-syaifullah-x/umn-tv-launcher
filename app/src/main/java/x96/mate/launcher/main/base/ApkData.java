package x96.mate.launcher.main.base;

public class ApkData {
    public final String url;
    public final String packageName;
    public final boolean isPrivate;

    public ApkData(String url, String packageName, boolean isPrivate) {
        this.url = url;
        this.packageName = packageName;
        this.isPrivate = isPrivate;
    }
}