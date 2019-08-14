package com.bittech.java7.chatroom.controller;


import com.bittech.java7.chatroom.config.FreeMarkerListener;
import com.bittech.java7.chatroom.service.AccountService;
import com.bittech.java7.chatroom.utils.CommUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
    private AccountService accountService = new AccountService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        response.setContentType("text/html;charset=utf8");
        PrintWriter out = response.getWriter();
        if (CommUtils.strIsNull(userName) || CommUtils.strIsNull(password)) {
            //登陆失败,停留在登陆页面
            out.println("<script>\n" +
                    "    alert(\"用户名或密码为空\")\n" +
                    "    window.location.href = \"/index.html\";\n" +
                    "</script>");

        }
        if (accountService.userLogin(userName, password)) {
            //登陆成功，跳转到聊天页面
            //加载ftl
            Template template = getTemplate(request, "/chat.ftl");
            Map<String, String> map = new HashMap<>();
            map.put("username", userName);
            try {
                template.process(map, out);
            } catch (TemplateException e) {
                e.printStackTrace();
            }
        } else {//登陆失败，返回到登陆页面
            out.println("<script>\n" +
                    "    alert(\"用户名或密码错误\")\n" +
                    "    window.location.href = \"/index.html\";\n" +
                    "</script>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private Template getTemplate(HttpServletRequest req, String fileName) {
        Configuration configuration =
                (Configuration) req.getServletContext().getAttribute(FreeMarkerListener.TEMPLATE_KEY);
        try {
            return configuration.getTemplate(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
