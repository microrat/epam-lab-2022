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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "OrderEditServlet", value = "/orderEdit")
    public class OrderEditServlet extends BaseController {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            try {
                Long id = Long.parseLong(request.getParameter("id"));
                ServiceFactory factory=getServiceFactory();
                OrderService service= factory.orderServiceInstance();
                Order editOrder=service.findById(id);
                request.setAttribute("editOrder", editOrder);

            } catch(NumberFormatException e) {

            }
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/order/orderEdit.jsp")
                    .forward(request, response);
        }
    }