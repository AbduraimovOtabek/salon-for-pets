package com.company.filter;

import com.company.model.User;
import com.company.utils.AppConst;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

public class Authentication implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        HttpSession session = httpServletRequest.getSession(false);
        User user = session != null ? (User) session.getAttribute(AppConst.CURRENT_USER) : null;


        if (Objects.isNull(session) ||
                Objects.isNull(user)) {
            httpServletResponse.sendRedirect("/login");
            return;
        }
        chain.doFilter(request, response);
    }
}
