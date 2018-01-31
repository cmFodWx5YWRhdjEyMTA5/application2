package com.example.dingdong.widget.Adapter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;

import com.example.dingdong.R;
import com.example.dingdong.unit.ViewUtils;
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
    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (hasHeadView && viewType == view_type_hold) {
            return onCreateHeaderViewHolder(parent);
        }
        if (hasMoreView && viewType == view_type_foot) {
            return onCreateLoadMoreHeaderView(parent);
        }
        return onCreateItemView(parent);

    }

    private BaseViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
//        return new HeaderViewHolder(mHeaderView);
        return  null;
    }

    private BaseViewHolder onCreateLoadMoreHeaderView(ViewGroup parent) {
        View loadMoreView = View.inflate(parent.getContext(), R.layout.widget_item_load_more, null);
        return new LoadMoreViewHolder(loadMoreView);
    }

    class LoadMoreViewHolder extends BaseViewHolder {
        public LoadMoreViewHolder(View itemView) {
            super(itemView);
            itemView.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, ViewUtils.dip2px(itemView.getContext(),40)));
        }

        @Override
        protected void onItemClick(View view, int adapterPosition) {

        }

        @Override
        public void onBindViewHolder(int position) {

        }
    }

    public abstract BaseViewHolder onCreateItemView(ViewGroup parent);

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if((checkIsFootView(position) && hasMoreView) || (hasHeadView && checkIsHeaderView(position))){
            setStaggerdSpanSizeLoop(holder);
        }
        holder.onBindViewHolder(getPosition(position));
    }

    private void setStaggerdSpanSizeLoop(BaseViewHolder holder) {
        ViewGroup.LayoutParams params = holder.itemView.getLayoutParams();
        if(params instanceof StaggeredGridLayoutManager.LayoutParams){
            ((StaggeredGridLayoutManager.LayoutParams) params).setFullSpan(true);
        }
    }
    public int getPosition(int position){
        return position - getHasHeaderViewNum();
    }
    private int getHasHeaderViewNum() {
        return hasHeadView ? 1 : 0;
    }

    @Override
    public int getItemCount() {
        return getDataCount()+(hasMoreView?1:0)+(hasHeadView?1:0);
    }

    protected abstract int getDataCount();

    public void setNewDown(boolean downLoad){
        this.hasHeadView=downLoad;
    }
    public void setNewDownView(View downLoadView){
        this.hasHeadView=true;
    }
    public void setLoadMore(boolean pullMore){
        this.hasMoreView=pullMore;
        if(hasMoreView){
            notifyItemInserted(getItemCount());
        }
    }
    public void setLoadMoreView(View pullMoreView){
        this.hasMoreView=true;
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
    public boolean checkIsFootView(int position) {
        return hasMoreView && position == getItemCount() - 1;
    }

    public boolean checkIsHeaderView(int position) {
        return hasHeadView && position == 0;
    }
}

