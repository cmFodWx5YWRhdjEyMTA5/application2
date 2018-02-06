package com.example.dingdong.widget.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.dingdong.unit.ViewUtils;
import com.example.dingdong.widget.BaseViewHolder;
import com.example.dingdong.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CCX on 2018/2/4.
 */
public class FrescoAdapter extends RecyclerView.Adapter<FrescoAdapter.FrescoViewHolder>{
    private Context context;
    private List<String> urls=new ArrayList<>();
    private   RecyclerView mRecyclerView;


    public FrescoAdapter(Context context){
        this.context=context;
    }

    public void setValue(List<String> mValues,  RecyclerView mRecyclerView){
        urls.clear();
        urls.addAll(mValues);
        this.mRecyclerView=mRecyclerView;
        this.notifyDataSetChanged();
    }
    public class FrescoViewHolder extends RecyclerView.ViewHolder{
        public  SimpleDraweeView mImageView;
        public FrescoViewHolder(View itemView) {
            super(itemView);
            mImageView=(SimpleDraweeView)itemView.findViewById(R.id.item_image_view);
        }
    }




    @Override
    public FrescoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =View.inflate(context,R.layout.fresco_item_view,null);
        return new FrescoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FrescoViewHolder holder, int position) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)holder.mImageView.getLayoutParams();
        if (mRecyclerView.getLayoutManager() instanceof GridLayoutManager) {
            layoutParams.height = ViewUtils.dip2px(150);
        } else if (mRecyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
            layoutParams.height =  ViewUtils.dip2px(200);
        } else if (mRecyclerView.getLayoutManager() instanceof LinearLayoutManager){
            layoutParams.height = ViewUtils.dip2px(300);
            layoutParams.width = ViewUtils.dip2px(250);
        }
        Uri uri = Uri.parse(urls.get(position));
        holder.mImageView.setImageURI(uri);
        holder.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                    Intent intent = new Intent(mActivity, ViewPagerActivity.class);
//                    intent.putExtra("position", position);
//                    mActivity.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return urls.size();
    }


}
