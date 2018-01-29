package com.example.dingdong.erp.sale.adapter;

import android.view.View;
import android.view.ViewGroup;


import com.bumptech.glide.Glide;
import com.example.dingdong.DingApplication;
import com.example.dingdong.R;
import com.example.dingdong.bean.ErpGoodsListBean;
import com.example.dingdong.widget.Adapter.BaseListAdapter;
import com.example.dingdong.widget.BaseViewHolder;
import com.example.dingdong.widget.LogImageView;
import com.example.dingdong.widget.LogTextView;

/**
 * 商品列表适配器
 * Created by CCX on 2017/7/11.
 */
public class ErpGoodsListAdapter extends BaseListAdapter<ErpGoodsListBean>{
    @Override
    public BaseViewHolder onCreateItemView(ViewGroup parent) {
        View view=View.inflate(parent.getContext(), R.layout.erp_goods_list_item_layout,null);
        return new ErpGoodsListHold(view);
    }

    class ErpGoodsListHold extends BaseViewHolder{

        private LogTextView GoodsDescribeTv;
        private LogImageView goodsAddIv,goodsDescribeIv;
        public ErpGoodsListHold(View itemView) {
            super(itemView);
            GoodsDescribeTv= (LogTextView) itemView.findViewById(R.id.erp_goods_describe_tv);
            goodsAddIv=(LogImageView)itemView.findViewById(R.id.erp_add_goods_iv);
            goodsDescribeIv=(LogImageView)itemView.findViewById(R.id.erp_goods_describe_image);
            Glide.with(DingApplication.getContext()).load("https://img.alicdn.com/bao/uploaded/i2/TB1RhY9RXXXXXXLaXXXXXXXXXXX_!!0-item_pic.jpg_q30.jpg").
                    centerCrop().placeholder(R.mipmap.erp_default_graph).crossFade().into(goodsDescribeIv);
            goodsAddIv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }

        @Override
        protected void onItemClick(View view, int adapterPosition) {

        }

        @Override
        public void onBindViewHolder(int position) {
            ErpGoodsListBean erpGoodsListBean= mListData.get(position);
            GoodsDescribeTv.setText(erpGoodsListBean.getGoodsName());
        }
    }

}
