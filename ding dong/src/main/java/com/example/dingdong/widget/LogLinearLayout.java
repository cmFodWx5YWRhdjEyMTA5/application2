package com.example.dingdong.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by CCX on 2017/7/18.
 */
public class LogLinearLayout extends LinearLayout{
    public LogLinearLayout(Context context) {
        this(context,null);
    }

    public LogLinearLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public LogLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
