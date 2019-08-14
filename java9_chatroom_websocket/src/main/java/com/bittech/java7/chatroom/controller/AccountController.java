package com.bittech.java7.chatroom.controller;


import com.bittech.java7.chatroom.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 连接service层，连接用户层
 */
@WebServlet(urlPatterns = "/doRegister")
public class AccountController extends HttpServlet {
    private AccountService accountService = new AccountService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        response.setContentType("text/html;charset=utf8");
        PrintWriter writer = response.getWriter();
        if (accountService.userRegister(userName, password)) {
            //用户注册成功,弹框提示，返回登陆界面
            writer.print(" <script>\n" +
                    "    alert(\"注册成功\")\n" +
                    "    window.location.href = \"/index.html\";\n" +
                    "</script>");
        } else {
            //弹框失败，保留原页面
            writer.println(" <script>\n" +
                    "    alert(\"注册失败\")\n" +
                    "    window.location.href = \"/registration.html\";\n" +
                    "</script>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
