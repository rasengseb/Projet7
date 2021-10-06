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
    public Optional<Lending> getLending(@PathVariable("id") int id){
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
        Optional<Lending> l = lendingService.getLending(id);
        if (l.isPresent()){
            Lending currentLending = l.get();

            String start = lending.getStart();
            if (start != null){
                currentLending.setStart(start);
            }
            String end = lending.getEnd();
            if (end != null){
                currentLending.setEnd(end);
            }
            boolean extended = lending.isExtended();
            if (extended != false){
                currentLending.setExtended(extended);
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

    List<Lending> findLendingByUser(int id){
        return lendingService.findLendingByUser(id);
    }

}
