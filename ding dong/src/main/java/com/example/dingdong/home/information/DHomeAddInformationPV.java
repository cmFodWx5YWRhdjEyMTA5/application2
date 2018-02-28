package com.example.dingdong.home.information;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.example.dingdong.R;
import com.example.dingdong.unit.ViewUtils;
import com.example.dingdong.widget.LogImageView;

/**
 * Created by CCX on 2018/2/25.
 * 首页新增资讯popupwindow 帮助类
 */
public class DHomeAddInformationPV {
    private View  parentView;
    //可以选择类型
    public enum AddInformationType{
        CHARACTER("文字",R.mipmap.dd_home_add_charcter), PHOTO_ALBUM("相册",R.mipmap.dd_home_add_photo_album),PHOTO("照相",R.mipmap.dd_home_add_photo);
        private  String typeName;
        private int imageRId;
        AddInformationType(String type,int imageRId){
            this.typeName=type;
            this.imageRId=imageRId;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public int getImageRId() {
            return imageRId;
        }

        public void setImageRId(int imageRId) {
            this.imageRId = imageRId;
        }
    }
    private Context context;

   public DHomeAddInformationPV(Context context,View parentView){
       this.context=context;
       this.parentView=parentView;
       initPopupWindow();
    }

    /**
     * 设置pop 高度、宽度
     */
    private void initPopupWindow(){
        PopupWindow popupWindow=new PopupWindow(context);
        ColorDrawable colorDrawable=new ColorDrawable(context.getResources().getColor(R.color.line_color));
        popupWindow.setBackgroundDrawable(colorDrawable);
        popupWindow.setFocusable(true);//点击外能消失
        popupWindow.setWidth(ViewUtils.dip2px(60));
        popupWindow.setHeight(ViewUtils.dip2px(132));
        popupWindow.setContentView(getPopRView());
//
        int[] locationXY= handPopLocation();
        popupWindow.showAsDropDown(parentView,ViewUtils.dip2px(locationXY[0]),0);
//        popupWindow.showAtLocation(parentView, Gravity.TOP|Gravity.LEFT,ViewUtils.dip2px(locationXY[0]),-ViewUtils.dip2px(locationXY[1]));
    }

    private int[] handPopLocation(){
        int pHeight=parentView.getMeasuredHeight();
        int widthPix=context.getResources().getDisplayMetrics().widthPixels;
        int startX=widthPix-ViewUtils.dip2px(60)-ViewUtils.dip2px(10);
        int[] locationXY=new int[2];
        locationXY[0]=startX;
        locationXY[1]=pHeight;
        return locationXY;
    }

    /**
     * 获取状态栏高度
     * @return 状态栏高度
     */
    private int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    private RecyclerView getPopRView(){
        RecyclerView recyclerView =new RecyclerView(context);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new PopViewAdapter());
        return recyclerView;
    }

   class PopViewAdapter extends RecyclerView.Adapter{

       @Override
       public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
           View view=View.inflate(parent.getContext(), R.layout.dd_add_information_type_item,null);
           return new PopHolderView(view);
       }

       @Override
       public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
           PopHolderView p= (PopHolderView) holder;
           RelativeLayout.LayoutParams param= (RelativeLayout.LayoutParams) p.imageIv.getLayoutParams();
           param.addRule(RelativeLayout.CENTER_HORIZONTAL);
           p.imageIv.setLayoutParams(param);
           p.imageIv.setImageResource(AddInformationType.values()[position].getImageRId());
       }

       @Override
       public int getItemCount() {
           return  3;
       }
   }
    class PopHolderView extends RecyclerView.ViewHolder{
        public RelativeLayout imageLayout;
        public LogImageView imageIv;
        public PopHolderView(View itemView) {
            super(itemView);
            imageLayout=(RelativeLayout)itemView.findViewById(R.id.add_information_type_layout);
            imageIv=(LogImageView)itemView.findViewById(R.id.add_information_type_iv);
        }
    }

}
