package com.example.duhongwang20180504.model;
import com.example.duhongwang20180504.bean.ListBean;
import com.example.duhongwang20180504.retrofit.GetDataInterface;
import java.util.HashMap;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *  商品列表model层实现类
 */
public class ListModel {
    //获取数据方法
    public void getEditData(String edit, final ListModelCallBack callBack){
        //使用Retrofit结合RxJava，okhttp封装类的单例模式,集合传参
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.zhaoapi.cn")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GetDataInterface request = retrofit.create(GetDataInterface.class);
        final Map<String,String> map = new HashMap<>();
        map.put("source","android");
        map.put("keywords","手机");
        map.put("page","1");
        request.getEdit(map).enqueue(new Callback<ListBean>() {
            @Override
            public void onResponse(Call<ListBean> call, Response<ListBean> response) {
                ListBean searchBean = response.body();
                callBack.success(searchBean);
                System.out.println("搜索model搜索数据："+searchBean.toString()+map.toString());
            }

            @Override
            public void onFailure(Call<ListBean> call, Throwable t) {
                callBack.failure(new Exception(""));
            }
        });
    }
}
