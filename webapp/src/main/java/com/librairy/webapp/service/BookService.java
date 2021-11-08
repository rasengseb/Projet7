package com.librairy.webapp.service;

import com.librairy.webapp.model.Book;
import com.librairy.webapp.proxy.BookProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookProxy bookProxy;

    public Optional<Book> getBook(int id){
        return bookProxy.getBook(id);
    }

    public Iterable<Book> getBooks(){
        return bookProxy.getBooks();
    }

    public List<Book> findByAuthorOrTitle(String author, String title){
        return bookProxy.findByAuthorOrTitle(author, title);
    }
}
