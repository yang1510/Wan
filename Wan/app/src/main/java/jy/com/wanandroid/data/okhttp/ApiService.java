package jy.com.wanandroid.data.okhttp;


import java.util.Map;

import io.reactivex.Observable;
import jy.com.wanandroid.AppConstant;
import jy.com.wanandroid.data.entity.HttpResult;
import jy.com.wanandroid.data.entity.User;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/*
 * created by taofu on 2019-06-11
 **/
public interface ApiService {

    @POST(AppConstant.WEB_SITE_REGISTER)
    @FormUrlEncoded
    Observable<HttpResult<User>> register(@FieldMap Map<String,String> params);

    @POST(AppConstant.WEB_SITE_LOGIN)
    @FormUrlEncoded
    Observable<HttpResult<User>> login(@FieldMap Map<String,String> params);



}
