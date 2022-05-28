package com.example.project.controller.car;

import com.example.project.controller.BaseController;
import com.example.project.dao.daoImpl.CarDaoImpl;
import com.example.project.dao.daoImpl.UserDaoImpl;
import com.example.project.entity.Car;
import com.example.project.entity.User;
import com.example.project.service.CarService;
import com.example.project.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CarEditServlet", value = "/carEdit")
public class CarEditServlet extends BaseController {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ServiceFactory factory = getServiceFactory();
            CarService service= factory.carServiceInstance();
            Long id = Long.parseLong(request.getParameter("id"));
            Car editCar=service.findById(id);
            request.setAttribute("editCar", editCar);
        } catch(NumberFormatException e) {

        }
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/car/carEdit.jsp")
                .forward(request, response);
    }
}