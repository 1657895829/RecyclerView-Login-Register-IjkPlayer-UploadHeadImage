package com.example.duhongwang20180504.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.duhongwang20180504.R;
import com.example.duhongwang20180504.activity.ListActivity;

//首页fragment
public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //点击首页跳转至 商品展示列表
        Toast.makeText(getActivity(),"跳转",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), ListActivity.class);
        startActivity(intent);
    }
}
