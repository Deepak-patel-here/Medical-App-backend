package com.deepakbackend.Medical_Management.service;

import com.deepakbackend.Medical_Management.model.UserModel;
import com.deepakbackend.Medical_Management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserModel userModel= userRepository.findByEmail(email);
        if(userModel==null) throw new RuntimeException("user not found");
        if (!userModel.getApproved()) {
            throw new RuntimeException("Account not yet approved by admin.");
        }
        return new UserPrinciple(userModel);
    }
}
