package com.deepakbackend.Medical_Management.service;

import com.deepakbackend.Medical_Management.model.UserLoginModel;
import com.deepakbackend.Medical_Management.model.UserModel;
import com.deepakbackend.Medical_Management.model.UserModelMapping;
import com.deepakbackend.Medical_Management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class UserAuthService {
    @Autowired
    private UserRepository repository;
    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(10);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    public String registerUser(UserModelMapping userModelMapping){
        UserModel user=new UserModel(
                UUID.randomUUID().toString(),
                userModelMapping.getUserName(),
                userModelMapping.getEmail(),
                encoder.encode( userModelMapping.getPassword()),
                userModelMapping.getPhoneNumber(),
                userModelMapping.getPinCode(),
                userModelMapping.getAddress(),
                false,
                false,
                LocalDate.now()
        );
        repository.save(user);
        return "Registration submitted,waiting for approval";
    }

    public List<UserModel> getPendingUser(){
        return repository.findByIsApprovedFalse();
    }

    public String approvedUser(String id){
        UserModel userModel=repository.findById(id).orElseThrow(()->new RuntimeException("user not found"));
        userModel.setApproved(true);
        repository.save(userModel);
        return "User approved Successfully!";
    }

    public String loginUser(UserLoginModel userLoginModel){
        UserModel user=repository.findByEmail(userLoginModel.getEmail());
        if(user==null) throw new RuntimeException("User not found");
        if(!encoder.matches(userLoginModel.getPassword(),user.getPassword()))
            throw new RuntimeException("Invalid user name or password");
        if(!user.getApproved()) throw new RuntimeException("user is not approved yet! please try again later.");

        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userLoginModel.getEmail(),userLoginModel.getPassword()));

        if(authentication.isAuthenticated()){
            return jwtService.generateToken(userLoginModel.getEmail());
        }else return "failed";





    }

}
