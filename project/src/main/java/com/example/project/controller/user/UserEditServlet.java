package com.example.project.controller.user;

import com.example.project.controller.BaseController;
import com.example.project.entity.User;
import com.example.project.dao.daoImpl.UserDaoImpl;
import com.example.project.service.ServiceFactory;
import com.example.project.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserEditServlet", value = "/userEdit")
public class UserEditServlet extends BaseController {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            ServiceFactory factory = getServiceFactory();
            UserService service = factory.userServiceInstance();

            Long id = Long.parseLong(request.getParameter("id"));

            User editUser=service.findById(id);
            request.setAttribute("editUser", editUser);
        } catch(NumberFormatException e) {

        }
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/user/userEdit.jsp")
                .forward(request, response);
    }
}
