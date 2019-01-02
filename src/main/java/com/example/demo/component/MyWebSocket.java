package com.example.demo.component;

import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint(value = "/websocket")
@Component
public class MyWebSocket {

    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlinecount = 0;

    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<MyWebSocket> webSocketSet = new CopyOnWriteArraySet<MyWebSocket>();


    private Session session;

    /**
     * 建立连接 成功调用方法
     */
    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        webSocketSet.add(this);
        addOnlineCount();
        System.out.println("新连接加入！ 当前在线人数为："+getOnlineCount());
        try {
            for (int i=0;i<10;i++){
                sendMessage("message"+i);
                Thread.sleep(3000);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose(){
        webSocketSet.remove(this);
        subOnlineCount();
        System.out.println("有连接关闭");
    }

    @OnError
    public void onError(Session session,Throwable error){
        System.out.println("some error");
        error.printStackTrace();
    }


    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }


    public static void sendInfo(String message) {
        for (MyWebSocket item:webSocketSet){
            try{
                item.sendMessage(message);
            }catch (IOException e){
                continue;
            }

        }
    }


    public static synchronized int getOnlineCount(){
        return onlinecount;
    }


    public static synchronized void addOnlineCount(){
        MyWebSocket.onlinecount++;
    }

    public static synchronized void subOnlineCount(){
        MyWebSocket.onlinecount--;
    }
}
