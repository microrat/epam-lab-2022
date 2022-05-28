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
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "CarSaveServlet", value = "/carSave")
public class CarSaveServlet extends BaseController {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServiceFactory factory=getServiceFactory();
        CarService service=factory.carServiceInstance();

        Car car = new Car();
        car.setId(Long.valueOf(request.getParameter("id")));
        car.setBrand(request.getParameter("brand"));
        car.setModel(request.getParameter("model"));
        car.setAvailable(Boolean.valueOf(request.getParameter("available")));
        car.setDayPrice(Float.valueOf(request.getParameter("day_price")));

        try {
            service.save(car);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect(request.getContextPath() + "/carList");
    }
}