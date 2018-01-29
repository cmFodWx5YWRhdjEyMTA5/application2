package com.example.dingdong.widget.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.dingdong.widget.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CCX on 2017/6/12.
 */
public abstract class BaseListAdapter<T> extends RecyclerView.Adapter<BaseViewHolder>{
    private int view_type_hold=1;
    private int view_type_foot=2;
    private int view_type_item=0;
    private boolean hasHeadView;
    private boolean hasMoreView;
    public List<T> mListData=new ArrayList<>();
    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==view_type_item){
            return onCreateItemView(parent);
        }else{
            return null;
        }

    }

    public void setListData(List<T> listData){
        this.mListData.addAll(listData);
        notifyDataSetChanged();
    }
    public abstract BaseViewHolder onCreateItemView(ViewGroup parent);

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if(!hasMoreView&&!hasHeadView){
            holder.onBindViewHolder(position);
        }
    }

    @Override
    public int getItemCount() {
        return mListData.size()+(hasMoreView?1:0)+(hasHeadView?1:0);
    }

    public void setNewDown(boolean downLoad){
        this.hasHeadView=downLoad;
    }
    public void setLoadMore(boolean pullMore){
        this.hasMoreView=pullMore;
        if(hasMoreView){
            notifyItemInserted(getItemCount());
        }
    }

    @Override
    public int getItemViewType(int position) {
       if(hasHeadView&&position==0){
           return view_type_hold;
       }else if(hasMoreView&&position==getItemCount()-1){
           return view_type_foot;
       }else {
           return view_type_item;
       }
    }
    public void ShowLoadMoreView(boolean isShow) {
        hasMoreView = isShow;
        if (isShow) {
            notifyItemInserted(getItemCount());
        } else {
            notifyItemRemoved(getItemCount());
        }
    }
}

