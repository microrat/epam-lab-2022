package com.example.project.controller;

import com.example.project.dbConnection;
import com.example.project.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MainPageServlet", value = "/")
public class MainPageServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        try {
            dbConnection.init();
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            User user = (User) session.getAttribute("session_user");
            if (user != null) {
                response.sendRedirect(request.getContextPath() + "/carList");
            }
        }
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp")
                .forward(request, response);
    }
}
