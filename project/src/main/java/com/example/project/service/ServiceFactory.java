package com.example.project.service;

public interface  ServiceFactory {
    CarService carServiceInstance();
    OrderService orderServiceInstance();
    UserService userServiceInstance();
    RefundService refundServiceInstance();
}
