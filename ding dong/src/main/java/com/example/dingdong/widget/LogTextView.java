package com.example.dingdong.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * TextView log
 * Created by CCX on 2017/7/18.
 */
public class LogTextView extends TextView {
    public LogTextView(Context context) {
        this(context,null);
    }

    public LogTextView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public LogTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
