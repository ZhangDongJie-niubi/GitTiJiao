package two;

import android.app.Application;

public class GrennDao1 extends Application {
    public static GrennDao1 app;
    public GrennDao1(){
        app=this;
    }
    public static GrennDao1 getApp(){
        return app;
    }
}
