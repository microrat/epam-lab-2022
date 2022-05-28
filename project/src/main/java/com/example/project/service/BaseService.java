package com.example.project.service;

import com.example.project.entity.Car;
import com.example.project.entity.Entity;

import java.sql.SQLException;
import java.util.List;

public interface BaseService<T extends Entity> {
    T findById(Long id);
    List<T> findAll();
    void save(T car) throws SQLException;
    void delete(Long id) throws SQLException;
}
