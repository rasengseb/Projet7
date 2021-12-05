package com.librairy.webapp.service;

import com.librairy.webapp.model.Book;
import com.librairy.webapp.model.Copy;
import com.librairy.webapp.proxy.CopyProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CopyService {

    @Autowired
    private CopyProxy copyProxy;

    public List<Copy> getCopyByBook(String token, Book book){
        return copyProxy.getCopyByBook(token, book);
    }
}
