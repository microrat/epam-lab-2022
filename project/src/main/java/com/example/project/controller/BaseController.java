package com.example.project.controller;

import com.example.project.service.ServiceFactory;
import com.example.project.service.serviceImpl.ServiceFactoryImpl;

import javax.servlet.http.HttpServlet;

abstract public class BaseController extends HttpServlet {
    public ServiceFactory getServiceFactory() {
        return new ServiceFactoryImpl();
    }
}
