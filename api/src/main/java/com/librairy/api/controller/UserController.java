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

    /**
     * Cherche un User
     * @param id User cherché
     * @return User
     */
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") int id){
        return userService.getUser(id);
    }

    /**
     * Enregistre un User
     * @param user à enregistrer
     * @return User enregistré
     */
    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        if(!userService.doublonCheck(user)){
            return null;
        } else {
            return userService.saveUser(user);
        }
    }

    /**
     * Mise à jour d'un User
     * @param id User dans la BDD
     * @param user nouveau
     * @return User nouveau
     */
    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable("id") int id, @RequestBody User user){
        User u = userService.getUser(id);
        if (u != null){
            User currentUser = u;

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

    /**
     * Supprime un User
     * @param id User à supprimer
     */
    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
    }
}
