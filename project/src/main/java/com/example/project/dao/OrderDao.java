package com.example.project.dao;

import com.example.project.entity.Order;

import java.util.List;

public interface OrderDao extends Dao<Order> {
    List<Order> readByUserConfirmed(Long user_id);
    List<Order> readByUserRejected(Long user_id);
    List<Order> readByUserUncheked(Long user_id);
}
