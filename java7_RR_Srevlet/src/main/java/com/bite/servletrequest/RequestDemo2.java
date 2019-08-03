package com.bite.servletrequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求头
 * user-agent：浏览器的类型
 */
public class RequestDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset= utf-8");
        String value = request.getHeader("user-agent");
        if (value.contains("Chrome")) {
            System.out.println("你使用的是谷歌");
        }

    }
}
