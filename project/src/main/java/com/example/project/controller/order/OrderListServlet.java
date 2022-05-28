package com.example.project.controller.order;

import com.example.project.controller.BaseController;
import com.example.project.dao.daoImpl.CarDaoImpl;
import com.example.project.dao.daoImpl.OrderDaoImpl;
import com.example.project.entity.Car;
import com.example.project.entity.Order;
import com.example.project.entity.User;
import com.example.project.service.OrderService;
import com.example.project.service.ServiceFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "OrderListServlet", value = "/orderList")
public class OrderListServlet extends BaseController {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            ServiceFactory factory = getServiceFactory();
            OrderService service = factory.orderServiceInstance();

            Collection<Order> orders= service.findAll();
            request.setAttribute("orders", orders);

            getServletContext().getRequestDispatcher("/WEB-INF/jsp/order/orderList.jsp")
                    .forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
    public void destroy() {
    }
}
