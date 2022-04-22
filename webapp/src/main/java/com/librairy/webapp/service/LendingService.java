package com.librairy.webapp.service;

import com.librairy.webapp.model.Lending;
import com.librairy.webapp.proxy.LendingProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class LendingService {

    @Autowired
    private LendingProxy lendingProxy;

    /**
     * Recupère un Lending
     * @param id Lending
     * @return Lending
     */
    public Lending getLending(int id){
        return lendingProxy.getLending(id);
    }

    /**
     * Récupère tous les lendings
     * @return List Lendings
     */
    public Iterable<Lending> getLendings(){
        return lendingProxy.getLendings();
    }

    /**
     * Recherche les Lending d'un User
     * @param token Sécurité
     * @param id Lending
     * @return List Lending
     */
    public List<Lending> findLendingByUser(String token, int id){
        return lendingProxy.findLendingByUser(token, id);
    }

    /**
     * Rallonge de 4 semaines la période de prêt
     * @param token Sécurité
     * @param id Lending
     */
    public void extend (String token, int id){
        Lending lending = lendingProxy.getLending(id);
        lending.getEnd().add(Calendar.DATE, 28);
        lending.setExtended(true);
        lendingProxy.saveLending(token, lending);
    }

}
