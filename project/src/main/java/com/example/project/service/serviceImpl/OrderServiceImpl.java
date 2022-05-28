package com.example.project.service.serviceImpl;

import com.example.project.dao.OrderDao;
import com.example.project.dao.daoImpl.CarDaoImpl;
import com.example.project.entity.Car;
import com.example.project.entity.Order;
import com.example.project.service.OrderService;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public Order findById(Long id) {
        return orderDao.read(id);
    }

    @Override
    public List<Order> findAll() {
        return orderDao.readAll();
    }

    @Override
    public void save(Order order) throws SQLException {
        CarDaoImpl carDao = new CarDaoImpl();
        List<Order> orders= orderDao.readAll();
        Car car= carDao.read(order.getCar_id());

        if(order.getStatus().equals("ok")){
            carDao.changeAvailability(car, false);
        }

        order.setCarDayPrice(car.getDayPrice());
        order.setCost();

        if(!orders.stream().anyMatch(u-> Objects.equals(u.getId(), order.getId()))){
            orderDao.create(order);
        }else{
            orderDao.update(order);
        }
    }

    @Override
    public void delete(Long id) throws SQLException {
        orderDao.delete(id);
    }


    @Override
    public List<Order> findByUserConfirmed(Long user_id) {
        return orderDao.readByUserConfirmed(user_id);
    }

    @Override
    public List<Order> findByUserRejected(Long user_id) {
        return orderDao.readByUserRejected(user_id);
    }

    @Override
    public List<Order> findByUserUnchecked(Long user_id) {
        return orderDao.readByUserUncheked(user_id);
    }
}
