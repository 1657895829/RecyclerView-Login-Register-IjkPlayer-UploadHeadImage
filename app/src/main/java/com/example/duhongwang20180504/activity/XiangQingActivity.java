package com.example.duhongwang20180504.activity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;
import com.example.duhongwang20180504.R;
import com.example.duhongwang20180504.adapter.XiangQingAdapter;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//详情页面:商品详情页面展示数据和播放视频，点击立即购买，提升下单成功
public class XiangQingActivity extends AppCompatActivity {
    @BindView(R.id.custom_xq_viewpager)
    ViewPager mCustomXqViewpager;
    @BindView(R.id.custom_xq_title)
    TextView customXqTitle;
    @BindView(R.id.custom_xq_bargin_price)
    TextView customXqBarginPrice;
    @BindView(R.id.custom_xq_price)
    TextView customXqPrice;
    @BindView(R.id.goumai)
    TextView goumai;
    private String pid;
    PlayerView play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiang_qing);
        ButterKnife.bind(this);

        //拿到传来的参数  images,pid,bargainPrice,title,price
        Intent intent = getIntent();
        pid = intent.getStringExtra("pid");
        String images = intent.getStringExtra("images");
        String bargainPrice = intent.getStringExtra("bargainPrice");
        String title = intent.getStringExtra("title");
        String price = intent.getStringExtra("price");

        //原价设置删除线
        customXqPrice.setText("¥" + price + "");
        customXqTitle.setText(title + "");
        customXqBarginPrice.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);//下划线
        customXqBarginPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); //中间横线（删除线）
        customXqBarginPrice.getPaint().setAntiAlias(true);// 抗锯齿
        customXqBarginPrice.setText("¥" + bargainPrice + "");

        //图片的集合
        List<String> listImage = new ArrayList<>();
        if (images.contains("|")) {
            //如果需要拆分
            String[] split = images.split("\\|");
            for (int i = 0; i < split.length; i++) {
                listImage.add(split[0]);
            }
        } else {
            listImage.add(images);
        }

        //设置适配器
        XiangQingAdapter viewPagerAdapter = new XiangQingAdapter(this);
        viewPagerAdapter.addData(listImage);
        mCustomXqViewpager.setAdapter(viewPagerAdapter);

        //视频播放地址
        String url ="http://ips.ifeng.com/video19.ifeng.com/video09/2014/06/16/1989823-102-086-0009.mp4";
        play = new PlayerView(this)
                .setTitle("视频")
                .setScaleType(PlayStateParams.fitparent)
                .hideMenu(true)
                .forbidTouch(false)
                .setPlaySource(url);
        play.startPlay();
    }

    @OnClick({R.id.goumai})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.goumai:
                Toast.makeText(XiangQingActivity.this,"下单成功",Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
    }

    //退出页面，即生命周期结束时，停止播放视频
    @Override
    protected void onStop() {
        super.onStop();
        play.stopPlay();
    }
}
