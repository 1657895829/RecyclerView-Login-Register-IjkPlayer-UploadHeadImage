package com.example.duhongwang20180504.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.duhongwang20180504.R;

//分类fragment
public class FenClassFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //设置布局
        View view = View.inflate(getActivity(), R.layout.fenlei_fragment, null);
        return view;
    }


}
