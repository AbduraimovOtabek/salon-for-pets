package com.company.controller;

import com.company.model.User;
import com.company.service.LoginService;
import com.company.utils.AppConst;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebServlet(value = LoginController.BASE_PATH)
public class LoginController extends HttpServlet {

    public static final String BASE_PATH = "/login";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        resp.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        User user = User.builder()
//                .userName(req.getParameter("userName"))
//                .password(req.getParameter("password"))
//                .build();
//        RequestDispatcher rd;
//
//        if (Objects.isNull(user.getUserName()) || user.getUserName().isBlank() ||
//                Objects.isNull(user.getPassword()) || user.getPassword().isBlank()) {
//            resp.getWriter()
//                    .write("<h1 style=\"color: red\">" + "Email or password is required" + "</h1>");
//            rd = req.getRequestDispatcher("/login");
//            rd.include(req, resp);
//
//        } else {
//            LoginService loginService = LoginService.getInstance();
//            boolean isLogin = loginService.login(user);
//
//            if (isLogin) {
//                HttpSession session = req.getSession();
//
//                session.setAttribute(AppConst.CURRENT_USER, user);
//                req.setAttribute(AppConst.CURRENT_USER, user);
//                resp.sendRedirect("CabinetController.BASE_PATH");
//            } else {
//                resp
//                        .getWriter()
//                        .write("<h1 style=\\\"color: red\\\">Wrong email or password!</h1>");
//                rd = req.getRequestDispatcher("/login.jsp");
//                rd.include(req, resp);
//            }
//        }

        User user = User.builder()
                .userName(req.getParameter("userName"))
                .password(req.getParameter("password"))
                .build();
        RequestDispatcher requestDispatcher;

        if (Objects.isNull(user.getUserName()) || user.getUserName().isBlank()
                || Objects.isNull(user.getPassword()) || user.getPassword().isBlank()) {

            resp
                    .getWriter()
                    .write("<div align=\"center\"> <h1 style=\"color: green\">EMAIL OR PASSWORD REQUIRED!</h1>  </div>");
            requestDispatcher = req.getRequestDispatcher("login.jsp");
            requestDispatcher.include(req, resp);

        } else {
            LoginService loginService = LoginService.getInstance();
            boolean isLogin = loginService.login(user);

            if (isLogin) {
                HttpSession session = req.getSession();

                session.setAttribute(AppConst.CURRENT_USER, user);
                resp.sendRedirect(CabinetController.BASE_PATH);

            } else {
                resp.getWriter()
                        .write("<div align=\"center\"> <h1 style=\"color: green\">WRONG EMAIL OR PASSWORD! PLEASE TRY AGAIN</h1>  </div>");
                requestDispatcher = req.getRequestDispatcher("login.jsp");
                requestDispatcher.include(req, resp);

            }
        }

    }
}
