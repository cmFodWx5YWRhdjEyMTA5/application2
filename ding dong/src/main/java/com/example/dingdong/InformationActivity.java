package com.example.dingdong;
import android.text.format.DateUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.example.dingdong.base.BaseListActivity;
import com.example.dingdong.common.ACache;
import com.example.dingdong.db.model.InformationModel;
import com.example.dingdong.db.model.NewsUserModel;
import com.example.dingdong.unit.TimeDateUtil;
import com.example.dingdong.widget.BaseViewHolder;
import com.example.dingdong.widget.LogImageView;
import com.example.dingdong.widget.LogTextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @auther CCX
 * @date 2018/1/26
 * 资讯列表界面
 * 刷新时应以帖子的创建时间来获取20条信息
 */
public class InformationActivity extends BaseListActivity<InformationModel> {

    @Override
    public BaseViewHolder onShowCreateItemView(ViewGroup parent) {
        View view=View.inflate(parent.getContext(),R.layout.dd_information_item_layout,null);
        return new InformationViewHolder(view);
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
            informationModel.setCreateDate(1517323344);
            NewsUserModel userModel=new NewsUserModel();
            userModel.setUserId(i+1);
            userModel.setUserName("曹才西");
            userModel.setVip(true);
            informationModel.setNewsUserModel(userModel);
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
        private LinearLayout customerLLayout;

        public InformationViewHolder(View itemView) {
            super(itemView);
            circleIv=(CircleImageView) itemView.findViewById(R.id.mobile_fixed_left_iv);
            vipIv=(LogImageView)itemView.findViewById(R.id.cart_vip_logo_iv);
            rightTopTv=(LogTextView)itemView.findViewById(R.id.mobile_fixed_right_top_pv);
            centerTopTv=(LogTextView)itemView.findViewById(R.id.mobile_fixed_center_top_tv);
            centerBottomTv=(LogTextView)itemView.findViewById(R.id.mobile_fixed_center_bottom_tv);
            rightBottomTv=(LogTextView)itemView.findViewById(R.id.mobile_fixed_right_bottom_tv);
            themeMessageTv=(LogTextView)itemView.findViewById(R.id.information_theme_message_tv);
            customerLLayout=(LinearLayout)itemView.findViewById(R.id.information_image_layout);
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
                    Glide.with(getBaseContext()).load(newsUserModel.getHeadPortrait()).into(circleIv);
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
                initContentView();
            }
        }
    }

    private void initContentView(){

    }

    /**
     * 缓存 Information json
     * @param informationJson
     */
    private void setACacheData(String informationJson){
        ACache aCache=ACache.get(this);
        aCache.put(this.getClass().getName(),informationJson,2*ACache.TIME_DAY);//缓存2天
    }

    /**
     * 获取Information json缓存
     * @return informationJson
     */
    private String getACacheData(){
        ACache aCache=ACache.get(this);
        aCache.getAsString(this.getClass().getName());
        return "";
    }
}
