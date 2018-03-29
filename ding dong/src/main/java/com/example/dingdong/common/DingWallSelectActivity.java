package com.example.dingdong.common;

import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.dingdong.R;
import com.example.dingdong.base.BaseListActivity;
import com.example.dingdong.widget.BaseViewHolder;
import com.example.dingdong.widget.LogImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther CCX
 * @date 2018/3/29
 * 照片墙
 */

public class DingWallSelectActivity extends BaseListActivity<String>{
    private final Uri resolverUrl= MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    private String[] selectElement=new String[]{MediaStore.Images.Media._ID,MediaStore.Images.Media.DATA};
    private List<String> imageUrlList=new ArrayList<>();
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg!=null&&msg.obj!=null){
                imageUrlList.addAll((List<String>) msg.obj);
                mListData.addAll(imageUrlList);
                notifyDataSetChanged();
            }
        }
    };

    @Override
    public BaseViewHolder onShowCreateItemView(ViewGroup parent) {
        View view=View.inflate(getBaseContext(),R.layout.d_wall_item_layout,null);
        WallItemViewHolder wallItemViewHolder=new WallItemViewHolder(view);
        return wallItemViewHolder;
    }

    @Override
    public void otherDropDownAction() {
        getAllPictureForCorsor();
    }

    @Override
    public void otherPullAction() {

    }

    @Override
    public RecyclerView.LayoutManager getLayoutManager() {
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getBaseContext(),4);
        return gridLayoutManager;
    }

    private void getAllPictureForCorsor(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<String> nImageUrlList=new ArrayList<String>();
                Cursor cursor= getBaseContext().getContentResolver().query(resolverUrl,selectElement,null,null,MediaStore.Images.Media.DATE_MODIFIED+" desc");
                while (cursor.moveToNext()){
                    cursor.getInt(cursor.getColumnIndex(selectElement[0]));
                    String imageUrl=cursor.getString(cursor.getColumnIndex(selectElement[1]));
                    nImageUrlList.add(imageUrl);
                }
                Message message=new Message();
                message.obj=nImageUrlList;
                handler.sendMessage(message);
                cursor.close();
            }
        }).start();
    }

    /**
     * 每一项的显示
     */
    class WallItemViewHolder extends BaseViewHolder{
        private LogImageView wIView;
        public WallItemViewHolder(View itemView) {
            super(itemView);
            wIView=(LogImageView)itemView.findViewById(R.id.d_wall_item_iv);
        }

        @Override
        protected void onItemClick(View view, int adapterPosition) {

        }

        @Override
        public void onBindViewHolder(int position) {
            String url=mListData.get(position);
            Glide.with(getBaseContext()).load(url).into(wIView);
        }
    }

}
