package com.company.controller;

import com.company.model.Pet;
import com.company.service.BidService;
import com.company.utils.AppConst;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Objects;

@WebServlet(value = BidController.BASE_PATH)
public class BidController extends HttpServlet {

    public static final String BASE_PATH = "/bid";
    private static final String BASE_PAGE = "bid.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Cookie[] cookies = req.getCookies();
//        boolean isAuthorized = false;
//        if (Objects.nonNull(cookies))
//            for (Cookie cookie : cookies) {
//                if (Objects.equals(cookies.getClass(), "petName")) {
//                    isAuthorized = true;
//                    break;
//                }
//                if(isAuthorized)
//                    resp.sendRedirect("cabinet.jsp");
//                else resp.sendRedirect("bid.jsp");
//               // resp.sendRedirect(isAuthorized ? "cabinet.jsp" : "bid.jsp");
//            }
        resp.sendRedirect("bid.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        Pet pet = Pet.builder()
                .pet(req.getParameter("pet"))
                .petName(req.getParameter("petName"))
                .petService(req.getParameter("petService"))
                .build();
        RequestDispatcher requestDispatcher;

        if (Objects.isNull(req.getParameter("pet")) || req.getParameter("pet").isBlank() ||
                Objects.isNull(req.getParameter("petName")) || req.getParameter("petName").isBlank()
                || Objects.isNull(req.getParameter("serviceName")) || req.getParameter("serviceName").isBlank()) {

            StringBuilder sb = new StringBuilder();

            if (Objects.isNull(req.getParameter("pet")) || req.getParameter("pet").isBlank())
                sb.append("Pet,");
            if (Objects.isNull(req.getParameter("petName")) || req.getParameter("petName").isBlank())
                sb.append(" pet pet, ");
            if (Objects.isNull(req.getParameter("serviceName")) || req.getParameter("serviceName").isBlank())
                sb.append(" service name");
            if (sb.charAt(sb.length() - 1) == ',') {
                sb.setCharAt(sb.length() - 1, ' ');
            }
            resp
                    .getWriter()
                    .write("<h1 style=\\\"color: green\\\">\" + sb + \"</h1>");
            requestDispatcher = req.getRequestDispatcher(BidController.BASE_PAGE);
            requestDispatcher.include(req, resp);

        } else {

            BidService bidService = BidService.getInstance();
            boolean isBidRegistered = bidService.bid(pet);

            if(isBidRegistered){
                HttpSession session = req.getSession();
                session.setAttribute(AppConst.CURRENT_PET, pet);
                resp.sendRedirect("/bid-register-successful.jsp");
            }
            else {
                resp.
                        getWriter()
                        .write("<div align=\\\"center\\\"> <h1 style=\\\"color: green\\\">Pat already exists/h1>  </div>\"");
                requestDispatcher = req.getRequestDispatcher("bid.jsp");
                requestDispatcher.include(req, resp);
            }

        }
    }
}
