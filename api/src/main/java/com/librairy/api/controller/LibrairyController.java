package com.librairy.api.controller;

import com.librairy.api.model.Librairy;
import com.librairy.api.service.LibrairyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class LibrairyController {

    @Autowired
    private LibrairyService librairyService;

    @GetMapping("/librairy/{id}")
    public Optional<Librairy> getLibrairy(@PathVariable("id") int id){
        return librairyService.getLibrairy(id);
    }

    @GetMapping("/librairy")
    public Iterable<Librairy> getLibrayries(){
        return librairyService.getLibrairy();
    }

    @PostMapping("/librairy")
    public Librairy createLibrairy(@RequestBody Librairy librairy){
        return librairyService.saveLibrairy(librairy);
    }

    @PutMapping("/librairy/{id}")
    public Librairy updateLibrairy(@PathVariable("id") int id, @RequestBody Librairy librairy){
        Optional<Librairy> l = librairyService.getLibrairy(id);
        if(l.isPresent()){
            Librairy currentLibrairy = l.get();

            String name = librairy.getName();
            if(name != null){
                currentLibrairy.setName(name);
            }
            String adresse = librairy.getAdresse();
            if(adresse != null){
                currentLibrairy.setAdresse(adresse);
            }

            librairyService.saveLibrairy(currentLibrairy);
            return currentLibrairy;
        }
        else{
            return null;
        }
    }

    @DeleteMapping("librairy/{id}")
    public void deleteLibrairy (@PathVariable("id") int id){
        librairyService.deleteLibrairy(id);
    }
}
