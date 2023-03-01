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
import java.util.logging.Logger;


@WebServlet(name = "editUserServlet", value = "/users/edit")
@ServletSecurity(httpMethodConstraints = {
        @HttpMethodConstraint(value = "GET", rolesAllowed = "manager"),
        @HttpMethodConstraint(value = "POST", rolesAllowed = "manager")
})
public class UpdateUserServlet extends HttpServlet {

    Logger logger = Logger.getLogger("My Logger");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        User user = UserDAO.getUserById(id);
        req.getSession().setAttribute("user", user);
        req.getSession().setAttribute("id",id);

        req.getServletContext().getRequestDispatcher("/secured/edit.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> userParams = req.getParameterMap();
        userParams.forEach((key, value) -> System.out.println(key + "     " + Arrays.toString(value)));
        int id = Integer.parseInt(req.getParameter("id"));
        User user = new User(userParams.get("fName")[0], userParams.get("lName")[0], Integer.parseInt(userParams.get("age")[0]), userParams.get("email")[0], userParams.get("position")[0]);
        if (UserVerification.verify(user)) {
            UserDAO.updateUser(id,user);
            req.getServletContext().getRequestDispatcher("/secured/users.jsp").forward(req, resp);
        }

    }
}
//        URL url = getClass().getResource("nibba.jpg");
//        BufferedInputStream itStrm = new BufferedInputStream(Files.newInputStream(Paths.get(url.toString())));
//        byte[] b3 = itStrm.readAllBytes();
//        String base64String = Base64.getEncoder().encodeToString(b3);
//        req.getSession().setAttribute("image",base64String);