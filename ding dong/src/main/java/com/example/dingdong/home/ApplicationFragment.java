package com.example.dingdong.home;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.dingdong.base.BaseFragment;
import com.example.dingdong.DingApplication;
import com.example.dingdong.R;
import com.example.dingdong.erp.sale.ui.GoodsListActivity;
import com.example.dingdong.home.bean.ApplicationModel;
import com.example.dingdong.widget.Adapter.BaseListAdapter;
import com.example.dingdong.widget.BaseViewHolder;
import com.example.dingdong.widget.LogImageView;
import com.example.dingdong.widget.LogTextView;
import com.example.dingdong.widget.RecyclerPushView;

import java.util.ArrayList;
import java.util.List;

/**
 * 应用界面
 * Created by CCX on 2017/8/21.
 */
public class ApplicationFragment extends BaseFragment{
    private RecyclerPushView recyclerPushView;
    private GridLayoutManager gridLayoutManager;
    private BaseListAdapter<ApplicationModel> baseListAdapter;
    private List<ApplicationModel> applicationModels;
    @Override
    protected int initLayout() {
        return R.layout.dd_application_fl;
    }

    @Override
    protected void initView() {
        setText(getResources().getString(R.string.application_centre));
        recyclerPushView=(RecyclerPushView)view.findViewById(R.id.application_list_rv);
        gridLayoutManager=new GridLayoutManager(getActivity(),3);
        recyclerPushView.setRecyclerLayoutManager(gridLayoutManager);

    }
    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData() {
        baseListAdapter=new BaseListAdapter<ApplicationModel>() {
            @Override
            public BaseViewHolder onCreateItemView(ViewGroup parent) {
                View view=View.inflate(parent.getContext(),R.layout.dd_application_item_layout,null);
                return new ApplicationItemView(view);
            }

            @Override
            protected int getDataCount() {
                return applicationModels.size();
            }
        };
        recyclerPushView.setRecycleAdapter(baseListAdapter);
        applicationModels=new ArrayList<>();
        ApplicationModel  aModel=new ApplicationModel();
        aModel.setId(1);
        aModel.setLogo_url("https://img.alicdn.com/bao/uploaded/i2/TB1RhY9RXXXXXXLaXXXXXXXXXXX_!!0-item_pic.jpg_q30.jpg");
        aModel.setTitle("门店售货");
        applicationModels.add(aModel);
        ApplicationModel  aModel5=new ApplicationModel();
        aModel5.setId(1);
        aModel5.setLogo_url("https://img.alicdn.com/bao/uploaded/i2/TB1RhY9RXXXXXXLaXXXXXXXXXXX_!!0-item_pic.jpg_q30.jpg");
        aModel5.setTitle("门店售货");
        applicationModels.add(aModel5);
        ApplicationModel  aModel1=new ApplicationModel();
        aModel1.setId(1);
        aModel1.setLogo_url("https://img.alicdn.com/bao/uploaded/i2/TB1RhY9RXXXXXXLaXXXXXXXXXXX_!!0-item_pic.jpg_q30.jpg");
        aModel1.setTitle("门店售货");
        applicationModels.add(aModel1);
        ApplicationModel  aModel2=new ApplicationModel();
        aModel2.setId(1);
        aModel2.setLogo_url("https://img.alicdn.com/bao/uploaded/i2/TB1RhY9RXXXXXXLaXXXXXXXXXXX_!!0-item_pic.jpg_q30.jpg");
        aModel2.setTitle("门店售货");
        applicationModels.add(aModel2);
        ApplicationModel  aModel3=new ApplicationModel();
        aModel3.setId(1);
        aModel3.setLogo_url("https://img.alicdn.com/bao/uploaded/i2/TB1RhY9RXXXXXXLaXXXXXXXXXXX_!!0-item_pic.jpg_q30.jpg");
        aModel3.setTitle("门店售货");
        applicationModels.add(aModel3);
    }

    class ApplicationItemView extends BaseViewHolder{
        LogImageView itemIv;
        LogTextView titleTv;
        public ApplicationItemView(View itemView) {
            super(itemView);
            itemIv= (LogImageView) itemView.findViewById(R.id.application_item_iv);
            titleTv=(LogTextView)itemView.findViewById(R.id.application_item_title_tv);
        }

        @Override
        protected void onItemClick(View view, int adapterPosition) {
            ApplicationModel applicationModel=applicationModels.get(adapterPosition);
            if(applicationModel!=null){
                Intent intent=new Intent();
                intent.setClass(getActivity(), GoodsListActivity.class);
                startActivity(intent);
            }
        }

        @Override
        public void onBindViewHolder(int position) {
            ApplicationModel applicationModel=  applicationModels.get(position);
            if(applicationModel!=null){
                Glide.with(DingApplication.getContext()).load(applicationModel.getLogo_url()).
                        centerCrop().placeholder(R.mipmap.erp_default_graph).crossFade().into(itemIv);
                titleTv.setText(applicationModel.getTitle());
            }
        }
    }
}
