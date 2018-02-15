package com.example.dingdong.home.message;

import android.view.View;
import android.view.ViewGroup;

import com.example.dingdong.R;
import com.example.dingdong.base.BaseFragment;
import com.example.dingdong.base.BaseListFragment;
import com.example.dingdong.db.model.MessageModel;
import com.example.dingdong.widget.BaseViewHolder;

/**
 * 首页聊天 message
 * @auther CCX
 * @date 2018/2/9
 */

public class DHomeMessageFragment extends BaseListFragment<MessageModel> {

    @Override
    public BaseViewHolder onShowCreateItemView(ViewGroup parent) {
        View view =View.inflate(parent.getContext(), R.layout.dd_message_fragment_item_layout,null);
        return new MessageViewHold(view);
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        setText(getString(R.string.is_message));
    }

    @Override
    public void otherDropDownAction() {

    }

    @Override
    public void otherPullAction() {

    }

    class MessageViewHold extends BaseViewHolder{

        public MessageViewHold(View itemView) {
            super(itemView);
        }

        @Override
        protected void onItemClick(View view, int adapterPosition) {

        }

        @Override
        public void onBindViewHolder(int position) {

        }
    }

}
