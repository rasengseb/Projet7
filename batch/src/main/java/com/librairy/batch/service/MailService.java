package com.librairy.batch.service;

import com.librairy.batch.model.Lending;
import com.librairy.batch.proxy.MailProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailService {

    @Autowired
    private MailProxy mailProxy;

    /**
     * Récupère tous les retards
     * @return list des retards
     */
    public List<Lending> getAllDelay(){
        return mailProxy.getAllDelay();
    }

}
