package com.app.demospringbootregistrationform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demospringbootregistrationform.entity.User;
import com.app.demospringbootregistrationform.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo repo;
    @Override
    public void registeruser(User user) {
        repo.save(user);
    }
    
    
}
