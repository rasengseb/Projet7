package com.librairy.api.repository;

import com.librairy.api.model.Lending;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LendingRepository extends CrudRepository<Lending, Integer> {

    List<Lending> findByUser(int id);
}
