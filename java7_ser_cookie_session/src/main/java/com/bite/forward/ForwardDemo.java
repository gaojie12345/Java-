package com.bite.forward;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 作用四：ServletContext请求转发技术
 */
public class ForwardDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*//获取全局管理者对象
        ServletContext servletContext = this.getServletContext();
        //获取转发对象
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/dic.html");
        //forward(request，response)
        requestDispatcher.forward(request,response);*/

        //简写方式
        request.getRequestDispatcher("/idc.html").forward(request,response);
    }
}
