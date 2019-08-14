package com.bittech.java7.chatroom.service;


import com.bittech.java7.chatroom.entitys.Message2Clients;
import com.bittech.java7.chatroom.entitys.MessageFromClients;
import com.bittech.java7.chatroom.utils.CommUtils;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.omg.CORBA.ServerRequest;
import sun.plugin2.message.Message;


import javax.servlet.annotation.WebServlet;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

//将当前类标记为一个webSocket类
@ServerEndpoint("/websocket")
public class WebSocket {
    //存储所有连接到后端的websocket
    private static CopyOnWriteArraySet<WebSocket> clients = new CopyOnWriteArraySet<>();
    //绑定当前websocket会话
    private Session session;
    //储存所有的用户列表
    private static Map<String, String> names = new ConcurrentHashMap<>();
    //当前客户端的用户名
    private String userName;

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        //username=' + '${username}'
        String userName = session.getQueryString().split("=")[1];
        this.userName = userName;
        //将客户端聊天实体保存到clients
        clients.add(this);
        //将当前用户以及SessionId保存到用户列表
        names.put(session.getId(), userName);
        System.out.println("有新的连接，SessionId为：" + session.getId() + ",用户名为：" + userName);
        //发送给所有在线用户一个上线通知
        Message2Clients message2Clients = new Message2Clients();
        message2Clients.setContent(userName + "上线了");
        message2Clients.setNames(names);
        //发送信息
        String jsonStr = CommUtils.object2Json(message2Clients);
        for (WebSocket webSocket : clients) {
            webSocket.sendMsg(jsonStr);
        }
    }

    @OnError
    public void onError(Throwable e) {
        System.err.println("webSocket连接失败");
    }

    @OnMessage
    //群聊:{"msg":"777","type":1}
    //私聊:{"to":"0-","msg":"33333","type":2}
    public void onMessage(String msg) {
        //将msg反序列化成对象
        //msg->MessageFromClient
        MessageFromClients messageFromClients =
                (MessageFromClients) CommUtils.json2Object(msg, MessageFromClients.class);
        if (messageFromClients.getType().equals("1")) {
            //群聊信息
            String content = messageFromClients.getMsg();

            Message2Clients message2Clients = new Message2Clients();
            message2Clients.setContent(content);
            message2Clients.setNames(names);
            //群聊发送
            for (WebSocket webSocket : clients) {
                webSocket.sendMsg(CommUtils.object2Json(message2Clients));
            }
        } else if (messageFromClients.getType().equals("2")) {
            //私聊信息
            //内容
            String content = messageFromClients.getMsg();
            int tol = messageFromClients.getTo().length();
            String tos[] = messageFromClients.getTo().substring(0, tol - 1).split("-");
            List<String> lists = Arrays.asList(tos);
            //给指定的SessionID发送信息
            for (WebSocket webSocket : clients) {
                if (lists.contains(webSocket.session.getId()) &&
                        this.session.getId() != webSocket.session.getId()) {
                    //发送私聊信息
                    Message2Clients  message2Clients = new Message2Clients();
                    message2Clients.setContent(userName,content);
                    message2Clients.setNames(names);
                    webSocket.sendMsg(CommUtils.object2Json(message2Clients));
                }
            }
        }
    }

    public void sendMsg(String msg) {
        try {
            this.session.getBasicRemote().sendText(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose() {
        //将客户端聊天实体移除
        clients.remove(this);
        names.remove(session.getId());
        System.out.println("有连接下线了" + ",用户名为：" + userName);
        //发送给所有在线用户一个下线通知
        Message2Clients message2Clients = new Message2Clients();
        message2Clients.setContent(userName + "下线了");
        message2Clients.setNames(names);
        //发送信息
        String jsonStr = CommUtils.object2Json(message2Clients);
        for (WebSocket webSocket : clients) {
            webSocket.sendMsg(jsonStr);
        }

    }
}
