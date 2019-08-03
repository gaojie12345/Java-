package com.bite.servletrequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * get方法和post方法提交获取参数数据的通用方式
 */
public class RequestDemo5 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /**
         * getParameter(String name):通过参数名称(表单的name属性值)获取参数值
         * getParameterNames():获取的是所有的参数内容，返回的是Enurmation(类似于Iterator)
         * getParameterMap():获取的是Map集合<String，String[]>
         */
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
