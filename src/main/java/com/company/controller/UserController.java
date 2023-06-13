package com.company.controller;

import com.company.model.User;
import com.company.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet(value = UserController.BASE_PATH)
public class UserController extends HttpServlet {
    public static final String BASE_PATH = "/list-users";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Objects.isNull(req.getParameter("id"))) {
            UserService userService = UserService.getInstance();
            List<User> users = userService.list();
            req.setAttribute("users", users);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("users.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
