package com.librairy.api.repository;

import com.librairy.api.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    /**
     * Recherche Book par author ou title
     * @param author param recherche
     * @param title param recherche
     * @return List Book
     */
    @Query(value = "select b from Book b where b.author like :author or b.title like :title")
    List<Book> findByAuthorLikeOrTitleLike(@Param("author") String author,@Param("title") String title);
}
