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

    /**
     * Cherche une Librairy
     * @param id Librairy
     * @return Librairy
     */
    @GetMapping("/librairy/{id}")
    public Optional<Librairy> getLibrairy(@PathVariable("id") int id){
        return librairyService.getLibrairy(id);
    }

    /**
     * Cherche toutes les Librairy
     * @return List Librairy
     */
    @GetMapping("/librairy")
    public Iterable<Librairy> getLibrayries(){
        return librairyService.getLibrairy();
    }

    /**
     * Enregistre une Librairy
     * @param librairy à enregistrer
     * @return Librairy enregistré
     */
    @PostMapping("/librairy")
    public Librairy createLibrairy(@RequestBody Librairy librairy){
        return librairyService.saveLibrairy(librairy);
    }

    /**
     * Met à jour une Librairy
     * @param id Librairy enregistré
     * @param librairy Nouvelles données
     * @return Nouvelle Librairy
     */
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

    /**
     * Supprime une Librairy
     * @param id Librairy à supprimer
     */
    @DeleteMapping("librairy/{id}")
    public void deleteLibrairy (@PathVariable("id") int id){
        librairyService.deleteLibrairy(id);
    }
}
