package com.deepakbackend.Medical_Management.controller;

import com.deepakbackend.Medical_Management.model.UserLoginModel;
import com.deepakbackend.Medical_Management.model.UserModel;
import com.deepakbackend.Medical_Management.model.UserModelMapping;
import com.deepakbackend.Medical_Management.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserAuthService service;



    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserModelMapping userModelMapping){
        return ResponseEntity.ok(service.registerUser(userModelMapping));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginModel userLoginModel){
        return ResponseEntity.ok(Map.of("token",service.loginUser(userLoginModel)));
    }

}
