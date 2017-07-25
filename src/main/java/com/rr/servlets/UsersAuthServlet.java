package com.rr.servlets;

import com.rr.servlets.model.ForumUser;
import com.rr.servlets.service.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AuthServlet", urlPatterns = {"/login", "/logout", "/registration"})
public class UsersAuthServlet extends HttpServlet {

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getRequestURI();
        String userName = request.getParameter("uname");
        String userPassword = request.getParameter("pswrd");

        ForumUser forumUser = new ForumUser(userName, userPassword);
        switch(action) {
            case "/login":
                if (Utils.getInstance().isUserExists(forumUser)) {
                    request.getSession().setAttribute("user", forumUser);
                    response.sendRedirect("/messages");
                    //this.getServletContext().getRequestDispatcher("/messages").forward(request, response);
                }
                else {
                    response.sendRedirect("login.html");
                }
                break;
            case "/logout":
                HttpSession currentSession = request.getSession();
                if (currentSession != null) {
                    synchronized (currentSession) {
                        currentSession.invalidate();
                        response.sendRedirect("welcome.html");
                    }
                }
                break;
            case "/registration":
                if (Utils.getInstance().isUserExists(forumUser)) {
                    response.sendRedirect("registration.html");
                }
                else {
                    Utils.getInstance().addUser(forumUser);
                    request.getSession().setAttribute("user", forumUser);
                    response.sendRedirect("/messages");
                }
                break;
            default:
                System.out.println("WTF??");
        }
    }
}
