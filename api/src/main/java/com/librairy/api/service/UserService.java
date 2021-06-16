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
        user.setMdp(passwordEncoder.encode(user.getMdp()));
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    public boolean doublonCheck (User user){
        if(userRepository.findByPseudo(user.getPseudo()) == null){
            return false;
        } else if(userRepository.findByMail(user.getMail()) == null){
            return false;
        } else{
            return true;
        }
    }
}
