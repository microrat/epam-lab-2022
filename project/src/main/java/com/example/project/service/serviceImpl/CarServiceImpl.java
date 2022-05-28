package com.example.project.service.serviceImpl;

import com.example.project.dao.CarDao;
import com.example.project.entity.Car;
import com.example.project.service.CarService;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class CarServiceImpl implements CarService {

    private CarDao carDao;

    public CarDao getCarDao() {
        return carDao;
    }

    public void setCarDao(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public Car findById(Long id) {
        return carDao.read(id);
    }

    @Override
    public List<Car> findAll() {
        return carDao.readAll();
    }

    @Override
    public void save(Car car) throws SQLException {
        List<Car> cars= carDao.readAll();
        if(!cars.stream().anyMatch(u-> Objects.equals(u.getId(), car.getId()))){
            carDao.create(car);
        }else{
            carDao.update(car);
        }
    }

    @Override
    public void delete(Long id) throws SQLException {
        carDao.delete(id);
    }

    @Override
    public void changeAvailability(Car car, Boolean available) {
        carDao.changeAvailability(car,available);
    }
}
