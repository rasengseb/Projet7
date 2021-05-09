package com.librairy.api.service;

import com.librairy.api.model.Librairy;
import com.librairy.api.repository.LibrairyRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class LibrairyService {

    @Autowired
    private LibrairyRepository librairyRepository;

    public Optional<Librairy> getLibrairy(final Long id){
        return librairyRepository.findById(id);
    }

    public Iterable<Librairy> getLibrairy(){
        return librairyRepository.findAll();
    }

    public void deleteLibrairy(final Long id){
        librairyRepository.deleteById(id);
    }

    public Librairy saveLibrairy(Librairy librairy){
        Librairy savedLibrairy = librairyRepository.save(librairy);
        return savedLibrairy;
    }
}
