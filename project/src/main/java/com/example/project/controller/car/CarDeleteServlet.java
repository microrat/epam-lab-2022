package com.example.project.controller.car;

import com.example.project.controller.BaseController;
import com.example.project.dao.daoImpl.CarDaoImpl;
import com.example.project.dao.daoImpl.UserDaoImpl;
import com.example.project.service.CarService;
import com.example.project.service.ServiceFactory;
import com.example.project.service.serviceImpl.CarServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CarDelete", value = "/carDelete")
public class CarDeleteServlet extends BaseController {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        for(String id : request.getParameterValues("id")) {
            try {
                ServiceFactory factory = getServiceFactory();
                CarService service = factory.carServiceInstance();
                service.delete(Long.parseLong(id));
            } catch(NumberFormatException e) {
            } catch(SQLException e) {
                throw new ServletException(e);

            }
        }
        response.sendRedirect(request.getContextPath() + "/carList");
    }
}
