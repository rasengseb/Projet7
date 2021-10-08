package com.librairy.api.controller;

import com.librairy.api.model.User;
import com.librairy.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;

    @GetMapping("/user/{id}")
    public Optional<User> getUser(@PathVariable("id") int id){
        return userService.getUser(id);
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        if(!userService.doublonCheck(user)){
            return null;
        } else {
            return userService.saveUser(user);
        }
    }

    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable("id") int id, @RequestBody User user){
        Optional<User> u = userService.getUser(id);
        if (u.isPresent()){
            User currentUser = u.get();

            String firstName = user.getFirstName();
            if (firstName != null){
                currentUser.setFirstName(firstName);
            }

            String lastName = user.getLastName();
            if (lastName != null){
                currentUser.setLastName(lastName);
            }
            String mail = user.getMail();
            if(mail != null){
                currentUser.setMail(mail);
            }
            String mdp = user.getMdp();
            if(mdp != null){
                currentUser.setMdp(mdp);
            }

            String pseudo = user.getPseudo();
            if(pseudo != null){
                currentUser.setPseudo(pseudo);
            }

            userService.saveUser(currentUser);
            return currentUser;
        }
        else{
            return null;
        }
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
    }
}
