package com.example.dingdong.home.message;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.dingdong.R;
import com.example.dingdong.base.BaseFragment;
import com.example.dingdong.base.BaseListFragment;
import com.example.dingdong.db.model.MessageModel;
import com.example.dingdong.db.model.NewsUserModel;
import com.example.dingdong.unit.TimeDateUtil;
import com.example.dingdong.widget.BaseViewHolder;
import com.example.dingdong.widget.LogTextView;

import de.hdodenhof.circleimageview.CircleImageView;

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
        initTestData();
        Toast.makeText(getActivity(),"群组",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void otherPullAction() {

    }

    private void initTestData(){
        MessageModel messageModel=new MessageModel();
        messageModel.setGroupHead("https://file.iworker.cn/inside/get_erp_img/cid:87512/id:2234365/type:0");
        messageModel.setGroupName("测试群组");
        messageModel.setLastDate(1517927247);
        messageModel.setLinkKey("chat-12123213");
        messageModel.setMultiPrv(true);
        messageModel.setSummarize("测试聊天群组样式！");
        mListData.add(messageModel);
        notifyDataSetChanged();
    }

    class MessageViewHold extends BaseViewHolder{
        private CircleImageView headIV;
        private LogTextView groupNameTv,replayTimeTv,summarizeTv;
        public MessageViewHold(View itemView) {
            super(itemView);
            headIV= (CircleImageView) itemView.findViewById(R.id.message_item_head);
            groupNameTv= (LogTextView) itemView.findViewById(R.id.message_group_name);
            replayTimeTv=(LogTextView)itemView.findViewById(R.id.message_last_replay_time);
            summarizeTv=(LogTextView)itemView.findViewById(R.id.message_summarize);
        }

        @Override
        protected void onItemClick(View view, int adapterPosition) {
            MessageModel messageModel=   mListData.get(adapterPosition);
            //群组不为空
            if(messageModel!=null){
                String linkKey=messageModel.getLinkKey();
                Intent intent=new Intent(getActivity(),ChatDetailActivity.class);
                intent.putExtra(ChatDetailActivity.MESSAGE_NAME,messageModel.getGroupName());
                intent.putExtra(ChatDetailActivity.MESSAGE_LINK_KEY,linkKey);
                intent.putExtra(ChatDetailActivity.MESSAGE_IS_MULTI,messageModel.isMultiPrv());
                getActivity().startActivity(intent);
            }
        }

        @Override
        public void onBindViewHolder(int position) {
            MessageModel messageModel=mListData.get(position);
            if(messageModel!=null){
                Glide.with(getActivity()).load(messageModel.getGroupHead()).into(headIV);
                groupNameTv.setText(messageModel.getGroupName());
                replayTimeTv.setText(TimeDateUtil.date(TimeDateUtil.DEFAULT_FORMAT_M,messageModel.getLastDate()));
                summarizeTv.setText(messageModel.getSummarize());
            }
        }
    }

}
