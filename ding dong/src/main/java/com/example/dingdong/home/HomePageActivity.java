package com.example.dingdong.home;

import android.app.FragmentTransaction;

import com.example.dingdong.base.BaseActivity;
import com.example.dingdong.R;
import com.example.dingdong.home.information.DInformationFragment;
import com.example.dingdong.home.message.DHomeMessageFragment;

/**
 * 首页
 * Created by CCX on 2017/8/21.
 */
public class HomePageActivity extends BaseActivity{
    private android.app.FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private DHomeMessageFragment messageFragment;
    private DInformationFragment dInformationFragment;
    @Override
    public int initLayout() {
        return R.layout.dd_home_page_layout;
    }

    @Override
    public void initView() {
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
}
