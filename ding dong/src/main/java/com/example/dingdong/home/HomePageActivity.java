package com.example.dingdong.home;

import android.app.FragmentTransaction;
import android.view.View;
import android.widget.Toast;

import com.example.dingdong.base.BaseActivity;
import com.example.dingdong.R;
import com.example.dingdong.home.information.DInformationFragment;
import com.example.dingdong.home.message.DHomeMessageFragment;
import com.example.dingdong.widget.LogImageView;

/**
 * 首页
 * Created by CCX on 2017/8/21.
 */
public class HomePageActivity extends BaseActivity implements View.OnClickListener{
    private android.app.FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private DHomeMessageFragment messageFragment;
    private DInformationFragment dInformationFragment;
    private LogImageView informationModelIv,messageModelIv,marketStatisticsModelIv,myselfModelIv;
    private long mExitTime=0;
    @Override
    public int initLayout() {
        return R.layout.dd_home_page_layout;
    }

    @Override
    public void initView() {
        informationModelIv=(LogImageView) findViewById(R.id.information_model);
        messageModelIv=(LogImageView)findViewById(R.id.message_model);
        marketStatisticsModelIv=(LogImageView)findViewById(R.id.market_statistics_model);
        myselfModelIv=(LogImageView)findViewById(R.id.myself_model);
        fragmentManager=getFragmentManager();


    }

    @Override
    public void initData() {
        dInformationFragment=new DInformationFragment();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.home_page_fl,dInformationFragment);
        fragmentTransaction.commitAllowingStateLoss();
        setTableVew(1);
    }

    @Override
    public void initEvent() {
        informationModelIv.setOnClickListener(this);
        messageModelIv.setOnClickListener(this);
        marketStatisticsModelIv.setOnClickListener(this);
        myselfModelIv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        fragmentTransaction=fragmentManager.beginTransaction();
        int table=1;
        switch (view.getId()){
            case R.id.information_model:
                table=1;
                hideAllFragment();
                if(dInformationFragment==null){

                    fragmentTransaction=fragmentManager.beginTransaction();
                    fragmentTransaction.add(R.id.home_page_fl,dInformationFragment);
                }else{
                    fragmentTransaction.show(dInformationFragment);
                }
                break;
            case R.id.message_model:
                table=2;
                hideAllFragment();
                if(messageFragment==null){
                    messageFragment=new DHomeMessageFragment();
                    fragmentTransaction.add(R.id.home_page_fl,messageFragment);

                }else{
                    fragmentTransaction.show(messageFragment);
                }
                break;
            case R.id.market_statistics_model:
                table=3;
                break;
            case R.id.myself_model:
                table=4;
                break;
        }
        fragmentTransaction.commitAllowingStateLoss();
        setTableVew(table);
    }

    @Override
    public void onBackPressed() {
        if(System.currentTimeMillis()-mExitTime>2000){
            mExitTime= System.currentTimeMillis();
            Toast.makeText(HomePageActivity.this,getResources().getString(R.string.str_exit_prompt), Toast.LENGTH_SHORT).show();
        }else {
            super.onBackPressed();
        }
    }

    private void hideAllFragment(){
        if(fragmentTransaction==null){
            fragmentManager=getFragmentManager();
            fragmentTransaction=fragmentManager.beginTransaction();
        }
        if(dInformationFragment!=null){
            fragmentTransaction.hide(dInformationFragment);
        }
        if(messageFragment!=null){
            fragmentTransaction.hide(messageFragment);
        }
    }

    /**
     *  设置icon 图标
     *  1 资讯
     *  2 消息
     *  3 市场
     *  4 我的
     */
    private void setTableVew(int table){
        switch (table){
            case 1:
                informationModelIv.setBackgroundResource(R.mipmap.home_information_prs);
                messageModelIv.setBackgroundResource(R.mipmap.home_message_nor);
                marketStatisticsModelIv.setBackgroundResource(R.mipmap.home_bazaar_nor);
                myselfModelIv.setBackgroundResource(R.mipmap.home_myself_nor);
                break;
            case 2:
                informationModelIv.setBackgroundResource(R.mipmap.home_information_nor);
                messageModelIv.setBackgroundResource(R.mipmap.home_message_prs);
                marketStatisticsModelIv.setBackgroundResource(R.mipmap.home_bazaar_nor);
                myselfModelIv.setBackgroundResource(R.mipmap.home_myself_nor);
                break;
            case 3:
                informationModelIv.setBackgroundResource(R.mipmap.home_information_nor);
                messageModelIv.setBackgroundResource(R.mipmap.home_message_nor);
                marketStatisticsModelIv.setBackgroundResource(R.mipmap.home_bazaar_prs);
                myselfModelIv.setBackgroundResource(R.mipmap.home_myself_nor);
                break;
            case 4:
                informationModelIv.setBackgroundResource(R.mipmap.home_information_nor);
                messageModelIv.setBackgroundResource(R.mipmap.home_message_nor);
                marketStatisticsModelIv.setBackgroundResource(R.mipmap.home_bazaar_nor);
                myselfModelIv.setBackgroundResource(R.mipmap.home_myself_prs);
                break;
        }
    }
}
