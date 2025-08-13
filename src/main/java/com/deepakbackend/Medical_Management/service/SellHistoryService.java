package com.deepakbackend.Medical_Management.service;

import com.deepakbackend.Medical_Management.model.SellHistoryModel;
import com.deepakbackend.Medical_Management.repository.SellHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class SellHistoryService {

    @Autowired
    private SellHistoryRepository repository;

    public SellHistoryModel createSellHistory(SellHistoryModel model){
        return repository.save(model);
    }

    public List<SellHistoryModel> getSellHistoryByEmail(String email){
        return repository.findSellHistoryByUserEmail(email);
    }

    public SellHistoryModel updateSellHistory(SellHistoryModel model){
        SellHistoryModel model2=repository.findSellHistoryBySellId(model.getSellId());
        if(model2==null){
            throw new RuntimeException("No sell history found");
        }
        model2.setProductId(model.getProductId());
        model2.setQuantity(model.getQuantity());
        model2.setDateSell(model.getDateSell());
        model2.setAmount(model.getAmount());
        model2.setPrice(model.getPrice());
        model2.setProductName(model.getProductName());
        model2.setUserEmail(model.getUserEmail());
        model2.setUserName(model.getUserName());
        return repository.save(model2);
    }

    public String deleteHistory(String sellId){
        repository.deleteBySellId(sellId);

        return "Deletion successful";
    }
}
