package com.librairy.api.repository;

import com.librairy.api.model.Lending;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface LendingRepository extends CrudRepository<Lending, Integer> {

    List<Lending> findAllByUserId(@PathVariable("id") int id);

//    @PostMapping("mail")
//    List<Lending> getOutdatedLending();
}
