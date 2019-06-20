package jy.com.wanandroid.base;

import io.reactivex.disposables.Disposable;

/*
 * created by taofu on 2019/5/5
 **/
public interface IBaseCallBack<T> {

    void onSuccess(T data);
    void onFail(String msg);
}
