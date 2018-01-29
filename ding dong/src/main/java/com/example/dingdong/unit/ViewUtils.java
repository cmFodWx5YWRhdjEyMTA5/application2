package com.example.dingdong.unit;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Html;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RatingBar;
import android.widget.TextView;
import com.example.dingdong.R;
import com.example.dingdong.widget.LogTextView;
import java.util.concurrent.atomic.AtomicInteger;
public class ViewUtils {

    public static final int VIEW_TYPE_ARROW = 0;

    public static final int VIEW_TYPE_START = 1;

    public static final int VIEW_TYPE_END = 2;

    public static TextView getSurveyIndexText(Context context) {
        TextView textview = new TextView(context);
        textview.setTextColor(context.getResources().getColor(R.color.black));
        return textview;
    }

    public static LinearLayout getLinearLayoutOrientationVertical(Context context) {
        LinearLayout mLinearLayout = new LinearLayout(context);
        mLinearLayout.setOrientation(LinearLayout.VERTICAL);
        mLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT));

        // mLinearLayout.setPadding(5, 10, 5, 10);
        return mLinearLayout;
    }

    public static LinearLayout getLinearLayoutOrientationHorizontal(Context context) {
        LinearLayout mLinearLayout = new LinearLayout(context);
        mLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
        mLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT));
        // mLinearLayout.setPadding(5, 10, 5, 10);
        return mLinearLayout;
    }


    /**
     * 创建一个布局文件
     *
     * @param iOrientation
     * @param context
     * @return hwl 2012-11-16 上午7:37:06
     */
    public static LinearLayout createLayout(int iOrientation, Context context) {
        LinearLayout lay = new LinearLayout(context);
        lay.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT));
        lay.setOrientation(iOrientation);
        return lay;
    }

    /**
     * @param sentBtn
     * @desc <pre>
     * 按钮为可发送状态
     * </pre>
     * @author Weiliang Hu
     * @date 2013-9-18
     */
    public static void setBtnEnableSent(View sentBtn) {
        sentBtn.setSelected(true);
        sentBtn.setEnabled(true);
        sentBtn.getBackground().setAlpha(255);
    }

    /**
     * @param sentBtn
     * @desc <pre>
     * 按钮为不可发送状态
     * </pre>
     * @author Weiliang Hu
     * @date 2013-9-18
     */
    public static void setBtnUnEnableSent(View sentBtn) {
        sentBtn.setSelected(false);
        sentBtn.setEnabled(false);
        sentBtn.getBackground().setAlpha(180);
    }


    public static void setViewAlpha(View view, int alpha) {
        view.getBackground().setAlpha(alpha);
    }

    public static void stopAnimation(View view) {
        AnimationDrawable anim = (AnimationDrawable) view.getBackground();
        if (anim.isRunning()) { // 如果正在运行,就停止
            anim.stop();
        }
    }


    public static TextView getFlowtv(Context mContext) {
        TextView mFlowTv = new TextView(mContext);
        mFlowTv.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        mFlowTv.setTextColor(mContext.getResources().getColor(R.color.white));
        mFlowTv.setTextSize(mContext.getResources().getDimension(R.dimen.sp_10));
        return mFlowTv;
    }


    public static Bitmap convertViewToBitmap(View view, int width) {
        view.measure(MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED),
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
        view.layout(0, 0, width, view.getMeasuredHeight()); // 根据字符串的长度显示view的宽度
        view.buildDrawingCache();
        Bitmap bitmap = view.getDrawingCache();
        return bitmap;
    }


    // 根据语音的长度获取布局的宽度
    public static int getVoiceMinWidth(int mVoiceLen, int maxLen, int denisty) {
        if (mVoiceLen < 20) {
            return 80 * denisty + mVoiceLen * 3;
        }
        return maxLen;
    }

    public static void dissmissPopWindow(PopupWindow pop) {
        if (pop != null) {
            if (pop.isShowing()) {
                pop.dismiss();
            }
        }
    }

    public static void setLayoutAlpha(Activity activity, float alpha) {
        if (null == activity) {
            return;
        }
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        lp.alpha = alpha; // 0.0-1.0
        activity.getWindow().setAttributes(lp);
    }




    /**
     * 添加时间的图标
     *
     * @param parent    容器类
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return
     */
    public static LinearLayout addTwoTextHeader(ViewGroup parent, String startDate, String endDate) {
        LinearLayout layout = createLayout(LinearLayout.HORIZONTAL, parent.getContext());
        setTextViewConfig(LayoutParams.WRAP_CONTENT, layout, 0, startDate);
        if (StringUtils.isNotBlank(endDate)) {
            setTextViewConfig(LayoutParams.WRAP_CONTENT, layout, 0, endDate);
        }
        parent.addView(layout);
        return layout;
    }


    private static TextView setTextViewConfig(int width, ViewGroup parent, int imgresid, String value) {
        TextView textView = new LogTextView(parent.getContext());
        LayoutParams layoutParams = new LayoutParams(width, LayoutParams.WRAP_CONTENT);
        textView.setLayoutParams(layoutParams);
        textView.setPadding(5, 5, 5, 5);
        if (imgresid != 0) {
            Drawable drawable = parent.getContext().getResources().getDrawable(imgresid);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight()); //设置边界
            textView.setCompoundDrawables(drawable, null, null, null);
            textView.setCompoundDrawablePadding(5);
        }
        textView.setText(Html.fromHtml(value));
        parent.addView(textView);
        return textView;
    }


    /**
     * 添加评分的图标
     *
     * @param parent 容器类
     * @return
     */
    public static LinearLayout addScore(ViewGroup parent, Float score) {
        LinearLayout layout = createLayout(LinearLayout.HORIZONTAL, parent.getContext());
        RatingBar ratingBar = new RatingBar(parent.getContext());
        ratingBar.setMax(10);
        ratingBar.setNumStars(5);
        ratingBar.setStepSize(0.1F);
        ratingBar.setRating(score);
        layout.addView(ratingBar);
        setTextViewConfig(LinearLayout.LayoutParams.WRAP_CONTENT, layout, 0, String.valueOf(score));
        parent.addView(layout);
        return layout;
    }

    private static TextView setTextViewConfig(ViewGroup parent, int imgresid, String value) {
        return setTextViewConfig(LayoutParams.MATCH_PARENT, parent, imgresid, value);
    }

    public static void addTips(ViewGroup parent, String tip, String note) {
        TextView textView1 = setTextViewConfig(parent, 0, tip);
        textView1.setPadding(parent.getContext().getResources().getDimensionPixelOffset(R.dimen.activity_horizontal_margin), 16, 16, 10);
        textView1.setTextColor(parent.getResources().getColor(R.color.text_black_color));
        textView1.setTextSize(14);
        textView1.setBackgroundColor(Color.WHITE);
        TextView textView = setTextViewConfig(parent, 0, note);
        textView.setLineSpacing(0,1.2f);
        textView.setPadding(parent.getContext().getResources().getDimensionPixelOffset(R.dimen.activity_horizontal_margin), 0, 16, 16);
        textView.setTextSize(14);
        textView.setBackgroundColor(Color.WHITE);
        ImageView imageView = new ImageView(parent.getContext());
        imageView.setBackgroundColor(parent.getResources().getColor(R.color.line_color));
        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, 1);
        imageView.setLayoutParams(layoutParams);
        parent.addView(imageView);
    }
    public static void addTips(ViewGroup parent, String note) {
        TextView textView = setTextViewConfig(parent, 0, note);
        int dimensionPixelOffset = parent.getContext().getResources().getDimensionPixelOffset(R.dimen.activity_horizontal_margin);
        textView.setPadding(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
        textView.setTextSize(14);
        textView.setBackgroundColor(Color.WHITE);
        ImageView imageView = new ImageView(parent.getContext());
        imageView.setBackgroundColor(parent.getResources().getColor(R.color.line_color));
        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, 1);
        imageView.setLayoutParams(layoutParams);
        parent.addView(imageView);
    }

    /**
     * @param score
     * @return
     * @desc <pre>
     * 判断日志的分数等级
     * </pre>
     * @author Weiliang Hu
     * @date 2013-9-18
     */
    public static int getScoreLeave(float score) {
        float sex = 6.0f;
        float seven = 7.0f;
        float eight = 8.0f;
        float nine = 9.0f;
        float ten = 10.0f;
        int leave = 0;
        if (0 <= score && score < sex) {
            leave = 0;
        } else if (sex <= score && score < seven) {
            leave = 1;
        } else if (seven <= score && score < eight) {
            leave = 2;
        } else if (eight <= score && score < nine) {
            leave = 3;
        } else if (nine <= score && score < ten) {
            leave = 4;
        }
        else if (ten <= score) {
            leave = 5;
        }
        return leave;
    }

    /**
     * 将dip 转成 px
     * @param context
     * @param dpValue
     * @return
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
    public static int dip2px(float _Dp) {
        final float scale = Resources.getSystem().getDisplayMetrics().density;
        return (int) (_Dp * scale + 0.5f);
    }
    public static int px2dip(float _Dp) {
        final float scale = Resources.getSystem().getDisplayMetrics().density;
        return (int) (_Dp / scale + 0.5f);
    }


    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);
    /**
     * 动态生成View ID
     * API LEVEL 17 以上View.generateViewId()生成
     * API LEVEL 17 以下需要手动生成
     */
    public static int generateViewId() {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
            for (; ; ) {
                final int result = sNextGeneratedId.get();
                // aapt-generated IDs have the high byte nonzero; clamp to the range under that.
                int newValue = result + 1;
                if (newValue > 0x00FFFFFF) newValue = 1; // Roll over to 1, not 0.
                if (sNextGeneratedId.compareAndSet(result, newValue)) {
                    return result;
                }
            }
        } else {
            return View.generateViewId();
        }
    }

    /**
     * 获取一个view的父元素
     * @param view
     * @return
     */
    public static View getViewParent(View view) {
        return view != null && view.getParent() != null? (View)view.getParent() : view ;
    }
}
