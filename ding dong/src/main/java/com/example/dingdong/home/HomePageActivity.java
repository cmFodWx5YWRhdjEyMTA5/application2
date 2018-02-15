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
    private LogImageView informationModelIv,messageModelIv;
    private long mExitTime=0;
    @Override
    public int initLayout() {
        return R.layout.dd_home_page_layout;
    }

    @Override
    public void initView() {
        informationModelIv=(LogImageView) findViewById(R.id.information_model);
        messageModelIv=(LogImageView)findViewById(R.id.message_model);
        fragmentManager=getFragmentManager();


    }

    @Override
    public void initData() {
        dInformationFragment=new DInformationFragment();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.home_page_fl,dInformationFragment);
        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    public void initEvent() {
        informationModelIv.setOnClickListener(this);
        messageModelIv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        fragmentTransaction=fragmentManager.beginTransaction();
        switch (view.getId()){
            case R.id.information_model:
                hideAllFragment();
                if(dInformationFragment==null){

                    fragmentTransaction=fragmentManager.beginTransaction();
                    fragmentTransaction.add(R.id.home_page_fl,dInformationFragment);
                }else{
                    fragmentTransaction.show(dInformationFragment);
                }
                break;
            case R.id.message_model:
                hideAllFragment();
                if(messageFragment==null){
                    messageFragment=new DHomeMessageFragment();
                    fragmentTransaction.add(R.id.home_page_fl,messageFragment);

                }else{
                    fragmentTransaction.show(messageFragment);
                }
                break;
        }
        fragmentTransaction.commitAllowingStateLoss();
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
}
