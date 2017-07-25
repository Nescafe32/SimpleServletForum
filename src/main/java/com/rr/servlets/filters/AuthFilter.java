package com.rr.servlets.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter", urlPatterns = {"/messages", "/add", "*.jsp"})
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest) request).getSession();
        if (session != null && session.getAttribute("user") != null)
            chain.doFilter(request, response);
        else
            ((HttpServletResponse)response).sendRedirect("welcome.html");
    }

    @Override
    public void destroy() {
    }

}
