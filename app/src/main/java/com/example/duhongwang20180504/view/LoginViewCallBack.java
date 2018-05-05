package com.example.duhongwang20180504.view;

import com.example.duhongwang20180504.bean.LoginBean;

/**
 * 登录view层接口
 */
public interface LoginViewCallBack {
    public void success(LoginBean loginBean);
    public void failure();
}
