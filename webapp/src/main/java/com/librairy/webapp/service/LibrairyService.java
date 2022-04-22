package com.librairy.webapp.service;

import com.librairy.webapp.model.Librairy;
import com.librairy.webapp.proxy.LibrairyProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibrairyService {

    @Autowired
    private LibrairyProxy librairyProxy;

    /**
     * Récupère une Librairy
     * @param id Librairy
     * @return Librairy
     */
    public Librairy getLibrairy(int id){
        return librairyProxy.getLibrairy(id);
    }

    /**
     * Récupère toutes les Librairy
     * @return List Librairy
     */
    public Iterable<Librairy> getLibrairies(){
        return librairyProxy.getLibrairies();
    }
}
