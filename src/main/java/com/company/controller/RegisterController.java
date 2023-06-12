package com.company.controller;

import com.company.model.User;
import com.company.service.RegisterService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(value = RegisterController.BASE_PATH)
public class RegisterController extends HttpServlet {

    public static final String BASE_PATH = "/register";
    public static final String BASE_PAGE= "register.jsp";

    @Override
    protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(RegisterController.BASE_PAGE);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = User.builder().
                name(req.getParameter("name"))
                .userName(req.getParameter("userName"))
                .password(req.getParameter("password"))
                .passwordConfirm(req.getParameter("passwordConfirm"))
                .build();
        RequestDispatcher rd;
        if(Objects.isNull(user.getUserName())|| user.getUserName().isBlank()||
                Objects.isNull(user.getName())|| user.getName().isBlank() ||
                        Objects.isNull(user.getPassword()) || user.getPassword().isBlank()){
            StringBuilder sb = new StringBuilder();
            if(Objects.isNull(user.getName()) || user.getName().isBlank())
                sb.append("Name,");
            if(Objects.isNull(user.getUserName()) || user.getUserName().isBlank())
                sb.append(" userName,");
            if(Objects.isNull(user.getPassword()) || user.getPassword().isBlank())
                sb.append(" password");
            if(sb.charAt(sb.length() - 1) == ','){
                sb.setCharAt(sb.length() - 1, ' ');
            }
            resp.
                    getWriter().write("<h1 style=\\\"color: red\\\">\" + sb + \" is required\"  + \"</h1>\"");
            rd = req.getRequestDispatcher(RegisterController.BASE_PAGE);
            rd.include(req,resp);

        }else {
            if(!Objects.equals(user.getPasswordConfirm(), user.getPassword())){
                resp.
                        getWriter().write("<h1 style=\\\"color: red\\\">Password doesn't match</h1>");
                rd = req.getRequestDispatcher(RegisterController.BASE_PAGE);
                rd.include(req,resp);
            }
            else {

                RegisterService registerService = RegisterService.getInstance();
                boolean isRegistered = registerService.register(user);
            }

        }

    }

}