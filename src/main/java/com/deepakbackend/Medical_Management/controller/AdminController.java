package com.deepakbackend.Medical_Management.controller;

import com.deepakbackend.Medical_Management.model.UserModel;
import com.deepakbackend.Medical_Management.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserAuthService service;

    @GetMapping("/pending-users")
    public List<UserModel> getPendingUser(){
        return service.getPendingUser();
    }

    @PutMapping("/approved/{id}")
    public String approvedUser(@PathVariable String id){

        return service.approvedUser(id);
    }
}
