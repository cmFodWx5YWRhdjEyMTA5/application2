package com.example.dingdong.home.information;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.example.dingdong.R;
import com.example.dingdong.widget.LogImageView;

/**
 * Created by CCX on 2018/2/25.
 * 首页新增资讯popupwindow 帮助类
 */
public class DHomeAddInformationPV {
    private View  parentView;
     public enum AddInformationType{
         CHARACTER("文字",R.mipmap.dd_home_add_charcter), PHOTO_ALBUM("相册",R.mipmap.dd_home_add_photo_album),PHOTO("照相",R.mipmap.dd_home_add_photo);
       private  String typeName;
         private int imageRId;
       private  AddInformationType(String type,int imageRId){
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
    private void initPopupWindow(){
        PopupWindow popupWindow=new PopupWindow(context);
        popupWindow.setWidth(144);
        popupWindow.setHeight(244);
        popupWindow.setContentView(getPopRecyView());
        popupWindow.showAsDropDown(parentView);
    }

    private RecyclerView getPopRecyView(){
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
//           RelativeLayout.LayoutParams layoutparam= (RelativeLayout.LayoutParams) p.imageLayout.getLayoutParams();
//           layoutparam.width=144;
//           p.imageLayout.setLayoutParams(layoutparam);
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
