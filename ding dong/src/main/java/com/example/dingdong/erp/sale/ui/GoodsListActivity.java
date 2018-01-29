package com.example.dingdong.erp.sale.ui;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dingdong.base.BaseActivity;
import com.example.dingdong.R;
import com.example.dingdong.bean.ErpGoodsListBean;
import com.example.dingdong.erp.sale.adapter.ErpGoodsListAdapter;
import com.example.dingdong.widget.RecyclerPushView;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品列表界面
 * Created by CCX on 2017/7/11.
 */
public class GoodsListActivity extends BaseActivity{
    private RecyclerPushView recyclerPushView;
    private RecyclerView.LayoutManager layoutManager;
    private ErpGoodsListAdapter listAdapter;
    @Override
    public int initLayout() {
        return R.layout.erp_goods_list_layot;
    }

    @Override
    public void initView() {
        recyclerPushView=(RecyclerPushView)findViewById(R.id.erp_goods_list_rv);
        layoutManager=new LinearLayoutManager(getBaseContext());
        recyclerPushView.setRecyclerLayoutManager(layoutManager);
    }

    @Override
    public void initData() {
        setText(getString(R.string.store_name));
        recyclerPushView.onRefresh();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                recyclerPushView.onRefreshCompleted();
                loadGoodsListForNet();
            }
        },1000);
    }

    @Override
    public void initEvent() {
        listAdapter =new ErpGoodsListAdapter();
        recyclerPushView.setRecycleAdapter(listAdapter);
        setLeftDefault();
        recyclerPushView.setPushRecyclerBacker(new RecyclerPushView.PushRecyclerBacker() {
            @Override
            public void dropDownAction() {

            }

            @Override
            public void pullAction() {

            }
        });
    }

    private void loadGoodsListForNet(){
        List<ErpGoodsListBean> goodsList=new ArrayList<>();
        goodsList.add(new ErpGoodsListBean(10001,"德国进口奶粉"));
        goodsList.add(new ErpGoodsListBean(10002,"澳大利亚进口奶粉"));
        goodsList.add(new ErpGoodsListBean(10002,"新西兰进口奶粉"));
        goodsList.add(new ErpGoodsListBean(10003,"法国进口奶粉"));
        goodsList.add(new ErpGoodsListBean(10004,"澳洲进口奶粉"));
        goodsList.add(new ErpGoodsListBean(10005,"澳大利亚进口奶粉"));
        goodsList.add(new ErpGoodsListBean(10006,"新西兰进口奶粉"));
        goodsList.add(new ErpGoodsListBean(10007,"法国进口奶粉"));
        goodsList.add(new ErpGoodsListBean(10008,"德国进口奶粉"));
        goodsList.add(new ErpGoodsListBean(10009,"澳大利亚进口奶粉"));
        goodsList.add(new ErpGoodsListBean(10010,"新西兰进口奶粉"));
        goodsList.add(new ErpGoodsListBean(10011,"法国进口奶粉"));
        listAdapter.setListData(goodsList);

    }
}
