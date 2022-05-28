package com.example.project.controller.order;

import com.example.project.controller.BaseController;
import com.example.project.dao.daoImpl.CarDaoImpl;
import com.example.project.dao.daoImpl.OrderDaoImpl;
import com.example.project.entity.Car;
import com.example.project.entity.Order;
import com.example.project.service.OrderService;
import com.example.project.service.ServiceFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "OrderSaveServlet", value = "/orderSave")
public class OrderSaveServlet extends BaseController {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceFactory factory = getServiceFactory();
        OrderService service = factory.orderServiceInstance();
        Order order = new Order();
        order.setId(Long.valueOf(request.getParameter("id")));
        order.setUser_id(Long.valueOf(request.getParameter("user_id")));
        order.setCar_id(Long.valueOf(request.getParameter("car_id")));
        order.setPassport(request.getParameter("passport"));
        order.setDateStart(Date.valueOf(request.getParameter("date_start")));
        order.setTerm(Integer.valueOf(request.getParameter("term")));
        order.setStatus(request.getParameter("status"));
        order.setRejectReason(request.getParameter("reject_reason"));

        try {
            service.save(order);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath() + "/orderList");
    }
}