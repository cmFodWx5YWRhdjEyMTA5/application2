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
        informationModelIv.setOnClickListener(this);
        messageModelIv=(LogImageView)findViewById(R.id.message_model);
        messageModelIv.setOnClickListener(this);
        fragmentManager=getFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();

    }

    @Override
    public void initData() {
        dInformationFragment=new DInformationFragment();
        fragmentTransaction.replace(R.id.home_page_fl,dInformationFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void initEvent() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.information_model:
        }
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
}
