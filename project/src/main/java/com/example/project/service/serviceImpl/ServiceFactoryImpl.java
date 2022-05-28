package com.example.project.service.serviceImpl;

import com.example.project.dao.CarDao;
import com.example.project.dao.OrderDao;
import com.example.project.dao.RefundDao;
import com.example.project.dao.UserDao;
import com.example.project.dao.daoImpl.CarDaoImpl;
import com.example.project.dao.daoImpl.OrderDaoImpl;
import com.example.project.dao.daoImpl.RefundDaoImpl;
import com.example.project.dao.daoImpl.UserDaoImpl;
import com.example.project.service.*;


public class ServiceFactoryImpl implements ServiceFactory {
    private CarDao carDao;
    private OrderDao orderDao;
    private UserDao userDao;
    private RefundDao refundDao;

    private RefundDao getRefundDao(){
        if(refundDao == null) {
            refundDao = new RefundDaoImpl();
        }
        return refundDao;
    }

    private UserDao getUserDao() {
        if(userDao == null) {
            userDao = new UserDaoImpl();
        }
        return userDao;
    }

    private CarDao getCarDao() {
        if(carDao == null) {
            carDao = new CarDaoImpl();
        }
        return carDao;
    }

    private OrderDao getOrderDao() {
        if(orderDao == null) {
            orderDao = new OrderDaoImpl();
        }
        return orderDao;
    }


    @Override
    public CarService carServiceInstance() {
        CarServiceImpl carService=new CarServiceImpl();
        carService.setCarDao(getCarDao());
        return carService;
    }

    @Override
    public OrderService orderServiceInstance() {
        OrderServiceImpl orderService=new OrderServiceImpl();
        orderService.setOrderDao(getOrderDao());
        return orderService;
    }

    @Override
    public UserService userServiceInstance() {
        UserServiceImpl userService=new UserServiceImpl();
        userService.setOrderDao(getUserDao());
        return userService;
    }

    @Override
    public RefundService refundServiceInstance() {
        RefundServiceImpl refundService=new RefundServiceImpl();
        refundService.setRefundDao(getRefundDao());
        return refundService;
    }

}
