package com.librairy.api.controller;

import com.librairy.api.model.Book;
import com.librairy.api.model.Copy;
import com.librairy.api.service.CopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class CopyController {

    @Autowired
    private CopyService copyService;

    /**
     * Enregistre une Copy
     * @param copy à enregistrer
     * @return Copy enregistré
     */
    @PostMapping("/copy")
    public Copy createCopy(@RequestBody Copy copy) {
        return copyService.saveCopy(copy);
    }

    /**
     * Supprime une Copy
     * @param id Copy à supprimer
     */
    @DeleteMapping("/copy/{id}")
    public void deleteCopy(@PathVariable("id") int id){
        copyService.deleteCopy(id);
    }

    /**
     * Cherche une Copy par Book
     * @param id Book cherché
     * @return List Copy
     */
    @GetMapping("/copy/{id}")
    public List<Copy> GetCopyByBook(@PathVariable int id){
        return copyService.getCopyByBook(id);
    }

}
