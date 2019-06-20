package jy.com.wanandroid.login;

import android.os.Bundle;

import androidx.annotation.Nullable;

import jy.com.wanandroid.R;
import jy.com.wanandroid.base.BaseActivity;

/*
 * created by taofu on 2019-06-11
 **/
public class LoginRegisterActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login_register);


        addFragment(getSupportFragmentManager(), LoginFragment.class, R.id.login_fragment_container, null);
    }
}
