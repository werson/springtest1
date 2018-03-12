package com.werson.springtest.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by wersom on 2017/10/18 0018.
 */
public class HelloServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("初始化servlet");
        super.init();
    }

    public void  doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        /*response.setContentType("text/json; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("hahaha");*/
        throw new ServletException("test catch Exception.");
        //response.sendRedirect("/test/login.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public void destroy(){
        System.out.println("销毁servlet");
        super.destroy();
    }

}
