package com.example.dingdong.widget;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.dingdong.R;
import com.example.dingdong.widget.Adapter.FrescoAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CCX on 2018/2/3.
 * 壁纸view
 */
public class FrescoView extends RelativeLayout{
    private Context context;
    private RecyclerView recyclerView;
    private FrescoAdapter frescoAdapter;
    public FrescoView(Context context) {
        this(context,null);
    }

    public FrescoView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public FrescoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        initView();
    }
    private void initView(){
        View view=View.inflate(context, R.layout.fresco_view_layout,null);
        recyclerView=(RecyclerView)view.findViewById(R.id.fresco_rv);
    }

    /**
     * 用来接受壁纸的数据集
     * @param imageUrls
     */
    public void addFrescoData(String[] imageUrls){
        if(imageUrls!=null&&imageUrls.length>0){
           int urlSize= imageUrls.length;
            if(urlSize==1){
                setRecyclerViewManagerForTypeOne();
            }else if(urlSize==2||urlSize==4){
                setRecyclerViewManagerForTypeTwo();
            }else{
                setRecyclerViewManagerForTypeThree();
            }
        }
        frescoAdapter=new FrescoAdapter();
        recyclerView.setAdapter(frescoAdapter);
        List<String> urlList=new ArrayList<>();
        for(int i=0;i<imageUrls.length;i++){
            urlList.add(imageUrls[i]);
        }
        frescoAdapter.setValue(urlList,recyclerView);
    }

    private void setRecyclerViewManagerForTypeOne(){
        if(recyclerView!=null){
            LinearLayoutManager manager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL, false){
                @Override
                public boolean canScrollVertically() {
                    return false;
                }
            };
            recyclerView.setLayoutManager(manager);
        }

    }

    private void setRecyclerViewManagerForTypeTwo(){
        StaggeredGridLayoutManager gridLayoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    private void setRecyclerViewManagerForTypeThree(){
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),3){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
    }


}
