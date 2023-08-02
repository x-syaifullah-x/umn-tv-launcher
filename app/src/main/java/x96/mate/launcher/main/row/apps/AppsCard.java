package x96.mate.launcher.main.row.apps;

import x96.mate.launcher.base.CardApp;
import x96.mate.launcher.base.CardVisitor;

public class AppsCard extends CardApp {

    private String classNameActivityDetail;

    public String getClassNameActivityDetail() {
        return classNameActivityDetail;
    }

    public void setClassNameActivityDetail(String classNameActivityDetail) {
        this.classNameActivityDetail = classNameActivityDetail;
    }

    @Override
    public void onClicked(CardVisitor visitor) {
        visitor.click(this);
    }
}
