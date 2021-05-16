package com.librairy.api.controller;

import com.librairy.api.model.Copy;
import com.librairy.api.service.CopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.ExcludeDefaultListeners;
import java.util.Optional;

@RestController
public class CopyController {

    @Autowired
    private CopyService copyService;

    @GetMapping("/copy/{id}")
    public Optional<Copy> getCopy(@PathVariable("id") final Long id) {
        return copyService.getCopy(id);
    }

    @PostMapping("/copy")
    public Copy createCopy(@RequestBody Copy copy) {
        return copyService.saveCopy(copy);
    }

    @DeleteMapping("/copy/{id}")
    public void deleteCopy(@PathVariable("id") final Long id){
        copyService.deleteCopy(id);
    }

}
