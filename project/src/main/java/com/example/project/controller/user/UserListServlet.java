package com.example.project.controller.user;

import com.example.project.controller.BaseController;
import com.example.project.entity.User;
import com.example.project.dao.daoImpl.UserDaoImpl;
import com.example.project.dbConnection;
import com.example.project.service.ServiceFactory;
import com.example.project.service.UserService;

import java.io.*;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "UserListServlet", value = "/userList")
public class UserListServlet extends BaseController {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {

            ServiceFactory factory = getServiceFactory();
            UserService service = factory.userServiceInstance();

            Collection<User> users= service.findAll();
            request.setAttribute("users", users);
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/user/userList.jsp")
                    .forward(request, response);

        } catch (ServletException e) {
            e.printStackTrace();
        }


    }

    public void destroy() {
    }
}