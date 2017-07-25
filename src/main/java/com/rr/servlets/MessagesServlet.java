package com.rr.servlets;

import com.rr.servlets.model.ForumMessage;
import com.rr.servlets.model.ForumUser;
import com.rr.servlets.service.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "messagesS", urlPatterns = {"/messages", "/add"})
public class MessagesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!request.getRequestURI().equals("/messages"))
            doPost(request, response);

        List<ForumMessage> messages = new ArrayList<>(Utils.getInstance().getMessages());
        Collections.reverse(messages);
        request.setAttribute("messages", messages);
        request.getRequestDispatcher("forum.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ForumUser user = (ForumUser) request.getSession().getAttribute("user");
        String message = request.getParameter("msg");

        if (message != null && !message.trim().equals("")) {
            Utils.getInstance().addMessage(new ForumMessage(message, user));
        }

        if (request.getRequestURI().equals("/messages"))
            doGet(request, response);

        request.getRequestDispatcher("messages.jsp").forward(request, response);
    }
}
