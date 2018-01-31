package com.example.dingdong.widget;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.example.dingdong.R;
import com.example.dingdong.widget.Adapter.BaseListAdapter;

/**
 * RecyclerView 的push
 * Created by CCX on 2017/6/4.
 */
public class RecyclerPushView extends FrameLayout implements SwipeRefreshLayout.OnRefreshListener{
    private Context context;
    private final int DROPDOEN_STATE=1;//下拉状态
    private final int PULL_STATE=2;//上拉状态
    private final int IDLE_STATE=0;//闲置状态
    private int RECYCLER_STATE=0;//刷新状态
    public SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private PushRecyclerBacker pushRecyclerBacker;
    private RecyclerView.LayoutManager layoutManager;
    private BaseListAdapter baseListAdapter;

    private boolean mPullRefreshEnabled = true;
    public RecyclerPushView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public RecyclerPushView(Context context) {
        this(context,null);
    }

    public RecyclerPushView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        initView();
    }
    public void initView(){
        View view=View.inflate(getContext(), R.layout.push_recycler_view_layout,null);
        swipeRefreshLayout=(SwipeRefreshLayout)view.findViewById(R.id.pull_recycler_swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(this);
        recyclerView=(RecyclerView)view.findViewById(R.id.pull_recycler_layout);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(dy>0&&RECYCLER_STATE==IDLE_STATE&&layoutManager!=null){
                    int visiblePosition=0;
                    if(layoutManager instanceof LinearLayoutManager){
                        visiblePosition=  ((LinearLayoutManager)layoutManager).findLastVisibleItemPosition();
                    }else if(layoutManager instanceof GridLayoutManager){
                        visiblePosition=  ((GridLayoutManager)layoutManager).findLastVisibleItemPosition();
                    }else if(layoutManager instanceof StaggeredGridLayoutManager){
                        int[] into=null;
                        into=  ((StaggeredGridLayoutManager)layoutManager).findLastVisibleItemPositions(into);
                        visiblePosition=into[0];
                    }
                    if(RECYCLER_STATE == IDLE_STATE &&layoutManager.getItemCount()-visiblePosition<2){
                        RECYCLER_STATE=PULL_STATE;
                        swipeRefreshLayout.setEnabled(false);
                        baseListAdapter.ShowLoadMoreView(true);
                        //更多刷新
                        if(pushRecyclerBacker!=null){
                            pushRecyclerBacker.pullAction();
                        }
                    }
                }
            }
        });
        addView(view);
    }

    /**
     * 设置 LayoutManager
     * @param layoutManager
     */
    public void setRecyclerLayoutManager(RecyclerView.LayoutManager layoutManager){
        this.layoutManager=layoutManager;
        recyclerView.setLayoutManager(this.layoutManager);
    }

    /**
     * 设置 BaseListAdapter
     * @param baseListAdapter
     */
    public void setRecycleAdapter(BaseListAdapter baseListAdapter){
        this.baseListAdapter=baseListAdapter;
        recyclerView.setAdapter(this.baseListAdapter);

    }

    public void setPushRecyclerBacker(PushRecyclerBacker pushRecyclerBacker){
        this.pushRecyclerBacker=pushRecyclerBacker;
    }


    @Override
    public void onRefresh() {
        if(RECYCLER_STATE==IDLE_STATE&&pushRecyclerBacker!=null){
            swipeRefreshLayout.setRefreshing(true);
            RECYCLER_STATE=DROPDOEN_STATE;
            pushRecyclerBacker.dropDownAction();
        }
    }

    public interface PushRecyclerBacker{
        void dropDownAction();
        void pullAction();
    }

    public void onRefreshCompleted() {
        if (RECYCLER_STATE == DROPDOEN_STATE|| RECYCLER_STATE == IDLE_STATE) {
            swipeRefreshLayout.setRefreshing(false);
        } else if (RECYCLER_STATE == PULL_STATE) {
            baseListAdapter.ShowLoadMoreView(false);
            swipeRefreshLayout.setEnabled(!mPullRefreshEnabled ? false : true);
        }
        RECYCLER_STATE = IDLE_STATE;
    }
    public RecyclerView getRecyclerView(){
        return recyclerView;
    }

    public void addItemDecoration(){
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(context, DividerItemDecoration.VERTICAL_LIST);
        recyclerView.addItemDecoration(itemDecoration);
    }

    public void enableLoadMore(){

    }

    /**
     * 是否可以下拉
     * @param enable
     */
    public void enablePullToRefresh(boolean enable){
        mPullRefreshEnabled = enable;
        swipeRefreshLayout.setEnabled(enable);
    }

}
