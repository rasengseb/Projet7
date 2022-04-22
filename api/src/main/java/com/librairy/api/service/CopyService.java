package com.librairy.api.service;

import com.librairy.api.model.Book;
import com.librairy.api.model.Copy;
import com.librairy.api.repository.CopyRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CopyService {

    @Autowired
    private CopyRepository copyRepository;

    /**
     * Récupère une Copy
     * @param id copy cherché
     * @return Copy
     */
    public Optional<Copy> getCopy(int id){
        return copyRepository.findById(id);
    }

    /**
     * Récupère toutes les Copy enregistrées
     * @return List Copy
     */
    public Iterable<Copy> getCopy(){
        return copyRepository.findAll();
    }

    /**
     *Supprime une Copy
     * @param id Copy à supprimer
     */
    public void deleteCopy(int id){
        copyRepository.deleteById(id);
    }

    /**
     * Enregistre une COpy
     * @param copy à enregistrer
     * @return Copy enregistré
     */
    public Copy saveCopy(Copy copy){
        Copy savedCopy = copyRepository.save(copy);
        return savedCopy;
    }

    /**
     * Recherche une copy par id d'un book
     * @param id book cherché
     * @return List Copy du book
     */
    public List<Copy> getCopyByBook(int id){
        return copyRepository.getAllByBookId(id);
    }
}
