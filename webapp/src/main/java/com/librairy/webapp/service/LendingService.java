package com.librairy.webapp.service;

import com.librairy.webapp.model.Lending;
import com.librairy.webapp.proxy.LendingProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Lending> findLendingByUser(String token, int id){
        return lendingProxy.findLendingByUser(token, id);
    }

    public void extend (String token, int id){
        Lending lending = lendingProxy.getLending(id);
        lending.setExtended(true);
        lendingProxy.saveLending(token, lending);
    }

}
