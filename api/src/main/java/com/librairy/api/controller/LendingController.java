package com.librairy.api.controller;

import com.librairy.api.model.Lending;
import com.librairy.api.service.LendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController
public class LendingController {

    @Autowired
    private LendingService lendingService;

    /**
     * Récupère un prêt spécifique
     * @param id lending voulu
     * @return lending
     */
    @GetMapping("/lending/{id}")
    public Lending getLending(@PathVariable("id") int id){
        return lendingService.getLending(id);
    }

    /**
     * Ajout un prêt
     * @param lending données à ajouté
     * @return lending ajouté
     */
    @PostMapping("/lending")
    public Lending createLending(@RequestBody Lending lending){
        return lendingService.saveLending(lending);
    }

    /**
     * Récupère tous les lending
     * @return List des lendings
     */
    @GetMapping("/lending")
    public Iterable<Lending> getLendings(){
        return lendingService.getLendings();
    }

    /**
     * Mise à jour d'un lending
     * @param id lending à modifier
     * @param lending nouvelles donées à ajouter
     * @return lending mis à jour
     */
    @PutMapping("/lending/{id}")
    public Lending updateLending(@PathVariable("id") int id, @RequestBody Lending lending){
        Lending l = lendingService.getLending(id);
        if (l != null){
            Lending currentLending = l;

            if (lending.getStart() != null){
                currentLending.setStart(lending.getStart());
            }

            if (lending.getEnd() != null){
                currentLending.setEnd(lending.getEnd());
            }

            if (currentLending.isExtended() != lending.isExtended()){
                currentLending.setExtended(lending.isExtended());
            }
            lendingService.saveLending(currentLending);
            return currentLending;
        }
        else {
            return null;
        }
    }

    /**
     * Supprime un lending
     * @param id lending à supprimer
     */
    @DeleteMapping("/lending/{id}")
    public void deleteLending(@PathVariable("id") int id){
        lendingService.deleteLending(id);
    }

    /**
     * Cherche les prêts d'un utilisateur
     * @param id id de l'utilisateur
     * @return list des prêts de l'utilisateur
     */
    @GetMapping("/lendings/{id}")
    List<Lending> findLendingByUser(@PathVariable("id") int id){
        return lendingService.findAllLendingByUser(id);
    }

    /**
     * Récupère tous les prêts et renvoie les retards
     * @return list des retards
     */
    @GetMapping("/lendings")
    List<Lending> getAllDelay() {
        List<Lending> allLending = lendingService.getLendings();
        List<Lending> delay = new ArrayList<>();
        for (Lending lending : allLending) {
            if (lending.getEnd().before(Calendar.getInstance())) {
                delay.add(lending);
            }
        }
        return delay;
    }

}
