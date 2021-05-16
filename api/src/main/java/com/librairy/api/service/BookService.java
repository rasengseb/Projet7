package com.librairy.api.service;

import com.librairy.api.model.Book;
import com.librairy.api.repository.BookRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Optional<Book> getBook(final Long id){
        return bookRepository.findById(id);
    }

    public Iterable<Book> getBooks(){
        return bookRepository.findAll();
    }

    public void deleteBook(final Long id){
        bookRepository.deleteById(id);
    }

    public Book saveBook(Book book){
        Book savedBook = bookRepository.save(book);
        return savedBook;
    }
}
