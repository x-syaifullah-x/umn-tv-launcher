package x96.mate.launcher.main.row.apps.app_drawer;

import x96.mate.launcher.base.Card;
import x96.mate.launcher.base.CardVisitor;

public class AppDrawerCard extends Card {

    private String dataDir;
    private boolean sysApp;

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

    @Override
    public void onClicked(CardVisitor visitor) {
        visitor.click(this);
    }
}
