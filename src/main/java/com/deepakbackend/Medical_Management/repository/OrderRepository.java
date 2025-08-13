package com.deepakbackend.Medical_Management.repository;

import com.deepakbackend.Medical_Management.model.OrderModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends MongoRepository<OrderModel,String> {

    public List<OrderModel> findOrderByUserEmail(String userEmail);
    public void deleteByOrderId(String orderId);
    public Optional<OrderModel> findOrderByOrderId(String orderId);
}
