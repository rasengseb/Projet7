package com.librairy.webapp.proxy;

import com.librairy.webapp.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="Book", url = "localhost:9000")
public interface BookProxy {

    @GetMapping("/book/{id}")
    Book getBook(@PathVariable("id") int id);

    @GetMapping("/book")
    Iterable<Book> getBooks();

    @PostMapping("/book/books")
    List<Book> findByAuthorLikeOrTitleLike(@RequestParam String author,@RequestParam String title);
}
