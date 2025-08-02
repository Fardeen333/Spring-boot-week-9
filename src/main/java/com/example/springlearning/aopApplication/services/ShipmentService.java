package com.example.springlearning.aopApplication.services;

public interface ShipmentService {

    String orderPackage(Long orderId);

    String trackPackage(Long orderId);
}
