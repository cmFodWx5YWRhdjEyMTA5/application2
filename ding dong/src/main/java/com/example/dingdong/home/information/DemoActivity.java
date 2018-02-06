package com.example.dingdong.home.information;

import android.os.Bundle;

import com.example.dingdong.R;
import com.example.dingdong.base.BaseActivity;
import com.example.dingdong.unit.ImageUrlUtils;
import com.example.dingdong.widget.FrescoView;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by CCX on 2018/2/5.
 */
public class DemoActivity extends BaseActivity{
    private FrescoView frescoView;
    @Override
    public int initLayout() {
        return R.layout.demo_layout;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Fresco.initialize(DemoActivity.this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        frescoView=(FrescoView)findViewById(R.id.fresco_demo_view);
    }

    @Override
    public void initData() {
        String[] urls=new String[3];
        urls[0]= ImageUrlUtils.getImageUrls()[1];
        urls[1]= ImageUrlUtils.getImageUrls()[2+1];
        urls[2]= ImageUrlUtils.getImageUrls()[3+2];
        frescoView.addFrescoData(urls);
    }

    @Override
    public void initEvent() {

    }
}
