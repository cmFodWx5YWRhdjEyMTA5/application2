package com.example.dingdong.demo;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dingdong.R;
import com.example.dingdong.base.BaseActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by CCX on 2018/4/1.
 */
public class SocketActivity extends BaseActivity {
    private EditText editText;
    private TextView connTv,sendTv,endTv,mTextView;
    private ExecutorService mExecutorService = null;
    private static final String HOST = "192.168.1.100";
    private static final int PORT = 9999;
    private PrintWriter printWriter;
    private BufferedReader in;

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
           String receiveMsg= (String) msg.obj;
            mTextView.setText(receiveMsg + "\n\n" + mTextView.getText());
        }
    };

    private static final String TAG = "TAG";
    @Override
    public int initLayout() {
        return R.layout.demo_socket_layout;
    }

    @Override
    public void initView() {
        editText=(EditText)findViewById(R.id.demo_message_et);
        connTv=(TextView) findViewById(R.id.conn_tv);
        sendTv=(TextView)findViewById(R.id.send_tv);
        endTv=(TextView)findViewById(R.id.end_tv);
        mTextView=(TextView)findViewById(R.id.say_message_tv);
    }

    @Override
    public void initData() {
        mExecutorService = Executors.newCachedThreadPool();
    }

    @Override
    public void initEvent() {
        connTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mExecutorService.execute(new connectService());
            }
        });
        sendTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sendMsg = editText.getText().toString();
                mExecutorService.execute(new sendService(sendMsg));
            }
        });
        endTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mExecutorService.execute(new sendService("0"));
            }
        });
    }
    private class sendService implements Runnable {
        private String msg;

        sendService(String msg) {
            this.msg = msg;
        }

        @Override
        public void run() {
            printWriter.println(this.msg);
        }
    }
    private class connectService implements Runnable {
        @Override
        public void run() {
            try {
                Socket socket = new Socket(HOST, PORT);
                socket.setSoTimeout(60000);
                printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
                        socket.getOutputStream(), "UTF-8")), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                receiveMsg();
            } catch (Exception e) {
                Log.e(TAG, ("connectService:" + e.getMessage()));
            }
        }
    }

    private void receiveMsg() {
        try {
             String receiveMsg;
            while (true) {
                if ((receiveMsg = in.readLine()) != null) {
                    Log.d(TAG, "receiveMsg:" + receiveMsg);
                    Message message=new Message();
                    message.obj=receiveMsg;
                    handler.sendMessage(message);
                }
            }
        } catch (IOException e) {
            Log.e(TAG, "receiveMsg: ");
            e.printStackTrace();
        }
    }

}
