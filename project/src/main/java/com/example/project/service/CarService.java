package com.example.project.service;

import com.example.project.entity.Car;

import java.util.List;

public interface CarService extends BaseService<Car>{
    public void changeAvailability(Car car, Boolean available);
}
