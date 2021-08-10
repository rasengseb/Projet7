package com.librairy.webapp.controller;

import com.librairy.webapp.model.Lending;
import com.librairy.webapp.service.LendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LendingController {

    @Autowired
    private LendingService lendingService;

    @GetMapping("/lending")
    public String Lendings(Model model){
        Iterable<Lending> listLending = lendingService.getLendings();
        model.addAttribute("lendings", listLending);

        return "listLending";
    }

}
