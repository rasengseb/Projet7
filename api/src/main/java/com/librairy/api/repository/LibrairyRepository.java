package com.librairy.api.repository;

import com.librairy.api.model.Librairy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrairyRepository extends CrudRepository<Librairy, Long> {
}
