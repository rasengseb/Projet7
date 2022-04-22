package com.librairy.api.service;

import com.librairy.api.model.Librairy;
import com.librairy.api.repository.LibrairyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class LibrairyService {

    @Autowired
    private LibrairyRepository librairyRepository;

    /**
     * Récupère une librairy souhaité
     * @param id librairy cherché
     * @return librairy
     */
    public Optional<Librairy> getLibrairy(int id){
        return librairyRepository.findById(id);
    }

    /**
     * Récupère toutes les librairy enregistrées
     * @return List librairy
     */
    public Iterable<Librairy> getLibrairy(){
        return librairyRepository.findAll();
    }

    /**
     * Supprime une librairy
     * @param id librairy à supprimer
     */
    public void deleteLibrairy(int id){
        librairyRepository.deleteById(id);
    }

    /**
     * Enregistre une librairy
     * @param librairy à enregistrer
     * @return librairy enregistré
     */
    public Librairy saveLibrairy(Librairy librairy){
        Librairy savedLibrairy = librairyRepository.save(librairy);
        return savedLibrairy;
    }
}
