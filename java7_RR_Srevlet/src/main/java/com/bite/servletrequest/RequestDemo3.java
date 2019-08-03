package com.bite.servletrequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求头
 * referer：判断一个地址是否是非法链接
 */

public class RequestDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset= utf-8");
        //获取请求头
        String value = request.getHeader("referer");
        System.out.println(value);
        /**
         * 非法链接：
         * 1)直接访问后台的资源 referer：null
         * 2)如果没有经过广告页面的跳转：！referer.contians("adv.html")
         */

        response.getWriter().write("正在下载");
    }
}
