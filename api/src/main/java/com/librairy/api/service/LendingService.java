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

    /**
     * Récupère un lending
     * @param id lending souhaité
     * @return lending
     */
    public Lending getLending(int id){
        return lendingRepository.findById(id).orElse(null);
    }

    /**
     * Récupère tous les lendings
     * @return List lendings
     */
    public List<Lending> getLendings(){
        return lendingRepository.findAll();
    }

    /**
     * Supprime un lending
     * @param id lending à supprimer
     */
    public void deleteLending(int id){
        lendingRepository.deleteById(id);
    }

    /**
     * Enregistrer le lending
     * @param lending à enregistré
     * @return lending enregistré
     */
    public Lending saveLending(Lending lending){
        Lending savedLending = lendingRepository.save(lending);
        return savedLending;
    }

    /**
     * Recherche des prêts d'un utilisateur
     * @param id utilisateur
     * @return List des lendings
     */
    public List<Lending> findAllLendingByUser(int id){
        return lendingRepository.findAllByUserId(id);
    }

}
