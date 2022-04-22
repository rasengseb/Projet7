package com.librairy.webapp.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.librairy.webapp.model.User;
import com.librairy.webapp.proxy.UserProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserProxy userProxy;

    /**
     * Enregistre un User
     * @param user à enregistrer
     * @return User enregistré
     */
    public User createUser(User user){
        User savedUser = userProxy.createUser(user);
        return savedUser;
    }

    /**
     * Récupère un User
     * @param token sécurité
     * @param id User
     * @return User
     */
    public User getUser(String token, int id){
        return userProxy.getUser(token, id);
    }
}
