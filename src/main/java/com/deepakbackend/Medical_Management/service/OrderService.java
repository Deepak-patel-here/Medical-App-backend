package com.deepakbackend.Medical_Management.service;

import com.deepakbackend.Medical_Management.model.OrderModel;
import com.deepakbackend.Medical_Management.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    public List<OrderModel> getAllOrder(){
        return orderRepository.findAll();
    }


    public List<OrderModel> getOrderByEmail(String email){
        return  orderRepository.findOrderByUserEmail(email);
    }

    public OrderModel updateOrder(OrderModel newOrder){
        OrderModel oldOrder=orderRepository.findById(newOrder.getId()).orElseThrow();

        oldOrder.setOrderId(newOrder.getOrderId());
        oldOrder.setUserEmail(newOrder.getUserEmail());
        oldOrder.setProductId(newOrder.getProductId());
        oldOrder.setApproved(newOrder.isApproved());
        oldOrder.setQuantity(newOrder.getQuantity());
        oldOrder.setDateOfOrderCreated(newOrder.getDateOfOrderCreated());
        oldOrder.setPrice(newOrder.getPrice());
        oldOrder.setProductName(newOrder.getProductName());
        oldOrder.setMessage(newOrder.getMessage());
        oldOrder.setCategory(newOrder.getCategory());

        return  orderRepository.save(oldOrder);
    }

    public OrderModel addOrder(OrderModel order){
        if(order==null){
            throw new RuntimeException("order is null");
        }
        return orderRepository.save(order);
    }

    public String deleteOrder(String orderId){
        orderRepository.deleteByOrderId(orderId);
        Optional<OrderModel> order=orderRepository.findOrderByOrderId(orderId);
        if(order.isEmpty()){
            return "Deleted Successfully";
        }else return "Deletion failed";
    }

}
