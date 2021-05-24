package com.librairy.api.service;

import com.librairy.api.model.Lending;
import com.librairy.api.repository.LendingRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class LendingService {

    @Autowired
    private LendingRepository lendingRepository;

    public Optional<Lending> getLending(int id){
        return lendingRepository.findById(id);
    }

    public Iterable<Lending> getLendings(){
        return lendingRepository.findAll();
    }

    public void deleteLending(int id){
        lendingRepository.deleteById(id);
    }

    public Lending saveLending(Lending lending){
        Lending savedLending = lendingRepository.save(lending);
        return savedLending;
    }
}