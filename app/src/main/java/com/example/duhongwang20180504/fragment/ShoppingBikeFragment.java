package com.example.duhongwang20180504.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.duhongwang20180504.R;
import butterknife.ButterKnife;

/**
 * 购物车页面
 */
public class ShoppingBikeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //设置布局
        View view = inflater.inflate(R.layout.shop_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
