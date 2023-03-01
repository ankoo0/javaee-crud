package com.project.javaeecrud.controller;//package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getSession(true);

        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//       String username =  req.getParameter("j_username");
//        String password =  req.getParameter("j_password");
//        req.getSession().setAttribute("j_username",username);
//        req.getSession().setAttribute("j_password",password);
//        req.getParameterMap().put( "j_username", new String[]{ username } );
//        req.getParameterMap().put( "j_password", new String[]{ password } );
//        System.out.println(username + " " + password);
//        resp.sendRedirect("/javaee-crud/j_security_check?j_username=" + username    + "&j_password=" + password);
        req.getRequestDispatcher("secured/users").forward(req,resp);
    }
}
