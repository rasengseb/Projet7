package com.librairy.api.controller;

import com.librairy.api.service.LibrairyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibrairyController {

    @Autowired
    private LibrairyService librairyService;
}
