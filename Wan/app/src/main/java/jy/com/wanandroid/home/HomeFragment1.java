package jy.com.wanandroid.home;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import jy.com.libbanner.JBanner;
import jy.com.libbanner.IJBannerAdapter;
import jy.com.wanandroid.GlideApp;
import jy.com.wanandroid.R;
import jy.com.wanandroid.base.BaseFragment;
import jy.com.wanandroid.home.banner.Banner;
import jy.com.wanandroid.utils.SystemFacade;

/*
 * created by taofu on 2019-06-18
 **/
public class HomeFragment1 extends BaseFragment {

    private JBanner mBanner;





    @Override
    protected boolean isNeedToAddBackStack() {
        return false;

    }

    @Override
    public boolean isNeedAnimation() {
        return false;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home_1, container, false);;

        mBanner = v.findViewById(R.id.home_top_banner);


        List<Banner> banners =  Banner.getBanners();
        mBanner.setLoop(banners.size() > 1);

        ArrayList titles = new ArrayList();

        for(Banner banner : banners){

            titles.add(banner.getTitle());
        }
        mBanner.setData(banners, titles);


        mBanner.setAdapter(new IJBannerAdapter<Banner>() {
            @Override
            public void fillBannerItemData(JBanner banner, ImageView imageView, Banner mode, int position) {
                GlideApp.with(banner.getContext()).load(mode.getImgUrl()).into(imageView);
            }


        });



        return v;
    }




}
