package com.example.dingdong;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.dingdong.base.BaseListActivity;
import com.example.dingdong.common.ACache;
import com.example.dingdong.db.model.InformationModel;
import com.example.dingdong.db.model.NewsUserModel;
import com.example.dingdong.widget.BaseViewHolder;
import com.example.dingdong.widget.LogImageView;
import com.example.dingdong.widget.LogTextView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @auther CCX
 * @date 2018/1/26
 * 资讯列表界面
 * 刷新时应以帖子的创建时间来获取20条信息
 */
public class InformationActivity extends BaseListActivity<InformationModel> {

    @Override
    public BaseViewHolder onCreateItemView(ViewGroup parent) {
        View view=View.inflate(parent.getContext(),R.layout.dd_information_item_layout,null);
        return new InformationViewHolder(view);
    }

    @Override
    public void dropDownAction() {

    }

    @Override
    public void pullAction() {
        customSomeInformationBean();
    }
    private void  customSomeInformationBean(){

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
            circleIv=(CircleImageView) findViewById(R.id.mobile_fixed_left_iv);
            vipIv=(LogImageView)findViewById(R.id.cart_vip_logo_iv);
            rightTopTv=(LogTextView)findViewById(R.id.mobile_fixed_right_top_pv);
            centerTopTv=(LogTextView)findViewById(R.id.mobile_fixed_center_top_tv);
            centerBottomTv=(LogTextView)findViewById(R.id.mobile_fixed_center_bottom_tv);
            rightBottomTv=(LogTextView)findViewById(R.id.mobile_fixed_right_bottom_tv);
            themeMessageTv=(LogTextView)findViewById(R.id.information_theme_message_tv);
            customerLLayout=(LinearLayout)findViewById(R.id.information_image_layout);
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

                }
            }
        }
    }

    /**
     * 缓存 Information json
     * @param informationJson
     */
    private void setACacheData(String informationJson){

    }
}
