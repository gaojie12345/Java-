package com.bite.scope;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ScopeDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取域中的数据
        //获取全局管理者对象
        ServletContext servletContext = this.getServletContext();
        //String name = (String) servletContext.getAttribute("name");
        List<String> list = (List) servletContext.getAttribute("list");
        System.out.println("name：" + list);
    }
}
