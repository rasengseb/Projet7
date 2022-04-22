package com.librairy.api.service;

import com.librairy.api.model.Book;
import com.librairy.api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    /**
     * Récupère un Book
     * @param id Book cherché
     * @return Book
     */
    public Optional<Book> getBook(int id){
        return bookRepository.findById(id);
    }

    /**
     * Recherche tous les Book enregistrés
     * @return List Book
     */
    public Iterable<Book> getBooks(){
        return bookRepository.findAll();
    }

    /**
     * Supprime un Book
     * @param id Book
     */
    public void deleteBook(int id){
        bookRepository.deleteById(id);
    }

    /**
     * Enregistre un Book
     * @param book à enregistrer
     * @return Book enregistré
     */
    public Book saveBook(Book book){
        Book savedBook = bookRepository.save(book);
        return savedBook;
    }

    /**
     * Recherche un Book par Author ou Title
     * @param author param Book cherché
     * @param title param Book cherché
     * @return List Book avec un param correspondant
     */
    public List<Book> findByAuthorLikeOrTitleLike(String author, String title){
        if(author.length()==0){
            return bookRepository.findByAuthorLikeOrTitleLike( author, "%"+title+"%");
        }
        if (title.length()==0){
            return bookRepository.findByAuthorLikeOrTitleLike( "%"+author+"%", title);
        }
        return bookRepository.findByAuthorLikeOrTitleLike( "%"+author+"%", "%"+title+"%");
    }
}
