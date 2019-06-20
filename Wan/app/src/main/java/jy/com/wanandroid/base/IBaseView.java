package jy.com.wanandroid.base;

import android.content.Context;

/*
 * created by taofu on 2019/5/5
 **/
public interface IBaseView<T extends IBasePresenter> {


    void setPresenter(T presenter);

    Context getContextObject();
}
