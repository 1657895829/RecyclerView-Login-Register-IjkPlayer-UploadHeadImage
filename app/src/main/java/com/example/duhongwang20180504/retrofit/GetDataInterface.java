package com.example.duhongwang20180504.retrofit;

import com.example.duhongwang20180504.bean.ListBean;

import java.util.Map;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * 网络接口数据的请求类
 */
public interface GetDataInterface {

    //笔记本 手机的接口,集合传参
    //https://www.zhaoapi.cn/product/searchProducts?keywords=笔记本&page=1
    @GET("/product/searchProducts")
    Call<ListBean> getEdit(@QueryMap Map<String,String> map);
}
