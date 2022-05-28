package com.example.project.controller.refund;

import com.example.project.controller.BaseController;
import com.example.project.service.RefundService;
import com.example.project.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "RefundDeleteServlet", value = "/refundDelete")
public class RefundDeleteServlet extends BaseController {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        for (String id : request.getParameterValues("id")) {
            try {
                ServiceFactory factory = getServiceFactory();
                RefundService service = factory.refundServiceInstance();
                service.delete(Long.valueOf(id));
            } catch (NumberFormatException e) {

            } catch (SQLException e) {
                throw new ServletException(e);

            }
        }
        response.sendRedirect(request.getContextPath() + "/refundList");
    }
}