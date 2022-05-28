package com.example.project.controller.refund;

import com.example.project.controller.BaseController;
import com.example.project.dao.daoImpl.CarDaoImpl;
import com.example.project.dao.daoImpl.OrderDaoImpl;
import com.example.project.dao.daoImpl.RefundDaoImpl;
import com.example.project.entity.Car;
import com.example.project.entity.Order;
import com.example.project.entity.Refund;
import com.example.project.service.RefundService;
import com.example.project.service.ServiceFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "RefundSaveServlet", value = "/refundSave")
public class RefundSaveServlet extends BaseController {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceFactory factory= getServiceFactory();
        RefundService service= factory.refundServiceInstance();

        Refund refund = new Refund();
        refund.setId(Long.valueOf(request.getParameter("id")));
        refund.setOrder_id(Long.valueOf(request.getParameter("order_id")));
        refund.setDamage(request.getParameter("damage"));
        refund.setRepair(Float.valueOf(request.getParameter("repair")));

        try {
            service.save(refund);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect(request.getContextPath() + "/refundList");
    }
}
