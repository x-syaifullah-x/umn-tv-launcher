package x96.mate.launcher.main.row.apps.app_drawer;

import x96.mate.launcher.base.Card;
import x96.mate.launcher.base.CardVisitor;

public class LaunchApp extends Card {

    private String dataDir;
    private boolean sysApp;
    private String launcherName;
    private String packageName;

    public String getDataDir() {
        return this.dataDir;
    }

    public void setDataDir(String paramString) {
        this.dataDir = paramString;
    }

    public boolean isSysApp() {
        return sysApp;
    }

    public void setSysApp(boolean sysApp) {
        this.sysApp = sysApp;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setPackageName(String paramString) {
        this.packageName = paramString;
    }

    public String getLauncherName() {
        return launcherName;
    }

    public void setLauncherName(String launcherName) {
        this.launcherName = launcherName;
    }

    @Override
    public void onClicked(CardVisitor visitor) {
        visitor.click(this);
    }
}
