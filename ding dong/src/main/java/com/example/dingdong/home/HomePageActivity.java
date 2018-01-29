package com.example.dingdong.home;

import android.app.FragmentTransaction;

import com.example.dingdong.base.BaseActivity;
import com.example.dingdong.R;

/**
 * 首页
 * Created by CCX on 2017/8/21.
 */
public class HomePageActivity extends BaseActivity{
    private android.app.FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private ApplicationFragment applicationFragment;
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
        applicationFragment=new ApplicationFragment();
        fragmentTransaction.replace(R.id.home_page_fl,applicationFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void initEvent() {

    }
}
