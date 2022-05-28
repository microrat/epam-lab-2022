package com.example.project.controller.refund;

import com.example.project.controller.BaseController;
import com.example.project.dao.daoImpl.OrderDaoImpl;
import com.example.project.dao.daoImpl.RefundDaoImpl;
import com.example.project.entity.Order;
import com.example.project.entity.Refund;
import com.example.project.entity.User;
import com.example.project.service.RefundService;
import com.example.project.service.ServiceFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "RefundListServlet", value = "/refundList")
public class RefundListServlet extends BaseController {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            ServiceFactory factory = getServiceFactory();
            RefundService service = factory.refundServiceInstance();
            Collection<Refund> refunds= service.findAll();
            request.setAttribute("refunds", refunds);

            getServletContext().getRequestDispatcher("/WEB-INF/jsp/refund/refundList.jsp")
                    .forward(request, response);

        } catch (ServletException e) {
            e.printStackTrace();
        }


    }

    public void destroy() {
    }
}
