package com.example.dingdong.home.information;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.example.dingdong.R;
import com.example.dingdong.base.BaseActivity;
import com.example.dingdong.unit.CollectionUtils;
import com.example.dingdong.widget.FrescoViewPager;
import com.example.dingdong.widget.photoView.PhotoView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CCX on 2018/2/6.
 * 画壁查看界面
 */
public class FrescoViewPageActivity extends BaseActivity {
    public final static String IMAGES_URL="images_url";
    public final static  String SHOW_POINT="show_point";
    private FrescoViewPager viewPager;
    private HackyViewAdapter hackyViewAdapter;
    private List<String> urls;
    private int showPoint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int initLayout() {
        return R.layout.fresco_view_page_layout;
    }

    @Override
    public void initView() {
        viewPager=(FrescoViewPager)findViewById(R.id.view_pager);

    }

    @Override
    public void initData() {
        Intent intent=getIntent();
        if(intent.hasExtra(IMAGES_URL)){
            urls= (List<String>) intent.getSerializableExtra(IMAGES_URL);
        }
        if(intent.hasExtra(SHOW_POINT)){
            showPoint=intent.getIntExtra(SHOW_POINT,0);
        }
        if(CollectionUtils.isNotEmpty(urls)){
            hackyViewAdapter=new HackyViewAdapter(urls);
            viewPager.setAdapter(hackyViewAdapter);
            if(showPoint<urls.size()){
                viewPager.setCurrentItem(showPoint);
            }
        }
    }

    @Override
    public void initEvent() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    class HackyViewAdapter extends PagerAdapter{
        private List<String> urls=new ArrayList<>();

       public  HackyViewAdapter(List<String> urls){
           if(urls!=null){
              this.urls.clear();
               this.urls.addAll(urls);
           }
       }

        @Override
        public int getCount() {
            if(urls==null){
                return 0;
            }else{
                return urls.size();
            }
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            PhotoView photoView = new PhotoView(container.getContext());
            photoView.setImageUri(urls.get(position));

            // Now just add PhotoView to ViewPager and return it
            container.addView(photoView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            return photoView;
        }
    }

}
