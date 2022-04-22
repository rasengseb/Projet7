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

    /**
     * Cherche un Book
     * @param id Book cherché
     * @return Book cherché
     */
    @GetMapping("/book/{id}")
    public Optional<Book> getBook(@PathVariable("id") int id){
        return bookService.getBook(id);
    }

    /**
     * Cherche tous les Book
     * @return List Book
     */
    @GetMapping("/book")
    public Iterable<Book> getBooks(){
        return bookService.getBooks();
    }

    /**
     * Enregistre Book
     * @param book à enregistrer
     * @return Book enregistré
     */
    @PostMapping("/book")
    public Book createBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    /**
     * Mis à jour d'un Book
     * @param id Book dans BDD
     * @param book Nouveau à enregistrer
     * @return Book à jour
     */
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

    /**
     * Supprime un Book
     * @param id Book à Supprimer
     */
    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable("id") int id){
        bookService.deleteBook(id);
    }

    /**
     * Cherche Book par author ou title
     * @param author Param recherche
     * @param title Param recherche
     * @return List Book
     */
    @PostMapping("/book/books")
    public List<Book> findByAuthorOrTitle(@RequestParam String author, @RequestParam String title){
        return bookService.findByAuthorLikeOrTitleLike(author, title);
    }
}
