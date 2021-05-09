package com.librairy.api.controller;

import com.librairy.api.service.LendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LendingController {

    @Autowired
    private LendingService lendingService;
}
