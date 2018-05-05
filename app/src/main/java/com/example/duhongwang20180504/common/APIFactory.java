package com.example.duhongwang20180504.common;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 注册或登录封装的工厂模式
 */

public class APIFactory {
    private static APIFactory factory = null;

    public static APIFactory getInstance(){
        if(factory==null){
            synchronized (APIFactory.class){
                if(factory==null){
                    factory = new APIFactory();
                }
            }
        }
        return factory;
    }

    //注册或登录封装方法
    public void regist(String url, Map<String,String> map, Observer<String> observer){

        RetrofitUtils.getInstance().regist(url,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }
}
