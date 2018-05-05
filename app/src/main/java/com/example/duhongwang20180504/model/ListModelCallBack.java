package com.example.duhongwang20180504.model;


import com.example.duhongwang20180504.bean.ListBean;

/**
 * 商品列表model层接口
 */
public interface ListModelCallBack {
    public void success(ListBean searchBean); //请求成功数据
    public void failure(Exception e);           //请求数据失败
}
