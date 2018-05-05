package com.example.duhongwang20180504.presenter;


import com.example.duhongwang20180504.bean.ListBean;
import com.example.duhongwang20180504.model.ListModel;
import com.example.duhongwang20180504.model.ListModelCallBack;
import com.example.duhongwang20180504.view.ListViewListener;

//商品列表p层
public class ListPresenter {
    private ListViewListener listener;
    private ListModel searchModel;
    public ListPresenter(ListViewListener listener){
        this.listener = listener ;
        this.searchModel = new ListModel();
    }

    //搜索数据
    public void getData(String edit){

        searchModel.getEditData(edit, new ListModelCallBack() {
            @Override
            public void success(ListBean searchBean) {
                listener.success(searchBean);
                System.out.println("搜索presenter搜索数据："+searchBean.toString());
            }

            @Override
            public void failure(Exception e) {
                listener.failure(e);
            }
        });

    }

    /**
     * 防止内存泄漏
     */
    public void detach(){
        listener = null;
    }
}
