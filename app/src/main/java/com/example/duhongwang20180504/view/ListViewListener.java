package com.example.duhongwang20180504.view;


import com.example.duhongwang20180504.bean.ListBean;

/**
 * 商品列表view层接口
 */

public interface ListViewListener {
    public void success(ListBean searchBean); //请求成功数据
    public void failure(Exception e);           //请求数据失败

}
