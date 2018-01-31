package com.example.dingdong.base;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.dingdong.R;
import com.example.dingdong.widget.Adapter.BaseListAdapter;
import com.example.dingdong.widget.BaseViewHolder;
import com.example.dingdong.widget.RecyclerPushView;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther CCX
 * @date 2018/1/26
 */

public  abstract  class BaseListActivity<T> extends BaseActivity{
    private RecyclerPushView recyclerPushView;
    protected List<T> mListData=new ArrayList<>();
    @Override
    public int initLayout() {
        return R.layout.base_list_layout;
    }

    @Override
    public void initView() {
        recyclerPushView=(RecyclerPushView)findViewById(R.id.recycle_push_view);
        recyclerPushView.setRecyclerLayoutManager(new LinearLayoutManager(getBaseContext()));
        recyclerPushView.setPushRecyclerBacker(pushRecyclerBacker);

        recyclerPushView.setRecycleAdapter(baseListAdapter);

    }

    @Override
    public void initData() {

    }
    BaseListAdapter<T> baseListAdapter=new BaseListAdapter<T>() {
        @Override
        public BaseViewHolder onCreateItemView(ViewGroup parent) {
            return onShowCreateItemView(parent);
        }

        @Override
        protected int getDataCount() {
            return getListDataCount();
        }
    };

    /**
     * 获取数据列表统计数量
     *
     * @return
     */
    protected int getListDataCount() {
        return mListData != null ? mListData.size() : 0;
    }

    @Override
    public void initEvent() {

    }
    RecyclerPushView.PushRecyclerBacker pushRecyclerBacker=new RecyclerPushView.PushRecyclerBacker() {
        @Override
        public void dropDownAction() {
            otherDropDownAction();
        }

        @Override
        public void pullAction() {
            otherPullAction();
        }
    };

    public void  setSwipeRefreshing(){
        recyclerPushView.onRefreshCompleted();
    }

    public void notifyDataSetChanged(){
        getAdapter().notifyDataSetChanged();
    }
    public BaseListAdapter getAdapter() {
        return baseListAdapter;
    }
    public abstract BaseViewHolder onShowCreateItemView(ViewGroup parent);
    public abstract  void otherDropDownAction();
    public abstract  void otherPullAction();

}
