package com.rr.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SettingsServlet", urlPatterns = {"/settings"})
public class SettingsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!request.getParameter("textcolor").equals("") && !request.getParameter("backcolor").equals("")) {
            request.getSession().setAttribute("textcolor", request.getParameter("textcolor"));
            request.getSession().setAttribute("backgroundcolor", request.getParameter("backcolor"));
            response.sendRedirect("/messages");
        }
    }
}
