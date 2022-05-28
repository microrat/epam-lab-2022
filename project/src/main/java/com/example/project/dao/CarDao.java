package com.example.project.dao;

import com.example.project.entity.Car;

public interface CarDao extends Dao<Car>{
    public void changeAvailability(Car car, Boolean available);
}
