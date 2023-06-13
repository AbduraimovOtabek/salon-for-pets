package com.company.controller;

import com.company.model.User;
import com.company.utils.AppConst;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = CabinetController.BASE_PATH)
public class CabinetController extends HttpServlet {

    public static final String BASE_PATH = "/cabinet";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession httpSession = req.getSession(false);
        User currentUser = (User) httpSession.getAttribute(AppConst.CURRENT_USER);

        req.setAttribute(AppConst.CURRENT_USER,currentUser);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/cabinet.jsp");
        requestDispatcher.forward(req,resp);

    }
}
