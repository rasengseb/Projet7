package com.librairy.api.repository;

import com.librairy.api.model.Lending;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LendingRepository extends CrudRepository<Lending, Integer> {
}
