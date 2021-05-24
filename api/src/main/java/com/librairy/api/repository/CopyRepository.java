package com.librairy.api.repository;

import com.librairy.api.model.Copy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CopyRepository extends CrudRepository<Copy, Integer> {
}
