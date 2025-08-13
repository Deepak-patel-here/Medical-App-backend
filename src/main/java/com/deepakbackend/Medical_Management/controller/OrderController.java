package com.deepakbackend.Medical_Management.controller;

import com.deepakbackend.Medical_Management.model.OrderModel;
import com.deepakbackend.Medical_Management.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/orderByid")
    public ResponseEntity<?> getOrdersByEmail(@RequestBody String email){
        return ResponseEntity.ok(orderService.getOrderByEmail(email));
    }

    @PostMapping("/addOrder")
    public ResponseEntity<?> addOrder(@RequestBody OrderModel order){
        return ResponseEntity.ok( orderService.addOrder(order));
    }

    @PostMapping("/updateOrder")
    public ResponseEntity<?> updateOrder(@RequestBody OrderModel order){
        return ResponseEntity.ok(orderService.updateOrder(order));
    }

    @GetMapping("/deleteOrder/{orderId}")
    public ResponseEntity<?> deleteOrder(@PathVariable String orderId){
        return ResponseEntity.ok(orderService.deleteOrder(orderId));
    }

    @GetMapping("/getOrders")
    public ResponseEntity<?> getAllOrder(){
        return ResponseEntity.ok(orderService.getAllOrder());
    }
}
