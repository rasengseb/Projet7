package com.librairy.api.controller;

import com.librairy.api.service.CopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CopyController {

    @Autowired
    private CopyService copyService;
}
