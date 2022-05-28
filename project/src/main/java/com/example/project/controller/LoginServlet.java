package com.example.project.controller;

import com.example.project.dao.daoImpl.UserDaoImpl;
import com.example.project.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (login != null && password != null) {
            try {
                UserDaoImpl userDao = new UserDaoImpl();
                User user = userDao.readByLoginAndPassword(login, password);
                if (user != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("session_user", user);
                    response.sendRedirect(request.getContextPath() + "/carList");
                } else {
                    getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp")
                            .forward(request, response);
                }

            } catch (ServletException e) {
                e.printStackTrace();
            }
        }
    }
}