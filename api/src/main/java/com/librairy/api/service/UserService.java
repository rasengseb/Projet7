package com.librairy.api.service;

import com.librairy.api.model.User;
import com.librairy.api.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUser(int id){
        return userRepository.findById(id);
    }

    public Iterable<User> getUsers(){
        return userRepository.findAll();
    }

    public void deleteUser (int id){
        userRepository.deleteById(id);
    }

    public User saveUser(User user){
        User savedUser = userRepository.save(user);
        return savedUser;
    }
}
