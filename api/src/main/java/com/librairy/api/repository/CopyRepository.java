package com.librairy.api.repository;

import com.librairy.api.model.Copy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CopyRepository extends CrudRepository<Copy, Integer> {

    /**
     * Trouve toutes les Copy contenant le Book
     * @param id Book
     * @return List Copy
     */
    List<Copy> getAllByBookId(int id);
}
