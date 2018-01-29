package com.example.dingdong.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

/**
 * 没有滑动的ListView
 * Created by CCX on 2017/9/6.
 */
public class LogNoMoveListView extends ListView {
    public LogNoMoveListView(Context context) {
        super(context);
    }

    public LogNoMoveListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LogNoMoveListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    /**
     * 重写该方法，达到使ListView适应ScrollView的效果
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_MOVE)
            return true;
        return super.onTouchEvent(event);
    }
}
