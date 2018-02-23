package com.example.dingdong.base;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dingdong.R;
import com.example.dingdong.io.DRetrofitBuild;

/**
 * 基类activity
 * Created by CCX on 2017/4/23.
 */
public abstract class BaseActivity extends Activity {
    protected DRetrofitBuild dRetrofitBuild;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        initPublicMeans();
        initView();
        initEvent();
        initData();
//        BarColor.setStatusBarColor(this,getResources().getColor(R.color.white));
    }

    public abstract int initLayout();
    public abstract  void initView();
    public abstract void initData();
    public abstract void initEvent();


    private void initPublicMeans(){
        dRetrofitBuild=DRetrofitBuild.getInstance();
    }
    /**
     * 设置标题栏左边的字体
     *
     * @param leftText
     */
    public void setLeftText(String leftText, View.OnClickListener onClickListener) {
        findViewById(R.id.left_text_tv).setVisibility(View.VISIBLE);
        if (leftText != null) {
            ((TextView) findViewById(R.id.left_text_tv)).setText(leftText);
        }
        if (onClickListener != null) {
            findViewById(R.id.left_text_tv).setOnClickListener(onClickListener);
        }
    }

    /**
     * 设置标题栏左边的字体
     *
     * @param resId
     * @param onClickListener
     */
    public void setLeftImageRes(int resId, View.OnClickListener onClickListener) {
        findViewById(R.id.left_iv).setVisibility(View.VISIBLE);
        ((ImageView) findViewById(R.id.left_iv)).setImageResource(resId);
        if (onClickListener != null) {
            ((ViewGroup) findViewById(R.id.left_iv).getParent()).setOnClickListener(onClickListener);
        }
    }

    /**
     * 设置左边为默认的图片（向左的箭头，以及返回事件）
     *
     * @author telenewbie
     */
    public void setLeftDefault() {
        setLeftImageRes(R.drawable.title_back_select, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    /**
     * 设置标题栏左边的字体
     *
     * @param rightText
     */
    public TextView setRightText(String rightText, View.OnClickListener onClickListener) {
        TextView textView = (TextView) findViewById(R.id.right_text_tv);
        textView.setVisibility(View.VISIBLE);
        textView.setText(rightText);
        if (onClickListener != null) {
            textView.setOnClickListener(onClickListener);
        }
        return textView;
    }

    /**
     * 暂存功能
     *
     * @param onClickListener
     */
    public void setRightStaging(View.OnClickListener onClickListener) {
        findViewById(R.id.right_staging_tv).setVisibility(View.VISIBLE);
        if (onClickListener != null) {
            findViewById(R.id.right_staging_tv).setOnClickListener(onClickListener);
        }
    }

    public void setRightText(int rightTextRes, View.OnClickListener onClickListener) {
        setRightText(getResources().getString(rightTextRes), onClickListener);
    }

    /**
     * 设置右边的文字
     *
     * @param text
     */
    public void setRightText(String text) {
        ((TextView) findViewById(R.id.right_text_tv)).setText("");
        ((TextView) findViewById(R.id.right_text_tv)).setText(text);
    }
    public void setRightVisibility(boolean isGone) {
        if (isGone)
            findViewById(R.id.right_text_tv).setVisibility(View.GONE);
        else
            findViewById(R.id.right_text_tv).setVisibility(View.VISIBLE);
    }
    /**
     * 显示标题
     */
    public void setText(String value) {
        ((TextView) findViewById(R.id.title_tv)).setFilters(new InputFilter[]{new InputFilter.LengthFilter(12)});
        ((TextView) findViewById(R.id.title_tv)).setText(value);
    }



}
