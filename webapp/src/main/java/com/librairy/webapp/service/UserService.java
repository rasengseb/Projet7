package com.librairy.webapp.service;

import com.librairy.webapp.model.User;
import com.librairy.webapp.proxy.UserProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserProxy userProxy;

    public User saveUser(User user){
        User savedUser = userProxy.saveUser(user);
        return savedUser;
    }
}
