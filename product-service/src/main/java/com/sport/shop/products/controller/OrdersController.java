package com.sport.shop.products.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("v1/sport/orders")
public class OrdersController {

    @GetMapping
    public List<String> getOrders(){
        String[] orders = {"Order1","Order2","Order3"};
        return Arrays.asList(orders);
    }

    @PostMapping("v1/sport/orderes")
    public ResponseEntity<?> putOrder(){
        return null;
    }
}
