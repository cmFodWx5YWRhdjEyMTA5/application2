package com.example.dingdong.home.information;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.dingdong.R;
import com.example.dingdong.base.BaseListActivity;
import com.example.dingdong.base.BaseListFragment;
import com.example.dingdong.common.ACache;
import com.example.dingdong.db.model.InformationModel;
import com.example.dingdong.db.model.NewsUserModel;
import com.example.dingdong.unit.ImageUrlUtils;
import com.example.dingdong.unit.TimeDateUtil;
import com.example.dingdong.unit.ViewUtils;
import com.example.dingdong.widget.BaseViewHolder;
import com.example.dingdong.widget.FrescoView;
import com.example.dingdong.widget.LogImageView;
import com.example.dingdong.widget.LogTextView;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import java.util.List;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @auther CCX
 * @date 2018/1/26
 * 资讯列表界面
 * 刷新时应以帖子的创建时间来获取20条信息
 */
public class DInformationFragment extends BaseListFragment<InformationModel> {

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Fresco.initialize(getActivity());
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public BaseViewHolder onShowCreateItemView(ViewGroup parent) {
        View view=View.inflate(parent.getContext(), R.layout.dd_information_item_layout,null);
        return new InformationViewHolder(view);
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        recyclerPushView.setBackgroundColor(getResources().getColor(R.color.grey1_f5f5f5));
        setText(getActivity().getResources().getString(R.string.is_information));
    }

    @Override
    public void otherDropDownAction() {
        customSomeInformationBean();
        setSwipeRefreshing();
    }

    @Override
    public void otherPullAction() {
        customSomeInformationBean();
        setSwipeRefreshing();
    }

    @Override
    protected RecyclerView.ItemDecoration addItemDecoration() {
        return null;
    }

    /**
     * 自定义数据
     */
    private void  customSomeInformationBean(){
        List<InformationModel> informationModels=new ArrayList<>();
        for(int i=0;i<20;i++){
            InformationModel informationModel=new InformationModel();
            informationModel.setAddress("湖北省潜江市张金镇");
            informationModel.setId(i+1);
            informationModel.setClassify("鱼类");
            informationModel.setSpecificGoods("小龙虾");
            informationModel.setCreateDate(1517927247);
            NewsUserModel userModel=new NewsUserModel();
            userModel.setUserId(i+1);
            userModel.setUserName("曹才西");
            userModel.setVip(true);
            userModel.setHeadPortrait("https://file.iworker.cn/inside/get_erp_img/cid:87512/id:2234365/type:0");
            informationModel.setNewsUserModel(userModel);
            informationModel.setMessage("今天收获满满的一天");
            int urlLenght=i+1;
            if(urlLenght>=9){
                urlLenght=9;
            }
            String[] urls=new String[urlLenght];
            int j=urls.length;
            for(int size=0;size<j;size++){
                urls[size]= ImageUrlUtils.getImageUrls()[size];
            }
            informationModel.setImageUrls(urls);
            informationModels.add(informationModel);

        }
        mListData.addAll(informationModels);
        notifyDataSetChanged();
    }


    /**
     * 适配view holder
     */
    class InformationViewHolder extends BaseViewHolder{
        private CircleImageView circleIv;
        private LogImageView vipIv;
        private LogTextView rightTopTv,centerTopTv,centerBottomTv,rightBottomTv;
        private LogTextView themeMessageTv;
        private FrescoView frescoView;

        public InformationViewHolder(View itemView) {
            super(itemView);
            circleIv=(CircleImageView) itemView.findViewById(R.id.mobile_fixed_left_iv);
            vipIv=(LogImageView)itemView.findViewById(R.id.cart_vip_logo_iv);
            rightTopTv=(LogTextView)itemView.findViewById(R.id.mobile_fixed_right_top_pv);
            centerTopTv=(LogTextView)itemView.findViewById(R.id.mobile_fixed_center_top_tv);
            centerBottomTv=(LogTextView)itemView.findViewById(R.id.mobile_fixed_center_bottom_tv);
            rightBottomTv=(LogTextView)itemView.findViewById(R.id.mobile_fixed_right_bottom_tv);
            themeMessageTv=(LogTextView)itemView.findViewById(R.id.information_theme_message_tv);
            frescoView=(FrescoView)itemView.findViewById(R.id.information_image_layout);
        }

        @Override
        protected void onItemClick(View view, int adapterPosition) {
        }

        @Override
        public void onBindViewHolder(int position) {
            InformationModel information=mListData.get(position);
            if(information!=null){
                NewsUserModel newsUserModel= information.getNewsUserModel();
                if(newsUserModel!=null){
                    Glide.with(getActivity()).load(newsUserModel.getHeadPortrait()).into(circleIv);
                    if(newsUserModel.isVip()){
                        vipIv.setVisibility(View.VISIBLE);
                    }else{
                        vipIv.setVisibility(View.GONE);
                    }
                    centerTopTv.setText(newsUserModel.getUserName());
                }
                centerBottomTv.setText(TimeDateUtil.date(TimeDateUtil.DEFAULT_FORMAT_M,information.getCreateDate()));
                rightTopTv.setText(information.getClassify()+"-"+information.getSpecificGoods());
                rightBottomTv.setText(information.getAddress());
                themeMessageTv.setText(information.getMessage());
                int frescoHeight=initFrescoViewHeight(information.getImageUrls().length);
                frescoView.getLayoutParams().height=frescoHeight;
                frescoView.addFrescoData(information.getImageUrls());
            }
        }
    }

    /**
     * 计算墙纸高度
     */
    private int initFrescoViewHeight(int urlSize){
        int height=0;
        switch (urlSize){
            case 1:
                height= ViewUtils.dip2px(300);
                break;
            case 2:
                height =  ViewUtils.dip2px(200);
                break;
            case 3:
                height =  ViewUtils.dip2px(150);
                break;
            case 4:
                height =  ViewUtils.dip2px(410);
                break;
            case 5:
                height =  ViewUtils.dip2px(310);
                break;
            case 6:
                height =  ViewUtils.dip2px(310);
                break;
            case 7:
                height =  ViewUtils.dip2px(470);
                break;
            case 8:
                height =  ViewUtils.dip2px(470);
                break;
            case 9:
                height =  ViewUtils.dip2px(470);
                break;

        }
        return height;
    }


    /**
     * 缓存 Information json
     * @param informationJson
     */
    private void setACacheData(String informationJson){
        ACache aCache=ACache.get(getActivity());
        aCache.put(this.getClass().getName(),informationJson,2*ACache.TIME_DAY);//缓存2天
    }

    /**
     * 获取Information json缓存
     * @return informationJson
     */
    private String getACacheData(){
        ACache aCache=ACache.get(getActivity());
        aCache.getAsString(this.getClass().getName());
        return "";
    }
}
