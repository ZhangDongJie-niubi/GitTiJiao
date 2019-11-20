package Appliction;

import android.app.Application;

public class Grenndaoappliction extends Application {
    private static Grenndaoappliction app;

    public Grenndaoappliction() {
        app = this;
    }
    public static Grenndaoappliction getApp() {
        return app;
    }


}
