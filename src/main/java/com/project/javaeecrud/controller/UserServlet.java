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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet(name = "usersServlet", value = "/users")
@ServletSecurity(httpMethodConstraints = {
        @HttpMethodConstraint(value = "GET", rolesAllowed = "manager"),
        @HttpMethodConstraint(value = "POST", rolesAllowed = "manager")
})
public class UserServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger("My Logger");




    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("delete")!=null){
            UserDAO.deleteUser(Integer.parseInt(req.getParameter("delete")));
        } else if (req.getParameter("edit")!=null){
        }

        List<User> users = UserDAO.getAllUsers();
        logger.log(Level.INFO,users.toString());
        req.getSession().setAttribute("users",users);

        req.getRequestDispatcher("/secured/users.jsp").forward(req,resp);
//        RequestDispatcher view = getServletContext().getRequestDispatcher("/users.jsp");
//        view.forward(req,resp);



    }

}
