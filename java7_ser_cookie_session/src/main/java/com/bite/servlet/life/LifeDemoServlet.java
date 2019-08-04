package com.bite.servlet.life;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 *
 */
public class LifeDemoServlet extends HttpServlet {

    public LifeDemoServlet() {
        System.out.println("servlet被创建了");
    }

    //初始化
    @Override
    public void init() throws ServletException {
        System.out.println("servlet被初始化了...");
    }

    //服务方法
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("调用了service方法...");
    }

    //销毁方法
    @Override
    public void destroy() {
        System.out.println("servlet被初销毁了...");
    }
}
