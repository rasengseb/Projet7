package com.librairy.api.repository;

import com.librairy.api.model.Lending;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface LendingRepository extends JpaRepository<Lending, Integer> {

    List<Lending> findAllByUserId(@PathVariable("id") int id);

}
