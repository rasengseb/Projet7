package com.librairy.webapp.proxy;

import com.librairy.webapp.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(name="Book", url = "localhost:9000")
public interface BookProxy {

    @GetMapping("/book/{id}")
    Optional<Book> getBook(@PathVariable("id") int id);

    @GetMapping("/book")
    Iterable<Book> getBooks();

    @GetMapping("/book/books")
    List<Book> findByAuthorAndTitle(String author, String title);
}
