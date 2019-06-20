package jy.com.wanandroid;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import com.cunoraz.gifview.library.GifView;

import jy.com.wanandroid.base.BaseActivity;
import jy.com.wanandroid.login.LoginRegisterActivity;
import jy.com.wanandroid.utils.SPUtils;
import jy.com.wanandroid.widget.view.LoadingPage;

/*
 * created by taofu on 2019-06-11
 **/
public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_splash);

        init();


        FrameLayout viewGroup = findViewById(R.id.container);

/*
        TextView textView = new TextView(this);
        textView.setId(1000);
        textView.setMaxLines(1);
        textView.setBackgroundColor(Color.GRAY);
        textView.setGravity(Gravity.RIGHT);
        textView.setText("Hello");
        textView.setEllipsize(TextUtils.TruncateAt.END);


        viewGroup.addView(textView,new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_CONSTRAINT, ConstraintLayout.LayoutParams.WRAP_CONTENT));
        ConstraintSet constraintSet = new ConstraintSet();


        constraintSet.clone(viewGroup);
        constraintSet.connect(textView.getId(),ConstraintSet.START,ConstraintSet.PARENT_ID, ConstraintSet.START);
        constraintSet.connect(textView.getId(),ConstraintSet.END,ConstraintSet.PARENT_ID, ConstraintSet.END);
        constraintSet.connect(textView.getId(),ConstraintSet.BOTTOM,ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM);

        constraintSet.applyTo(viewGroup);*/
        //viewGroup.addView(PageFactory.createView(this));

        //startActivity(new Intent(this,LoginRegisterActivity.class));

    }


    private void init(){


        String cookie = SPUtils.getValue(AppConstant.LoginParamsKey.SET_COOKIE_KEY);

        if(!TextUtils.isEmpty(cookie)){
            WAApplication.mIsLogin = true;
        }else{
            WAApplication.mIsLogin  = false;
        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
