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

    public Optional<Book> getBook(int id){
        return bookRepository.findById(id);
    }

    public Iterable<Book> getBooks(){
        return bookRepository.findAll();
    }

    public void deleteBook(int id){
        bookRepository.deleteById(id);
    }

    public Book saveBook(Book book){
        Book savedBook = bookRepository.save(book);
        return savedBook;
    }

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
