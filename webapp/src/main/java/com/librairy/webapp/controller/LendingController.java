package com.librairy.webapp.controller;

import com.librairy.webapp.model.Lending;
import com.librairy.webapp.service.LendingService;
import com.librairy.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LendingController {

    @Autowired
    private LendingService lendingService;

    @Autowired
    private UserService userService;


    @GetMapping("/lending")
    public String Lendings(Model model){
        Iterable<Lending> listLending = lendingService.getLendings();
        model.addAttribute("lendings", listLending);

        return "listLending";
    }

    @PostMapping("/lending/{id}")
    public String extendLending(HttpSession session, Model model, @PathVariable("id") int id){
        lendingService.extend(session.getAttribute("token").toString(), id);

        model.addAttribute("user", userService.getUser(session.getAttribute("token").toString(), Integer.parseInt(session.getAttribute("id").toString())));
        model.addAttribute("lendings", lendingService.findLendingByUser(session.getAttribute("token").toString(), Integer.parseInt(session.getAttribute("id").toString())));
        return "profile";
    }

}
