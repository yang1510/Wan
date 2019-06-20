package jy.com.wanandroid.login;

import com.trello.rxlifecycle2.LifecycleProvider;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.disposables.Disposable;
import jy.com.wanandroid.AppConstant.LoginParamsKey;
import jy.com.wanandroid.base.IBaseCallBack;
import jy.com.wanandroid.data.entity.User;
import jy.com.wanandroid.data.repositories.LoginRepository;

/*
 * created by taofu on 2019-06-11
 **/
public class LoginPresenter implements LoginContract.ILoginPresenter {


    private LoginContract.ILoginView mView;
    private LoginContract.ILoginSource mLoginSource;


    public LoginPresenter() {
        mLoginSource = new LoginRepository();
    }


    @Override
    public void register(String username, String password, String repassword) {
        Map<String, String> params = new HashMap<>();
        params.put(LoginParamsKey.USER_NAME, username);
        params.put(LoginParamsKey.PASSWORD, password);
        params.put(LoginParamsKey.REPASSWORD, repassword);
        mLoginSource.register((LifecycleProvider) mView, params,mCallBack);


    }

    @Override
    public void login(String username, String password) {
        Map<String, String> params = new HashMap<>();
        params.put(LoginParamsKey.USER_NAME, username);
        params.put(LoginParamsKey.PASSWORD, password);
        mLoginSource.login((LifecycleProvider) mView, params,mCallBack);
    }




    private IBaseCallBack<User> mCallBack = new IBaseCallBack<User>() {
        @Override
        public void onSuccess(User data) {
            if(mView != null){
                mView.onSuccess(data);
            }
        }

        @Override
        public void onFail(String msg) {
            if(mView != null){
                mView.onFail(msg);
            }
        }
    };

    @Override
    public void attachView(LoginContract.ILoginView view) {
        mView = view;
    }

    @Override
    public void detachView(LoginContract.ILoginView view) {
        mView = null;
    }
}
