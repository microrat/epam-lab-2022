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

@WebServlet(name = "UserOrderServlet", value = "/userOrder")
public class UserOrderServlet extends BaseController {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            HttpSession session = request.getSession(false);
            User user = (User) session.getAttribute("session_user");

            ServiceFactory factory = getServiceFactory();
            OrderService service = factory.orderServiceInstance();

            Collection<Order> ordersConfirmed= service.findByUserConfirmed(user.getId());
            Collection<Order> ordersRejected= service.findByUserRejected(user.getId());
            Collection<Order> orders= service.findByUserUnchecked(user.getId());
            request.setAttribute("ordersConfirmed", ordersConfirmed);
            request.setAttribute("ordersRejected", ordersRejected);
            request.setAttribute("orders", orders);

            getServletContext().getRequestDispatcher("/WEB-INF/jsp/order/userOrder.jsp")
                    .forward(request, response);

        } catch (ServletException e) {
            e.printStackTrace();
        }


    }

    public void destroy() {
    }
}
