package com.example.dingdong.second.newInformation;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.ViewGroup;

import com.example.dingdong.base.BaseListActivity;
import com.example.dingdong.widget.BaseViewHolder;

import java.io.File;

/**
 * Created by CCX on 2018/3/7.
 */
public class DPhotoWallActivity extends BaseListActivity{
    private final int GET_IMAGE_CONTEXT_CODE=10010;
    @Override
    public BaseViewHolder onShowCreateItemView(ViewGroup parent) {
        return null;
    }

    @Override
    public void otherDropDownAction() {
        Intent pickIntent = new Intent(Intent.ACTION_PICK, null);
        // 如果限制上传到服务器的图片类型时可以直接写如："image/jpeg 、 image/png等的类型"
        pickIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(pickIntent,GET_IMAGE_CONTEXT_CODE);
    }

    @Override
    public void otherPullAction() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            if(requestCode==GET_IMAGE_CONTEXT_CODE){
                data.getData();
            }
        }
    }
}
