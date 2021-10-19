package com.librairy.api.service;

import com.librairy.api.model.User;
import com.librairy.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User getUser(String pseudo){
        return userRepository.findByPseudo(pseudo);
    }

    public User getUser(int id){
        return userRepository.findById(id).orElse(null);
    }

    public Iterable<User> getUsers(){
        return userRepository.findAll();
    }

    public void deleteUser (int id){
        userRepository.deleteById(id);
    }

    public User saveUser(User user){
        user.setMdp(passwordEncoder.encode(user.getMdp()));
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    public boolean doublonCheck (User user){
        if(userRepository.findByPseudo(user.getPseudo()) == null){
            return true;
        } else if(userRepository.findByMail(user.getMail()) == null){
            return true;
        } else{
            return false;
        }
    }
}
