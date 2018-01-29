package com.example.dingdong.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.dingdong.R;
import com.example.dingdong.unit.ViewUtils;

/**
 * 商品添加减少的自定义布局
 * Created by CCX on 2017/8/1.
 */
public class ErpGoodsAddSubtractView extends LinearLayout {
    private LogImageView addIv;

    public ErpGoodsAddSubtractView(Context context) {
        this(context,null);
    }

    public ErpGoodsAddSubtractView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ErpGoodsAddSubtractView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(HORIZONTAL);
        initView();
    }

    private void initView(){
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(ViewUtils.dip2px(getResources().getDimension(R.dimen.dp_80)), ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setLayoutParams(params);
    }

    private void initAddView(){
        addIv=new LogImageView(getContext());
    }
}
