package com.librairy.api.repository;

import com.librairy.api.model.Lending;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface LendingRepository extends CrudRepository<Lending, Integer> {

    @GetMapping("/lending/{id}")
    List<Lending> findByUser(@PathVariable("id") int id);
}
