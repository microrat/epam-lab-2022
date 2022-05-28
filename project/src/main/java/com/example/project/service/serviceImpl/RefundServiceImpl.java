package com.example.project.service.serviceImpl;

import com.example.project.dao.OrderDao;
import com.example.project.dao.RefundDao;
import com.example.project.dao.daoImpl.CarDaoImpl;
import com.example.project.dao.daoImpl.OrderDaoImpl;
import com.example.project.entity.Car;
import com.example.project.entity.Order;
import com.example.project.entity.Refund;
import com.example.project.service.RefundService;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class RefundServiceImpl implements RefundService {

    private RefundDao refundDao;

    public RefundDao getRefundDao() {
        return refundDao;
    }

    public void setRefundDao(RefundDao refundDao) {
        this.refundDao = refundDao;
    }

    @Override
    public Refund findById(Long id) {
        return refundDao.read(id);
    }

    @Override
    public List<Refund> findAll() {
        return refundDao.readAll();
    }

    @Override
    public void save(Refund refund) throws SQLException {
        List<Refund> refunds= refundDao.readAll();

        OrderDaoImpl orderDao = new OrderDaoImpl();
        Order order = orderDao.read(refund.getOrder_id());

        CarDaoImpl carDao = new CarDaoImpl();
        Car car= carDao.read(order.getCar_id());

        if(refund.getRepair()==0.0){
            carDao.changeAvailability(car, true);
            try {
                orderDao.delete(order.getId());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(!refunds.stream().anyMatch(u-> Objects.equals(u.getId(), refund.getId()))){
            refundDao.create(refund);
        }
        else {
            try {
                refundDao.update(refund);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void delete(Long id) throws SQLException {
        refundDao.delete(id);
    }
}
