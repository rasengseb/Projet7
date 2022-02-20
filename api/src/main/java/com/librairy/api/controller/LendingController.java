package com.librairy.api.controller;

import com.librairy.api.model.Lending;
import com.librairy.api.service.LendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LendingController {

    @Autowired
    private LendingService lendingService;

    @GetMapping("/lending/{id}")
    public Lending getLending(@PathVariable("id") int id){
        return lendingService.getLending(id);
    }

    @PostMapping("/lending")
    public Lending createLending(@RequestBody Lending lending){
        return lendingService.saveLending(lending);
    }

    @GetMapping("/lending")
    public Iterable<Lending> getLendings(){
        return lendingService.getLendings();
    }

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

    @DeleteMapping("/lending/{id}")
    public void deleteLending(@PathVariable("id") int id){
        lendingService.deleteLending(id);
    }

    @GetMapping("/lendings/{id}")
    List<Lending> findLendingByUser(@PathVariable("id") int id){
        return lendingService.findAllLendingByUser(id);
    }

}
