package com.project.javaeecrud.controller;

import com.project.javaeecrud.dao.UserDAO;
import com.project.javaeecrud.model.User;


import javax.servlet.ServletException;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;


@WebServlet(name = "addUserServlet", value = "/users/add")
@ServletSecurity(httpMethodConstraints = {
        @HttpMethodConstraint(value = "GET", rolesAllowed = "manager"),
        @HttpMethodConstraint(value = "POST", rolesAllowed = "manager")
})
public class AddUserServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        req.getRequestDispatcher("add.jsp").forward(req,resp);
        req.getServletContext().getRequestDispatcher("/secured/add.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String,String[]> userParams = req.getParameterMap();
        userParams.forEach((key, value) -> System.out.println(key + "     " + Arrays.toString(value)));
        User user = new User(userParams.get("fName")[0],userParams.get("lName")[0],Integer.parseInt(userParams.get("age")[0]),userParams.get("email")[0],userParams.get("position")[0]);
        if (UserVerification.verify(user)){
            UserDAO.insertUser(user);
            req.getServletContext().getRequestDispatcher("/secured/add.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
