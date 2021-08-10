package com.librairy.webapp.service;

import com.librairy.webapp.model.Lending;
import com.librairy.webapp.proxy.LendingProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LendingService {

    @Autowired
    private LendingProxy lendingProxy;

    public Lending getLending(int id){
        return lendingProxy.getLending(id);
    }

    public Iterable<Lending> getLendings(){
        return lendingProxy.getLendings();
    }
}
