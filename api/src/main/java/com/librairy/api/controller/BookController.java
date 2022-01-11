package com.librairy.api.controller;

import com.librairy.api.model.Book;
import com.librairy.api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/book/{id}")
    public Optional<Book> getBook(@PathVariable("id") int id){
        return bookService.getBook(id);
    }

    @GetMapping("/book")
    public Iterable<Book> getBooks(){
        return bookService.getBooks();
    }

    @PostMapping("/book")
    public Book createBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    @PutMapping("/book/{id}")
    public Book updateBook(@PathVariable("id") int id, @RequestBody Book book){
        Optional<Book> b = bookService.getBook(id);
        if(b.isPresent()){
            Book currentBook = b.get();

            String title = book.getTitle();
            if (title != null){
                currentBook.setTitle(title);
            }
            String author = book.getAuthor();
            if (author != null){
                currentBook.setAuthor(author);
            }

            bookService.saveBook(currentBook);
            return currentBook;
        }
        else{
            return null;
        }
    }

    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable("id") int id){
        bookService.deleteBook(id);
    }

    @PostMapping("/book/books")
    public List<Book> findByAuthorOrTitle(@RequestBody Book book){
        return bookService.findByAuthorOrTitle(book.getAuthor(), book.getTitle());
    }
}
