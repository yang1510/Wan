package jy.com.wanandroid;

import android.app.Application;
import android.content.Context;

/*
 * created by taofu on 2019-06-11
 **/
public class WAApplication extends Application {

    public static Application mApplicationContext;


    public static boolean mIsLogin = false;


    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationContext = this;
    }
}
