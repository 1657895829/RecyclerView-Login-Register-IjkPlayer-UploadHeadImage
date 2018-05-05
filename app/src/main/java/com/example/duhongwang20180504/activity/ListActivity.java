package com.example.duhongwang20180504.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.duhongwang20180504.R;
import com.example.duhongwang20180504.adapter.ListAdapter;
import com.example.duhongwang20180504.bean.ListBean;
import com.example.duhongwang20180504.presenter.ListPresenter;
import com.example.duhongwang20180504.view.ListViewListener;
import butterknife.BindView;
import butterknife.ButterKnife;

//商品列表页面：https://www.zhaoapi.cn/product/searchProducts?keywords=%E7%AC%94%E8%AE%B0%E6%9C%AC&page=1
public class ListActivity extends AppCompatActivity implements ListViewListener {
    @BindView(R.id.sousuo_recyview)
    RecyclerView sousuoRecyview;
    private ListPresenter presenter;
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);

        //实例化p层，获取数据
        presenter = new ListPresenter(this);
        presenter.getData("手机");

        //设置适配器以及布局管理器
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        sousuoRecyview.setLayoutManager(manager);
        adapter = new ListAdapter(ListActivity.this);
    }

    @Override
    public void success(ListBean searchBean) {
        //添加数据
        if (searchBean != null) {
            adapter.addData(searchBean.getData());
            sousuoRecyview.setAdapter(adapter);
        }
    }

    @Override
    public void failure(Exception e) {
        System.out.println("错误：" + e);
    }

   //取消绑定，防止内存泄露
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}
