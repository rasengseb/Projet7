package com.librairy.api.repository;

import com.librairy.api.model.Book;
import com.librairy.api.model.Copy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface CopyRepository extends CrudRepository<Copy, Integer> {

    @GetMapping("/copy")
    List<Copy> getAllByBook(@RequestBody Book book);
}
