package com.example.project.controller.refund;

import com.example.project.controller.BaseController;
import com.example.project.dao.daoImpl.OrderDaoImpl;
import com.example.project.dao.daoImpl.RefundDaoImpl;
import com.example.project.entity.Order;
import com.example.project.entity.Refund;
import com.example.project.service.RefundService;
import com.example.project.service.ServiceFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RefundEditServlet", value = "/refundEdit")
public class RefundEditServlet extends BaseController {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Long id = Long.parseLong(request.getParameter("id"));
            ServiceFactory factory = getServiceFactory();
            RefundService service = factory.refundServiceInstance();
            Refund editRefund=service.findById(id);
            request.setAttribute("editRefund", editRefund);

        } catch(NumberFormatException e) {

        }
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/refund/refundEdit.jsp")
                .forward(request, response);
    }
}