package com.librairy.webapp.service;

import com.librairy.webapp.model.Book;
import com.librairy.webapp.model.Copy;
import com.librairy.webapp.proxy.CopyProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CopyService {

    @Autowired
    private CopyProxy copyProxy;

    /**
     * Recherche les Copy par Book
     * @param id Book
     * @return List Copy
     */
    public List<Copy> getCopyByBook(int id){
        return copyProxy.getCopyByBook(id);
    }
}
