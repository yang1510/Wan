package jy.com.wanandroid.data.entity;

import androidx.annotation.Keep;

/*
 * created by taofu on 2019-06-11
 **/

public class HttpResult<T> {
    public int errorCode = -1;
    public String errorMsg;
    public T data;


    @Override
    public String toString() {
        return "HttpResult{" +
                "errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                ", data=" + (data == null ? " null " : data.toString()) +
                '}';
    }
}
