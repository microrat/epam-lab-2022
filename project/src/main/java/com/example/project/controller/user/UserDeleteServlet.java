package com.example.project.controller.user;

import com.example.project.controller.BaseController;
import com.example.project.dao.daoImpl.UserDaoImpl;
import com.example.project.service.ServiceFactory;
import com.example.project.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UserDelete", value = "/userDelete")
public class UserDeleteServlet extends BaseController {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        for(String id : request.getParameterValues("id")) {
            try {
                ServiceFactory factory = getServiceFactory();
                UserService service = factory.userServiceInstance();

                service.delete(Long.parseLong(id));
            } catch(NumberFormatException e) {

            } catch(SQLException e) {
                throw new ServletException(e);

            }
        }
        response.sendRedirect(request.getContextPath() + "/userList");
    }
}
