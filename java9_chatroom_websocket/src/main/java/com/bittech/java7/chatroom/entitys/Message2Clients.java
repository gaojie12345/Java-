package com.bittech.java7.chatroom.entitys;

import lombok.Data;

import java.util.Map;

/**
 * 后端发送给前端的信息实体
 */
@Data
public class Message2Clients {
    //聊天的内容
    private String content;
    //服务器端登录的所有用户列表
    private Map<String ,String> names;




    public String getContent() {
        return content;
    }

    public void setContent(String msg) {
        this.content = msg;
    }
    public void setContent(String userName,String msg) {
        this.content = userName + "说：" + msg;

    }


    public Map<String, String> getNames() {
        return names;
    }

    public void setNames(Map<String, String> names) {
        this.names = names;
    }

    @Override
    public String toString() {
        return "Message2Clients{" +
                "content='" + content + '\'' +
                ", names=" + names +
                '}';
    }
}
