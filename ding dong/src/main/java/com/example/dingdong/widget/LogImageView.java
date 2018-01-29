package com.example.dingdong.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Image log
 * Created by CCX on 2017/7/18.
 */
public class LogImageView extends ImageView{
    public LogImageView(Context context) {
        this(context,null);
    }

    public LogImageView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public LogImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
