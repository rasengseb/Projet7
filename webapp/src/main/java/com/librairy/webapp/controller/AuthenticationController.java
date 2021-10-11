package com.librairy.webapp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.librairy.webapp.model.JwtRequest;
import com.librairy.webapp.model.JwtResponse;
import com.librairy.webapp.service.AuthenticationService;
import com.librairy.webapp.service.LendingService;
import com.librairy.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Base64;

@Controller
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserService userService;

    @Autowired
    private LendingService lendingService;


    @PostMapping("/authenticate")
    private String connexion(@ModelAttribute JwtRequest authenticationRequest, HttpSession session, Model model) throws JsonProcessingException {
        JwtResponse response = new JwtResponse(authenticationService.authenticate(authenticationRequest));

        String [] chunks = response.getJwttoken().split("\\.");
        Base64.Decoder decoder = Base64.getDecoder();

        String header = new String(decoder.decode(chunks[0]));
        String payload = new String(decoder.decode(chunks[1]));
        System.out.println(response.getJwttoken());
        System.out.println(header);
        System.out.println(payload);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(payload);
        JsonNode idNode = rootNode.path("id");
        System.out.println("id = " + idNode.asInt());


        session.setAttribute("id", idNode.asInt());
        session.setAttribute("token", response.getJwttoken());

        model.addAttribute("user", userService.getUser(response.getJwttoken(), idNode.asInt()));
        model.addAttribute("lendings", lendingService.findLendingByUser(response.getJwttoken(), idNode.asInt()));
        return "profile";
    }
}
