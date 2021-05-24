package com.librairy.api.service;

import com.librairy.api.model.Librairy;
import com.librairy.api.repository.LibrairyRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class LibrairyService {

    @Autowired
    private LibrairyRepository librairyRepository;

    public Optional<Librairy> getLibrairy(int id){
        return librairyRepository.findById(id);
    }

    public Iterable<Librairy> getLibrairy(){
        return librairyRepository.findAll();
    }

    public void deleteLibrairy(int id){
        librairyRepository.deleteById(id);
    }

    public Librairy saveLibrairy(Librairy librairy){
        Librairy savedLibrairy = librairyRepository.save(librairy);
        return savedLibrairy;
    }
}
