package com.librairy.api.service;

import com.librairy.api.model.Lending;
import com.librairy.api.repository.LendingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LendingService {

    @Autowired
    private LendingRepository lendingRepository;

    public Lending getLending(int id){
        return lendingRepository.findById(id).orElse(null);
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

    public List<Lending> findAllLendingByUser(int id){
        return lendingRepository.findAllByUserId(id);
    }

//    public List<Lending> getOutdatedLending(){
//        List<Lending> outdated = new ArrayList<>();
//        List<Lending> lendings = getLendings();
//
//        return outdated;
//    }
}
