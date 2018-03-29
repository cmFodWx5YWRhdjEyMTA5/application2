package com.example.dingdong.home.information;

import android.view.View;

import com.example.dingdong.R;
import com.example.dingdong.base.BaseActivity;
import com.nineoldandroids.animation.ValueAnimator;

/**
 * 发起资讯
 * Created by CCX on 2018/2/28.
 */
public class CreateMessageInformationActivity extends BaseActivity{
    @Override
    public int initLayout() {
        return R.layout.dd_send_information_layout;
    }

    @Override
    public void initView() {
        setText(getResources().getString(R.string.is_send_information));
        setLeftText(getString(R.string.is_cancel), new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        setRightText(getString(R.string.is_send), new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public void initEvent() {

    }
}
