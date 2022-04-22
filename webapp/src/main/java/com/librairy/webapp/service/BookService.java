package com.librairy.webapp.service;

import com.librairy.webapp.model.Book;
import com.librairy.webapp.proxy.BookProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookProxy bookProxy;

    /**
     * Récupère un Book
     * @param id Book
     * @return Book
     */
    public Book getBook(int id){
        return bookProxy.getBook(id);
    }

    /**
     * Récupère tous les Book
     * @return List Book
     */
    public Iterable<Book> getBooks(){
        return bookProxy.getBooks();
    }

    /**
     * Recherche un Book par author ou title
     * @param author param
     * @param title param
     * @return List Book
     */
    public List<Book> findByAuthorOrTitle(String author, String title){
        return bookProxy.findByAuthorLikeOrTitleLike(author,title);
    }
}
