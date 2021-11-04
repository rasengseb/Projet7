package com.librairy.api.repository;

import com.librairy.api.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

    List<Book> findByAuthorOrTitle(String author, String title);
}
