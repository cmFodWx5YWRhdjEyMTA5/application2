package com.example.dingdong.socket;
import java.net.URISyntaxException;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

import static io.socket.client.IO.socket;


/**
 * socket 封装类
 * Created by hasee on 2017/3/5.
 */
public class DSocket {
    private static Socket mSocket;
    private static String socketUrl="http://192.168.1.4:9208";
    private DSocket(){
        initSocket();
    }

    public static DSocket getIntense() throws URISyntaxException {
        DSocket dSocket=new DSocket();
        return dSocket;
    }

    private  void initSocket(){
        try {
            IO.Options options=new IO.Options();
            mSocket=socket(socketUrl,options);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }




    public void open(final DSocketMessageBack dSocketMessageBack){
        if(mSocket==null){
            return;
        }
        mSocket.off();//清空所有连接的栈；
        mSocket.on(Socket.EVENT_CONNECT,new  Emitter.Listener(){
            @Override
            public void call(Object... args) {
                if(args!=null){
                    mSocket.emit("11","11");
                    if(dSocketMessageBack!=null){}
                }
            }
        }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                if(args!=null){

                }
            }
        }).on(Socket.EVENT_ERROR,new Emitter.Listener(){
            @Override
            public void call(Object... args) {
                if(args!=null){

                }
            }
        }).on("chatevent", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                if(args!=null){
                    if(dSocketMessageBack!=null){
                        dSocketMessageBack.detailResultChatMessage(args);
                    }

                }
            }
        });
        mSocket.connect();

    }

    public void closeSocketLink(){

    }

}
