package com.example.project.service;

import com.example.project.entity.Order;

import java.util.List;

public interface OrderService extends BaseService<Order>{
    List<Order> findByUserConfirmed(Long user_id);
    List<Order> findByUserRejected(Long user_id);
    List<Order> findByUserUnchecked(Long user_id);
}
