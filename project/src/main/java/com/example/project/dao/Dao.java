package com.example.project.dao;

import com.example.project.entity.Entity;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T extends Entity> {
    void create(T entity);

    T read(Long id);

    List readAll();

    void update(T entity) throws SQLException;

    void delete(Long id) throws SQLException;
}

