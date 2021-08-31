package com.librairy.webapp.controller;

import com.librairy.webapp.model.Book;
import com.librairy.webapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping("/book")
    public String books(Model model) {
        Iterable<Book> listBook = bookService.getBooks();
        model.addAttribute("books", listBook);

        return "listBook";
    }

    @GetMapping("/book/{id}")
    public String getBook(@PathVariable("id") int id, Model model){
        Optional<Book> book = bookService.getBook(id);
        model.addAttribute("book", book);

        return "afficherBook";
    }
}
