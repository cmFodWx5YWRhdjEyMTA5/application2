package com.example.dingdong.base;

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
        recyclerPushView.setPushRecyclerBacker(pushRecyclerBacker);
        recyclerPushView.setRecycleAdapter(baseListAdapter);

    }

    @Override
    public void initData() {

    }
    BaseListAdapter<T> baseListAdapter=new BaseListAdapter<T>() {
        @Override
        public BaseViewHolder onCreateItemView(ViewGroup parent) {
            return onCreateItemView(parent);
        }
    };

    @Override
    public void initEvent() {

    }
    RecyclerPushView.PushRecyclerBacker pushRecyclerBacker=new RecyclerPushView.PushRecyclerBacker() {
        @Override
        public void dropDownAction() {
            dropDownAction();
        }

        @Override
        public void pullAction() {
            pullAction();
        }
    };
    public abstract BaseViewHolder onCreateItemView(ViewGroup parent);
    public abstract  void dropDownAction();
    public abstract  void pullAction();

}
