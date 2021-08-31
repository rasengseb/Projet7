package com.librairy.webapp.proxy;

import com.librairy.webapp.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@FeignClient(name="Book", url = "localhost:9000")
public interface BookProxy {

    @GetMapping("/book/{id}")
    Optional<Book> getBook(int id);

    @GetMapping("/book")
    Iterable<Book> getBooks();
}
