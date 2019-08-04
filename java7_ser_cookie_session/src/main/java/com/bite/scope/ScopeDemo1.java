package com.bite.scope;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ServletContext作用三：可以作为域对象
 */
public class ScopeDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取全局管理者对象ServletContext
        ServletContext servletContext = this.getServletContext();
        //setAttribute(Stirng name，任意类型)
        //servletContext.setAttribute("name","jack");
        List<String> list = new ArrayList<>();
        list.add("jacky");
        list.add("eric");
        list.add("lucy");
        //存储到域
        servletContext.setAttribute("list",list);
        System.out.println("保存数据成功...");
    }
}
