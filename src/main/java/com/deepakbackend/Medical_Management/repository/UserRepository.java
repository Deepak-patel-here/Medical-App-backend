package com.deepakbackend.Medical_Management.repository;

import com.deepakbackend.Medical_Management.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<UserModel,String> {
    public UserModel findByEmail(String userName);
    public List<UserModel> findByIsApprovedFalse();
}
