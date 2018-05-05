package com.example.duhongwang20180504.common;

import java.util.Map;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * 注册的接口
 */

public interface IGetService {

    //http://120.27.23.105/user/reg?mobile=13534245633&password=55555554

    @GET
    Observable<String> regist(@Url String url, @QueryMap Map<String, String> map);

}
