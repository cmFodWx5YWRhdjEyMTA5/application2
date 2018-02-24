package com.example.dingdong.home.message;
import android.view.ViewGroup;
import com.example.dingdong.base.BaseListActivity;
import com.example.dingdong.widget.BaseViewHolder;

/**
 *
 * 聊天详情界面
 * @auther CCX
 * @date 2018/2/24
 */

public class ChatDetailActivity extends BaseListActivity {
    public final static String MESSAGE_NAME="message_name";//群组名称
    public final static String MESSAGE_LINK_KEY="message_link_key";//
    public final static String MESSAGE_IS_MULTI="message_is_multi";//是否是群聊

    @Override
    public BaseViewHolder onShowCreateItemView(ViewGroup parent) {
        return null;
    }

    @Override
    public void otherDropDownAction() {

    }

    @Override
    public void otherPullAction() {

    }
}
