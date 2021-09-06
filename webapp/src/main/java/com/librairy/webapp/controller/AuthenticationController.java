package com.librairy.webapp.controller;

import com.librairy.webapp.model.JwtRequest;
import com.librairy.webapp.model.JwtResponse;
import com.librairy.webapp.service.AuthenticationService;
import com.librairy.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserService userService;

    @PostMapping("/authenticate")
    private String connexion(@RequestBody JwtRequest authenticationRequest){
        JwtResponse response = authenticationService.authenticate(authenticationRequest);
        System.out.println(response.getToken());
        return "home";
    }
}
