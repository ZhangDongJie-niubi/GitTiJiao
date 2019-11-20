package greendaoappliction;

import android.app.Application;

public class GreenDaoAppliction extends Application {
    public static GreenDaoAppliction app;

    public GreenDaoAppliction() {
        app = this;
    }

    public static GreenDaoAppliction getApp() {
        return app;
    }
}
