package com.bite.cookie.a_hello;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //服务器创建cookie对象
        Cookie cookie = new Cookie("name1", "zhansan");
        //服务器将信息返回到浏览器端储存
        response.addCookie(cookie);
        //再次向服务器发送请求，服务器获取到cookie的数据
        Cookie[] cookies = request.getCookies();
        if (cookie != null) {
            for (Cookie c : cookies) {
                System.out.println(c.getName() + "=" + c.getValue());
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
