package com.example.project.controller.car;

import com.example.project.controller.BaseController;
import com.example.project.dao.daoImpl.CarDaoImpl;
import com.example.project.dao.daoImpl.UserDaoImpl;
import com.example.project.dbConnection;
import com.example.project.entity.Car;
import com.example.project.entity.User;
import com.example.project.service.CarService;
import com.example.project.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "CarListServlet", value = "/carList" )
public class CarListServlet extends BaseController {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {

            ServiceFactory factory = getServiceFactory();
            CarService service = factory.carServiceInstance();

            Collection<Car> cars= service.findAll();

            request.setAttribute("cars", cars);
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/car/carList.jsp")
                    .forward(request, response);

        } catch (ServletException e) {
            e.printStackTrace();
        }


    }

    public void destroy() {
    }
}