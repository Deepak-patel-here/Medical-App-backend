package com.deepakbackend.Medical_Management.repository;

import com.deepakbackend.Medical_Management.model.SellHistoryModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellHistoryRepository extends MongoRepository<SellHistoryModel,String> {
    public List<SellHistoryModel> findSellHistoryByUserEmail(String userEmail);
    public SellHistoryModel findSellHistoryBySellId(String sellId);
    public void deleteBySellId(String sellId);
}
