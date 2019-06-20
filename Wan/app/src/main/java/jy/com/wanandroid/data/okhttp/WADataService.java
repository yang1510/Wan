package jy.com.wanandroid.data.okhttp;

import java.util.concurrent.TimeUnit;

import jy.com.wanandroid.AppConstant;
import jy.com.wanandroid.BuildConfig;
import jy.com.wanandroid.data.okhttp.interceptor.AddHeaderInterceptor;
import jy.com.wanandroid.data.okhttp.interceptor.SaveCookieInterceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/*
 * created by taofu on 2019-06-11
 **/
public class WADataService {


    private static final long DEFAULT_TIMEOUT = 20000;


    private static volatile ApiService mApiService;

    public static ApiService getService() {

        if (mApiService == null) {
            synchronized (WADataService.class) {
                if (mApiService == null) {
                    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

                    if (BuildConfig.DEBUG) {
                        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
                    } else {
                        logging.setLevel(HttpLoggingInterceptor.Level.NONE);
                    }


                    OkHttpClient httpClient = new OkHttpClient.Builder()
                            .addInterceptor(logging)
                            .addInterceptor(new SaveCookieInterceptor())
                            .addInterceptor(new AddHeaderInterceptor())
                            .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                            .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                            .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                            .build();

                    Retrofit retrofit = new Retrofit.Builder()
                            .client(httpClient)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .baseUrl(AppConstant.BASE_URL)
                            .build();

                    mApiService = retrofit.create(ApiService.class);
                }
            }
        }
        return mApiService;
    }
}
