package com.bite.cookie.b_remember;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class RememberSrevlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.编码
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        //2.获取指定名称的cookie："lastTime"
        Cookie c = getCookieByName("lastTime", request.getCookies());
        //判断当前的cookie对象是否为空
        if (c == null) {
            writer.print("你是第一次访问");
        } else {
            //不为空
            String value = c.getValue();
            //场景日期对象
            long time = Long.parseLong(value);
            Date date = new Date(time);
            //date 的一个字符串表达形式
            writer.print("上次访问时间是："+ date.toLocaleString());
        }
        //将当前cookie写回去
        c = new Cookie("lastTime",new Date().getTime() + "");
        c.setMaxAge(3600);
        response.addCookie(c);
    }

    /**
     * 在cookie数组中获取指定名称的cookie对象
     *
     * @param name    存储的cookie
     * @param cookies 页面中存储的所有cookie信息
     * @return
     */
    private Cookie getCookieByName(String name, Cookie[] cookies) {
        //先去判断
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (name.equals(c.getName())) {
                    return c;
                }
            }
        }
        return null;

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
