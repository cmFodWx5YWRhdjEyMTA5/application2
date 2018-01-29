package com.example.dingdong.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * RelativeLayout log
 * Created by CCX on 2017/7/18.
 */
public class LogRelativeLayout extends RelativeLayout {
    public LogRelativeLayout(Context context) {
        this(context,null);
    }

    public LogRelativeLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public LogRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
