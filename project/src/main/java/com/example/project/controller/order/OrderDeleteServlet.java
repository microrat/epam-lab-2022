package com.example.project.controller.order;

import com.example.project.controller.BaseController;
import com.example.project.dao.daoImpl.CarDaoImpl;
import com.example.project.dao.daoImpl.OrderDaoImpl;
import com.example.project.service.OrderService;
import com.example.project.service.ServiceFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "OrderDeleteServlet", value = "/orderDelete")
public class OrderDeleteServlet extends BaseController {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceFactory factory = getServiceFactory();
        OrderService service = factory.orderServiceInstance();

        Long id = Long.valueOf(request.getParameter("id"));
        try {
            service.delete(id);
        } catch (NumberFormatException e) {

        } catch (SQLException e) {
            throw new ServletException(e);

        }

        response.sendRedirect(request.getContextPath() + "/orderList");
    }
}