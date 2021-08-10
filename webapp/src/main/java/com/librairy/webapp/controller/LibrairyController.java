package com.librairy.webapp.controller;

import com.librairy.webapp.model.Librairy;
import com.librairy.webapp.service.LibrairyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LibrairyController {

    @Autowired
    private LibrairyService librairyService;

    @GetMapping("/librairy")
    public String librairies(Model model){
        Iterable<Librairy> listLibrairy = librairyService.getLibrairies();
        model.addAttribute("librairies", listLibrairy);

        return "listLibrairy";
    }
}
