package com.bite.context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * ServletContext:全局管理者对象
 * 作用1：获取全局参数
 * 作用2：获取上下路径（tomcat执行的项目的上下路径）
 */
public class ContextDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取servletContext对象
        ServletContext context = this.getServletContext();
        String res = context.getInitParameter("AAA");
        System.out.println(res);
        System.out.println("---------------------------------");
        //获取全部全局参数
        Enumeration<String> enums = context.getInitParameterNames();
        while (enums.hasMoreElements()) {
            String par = enums.nextElement();
            String ppp = context.getInitParameter(par);
            System.out.println(par + ":" + ppp);
        }
        System.out.println("---------------------------------");
        //获取上下文路径
        //public String getContextPath()
        String contextqqq = request.getContextPath();
        System.out.println(contextqqq);
    }
}
