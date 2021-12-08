package com.librairy.api.repository;

import com.librairy.api.model.Copy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CopyRepository extends CrudRepository<Copy, Integer> {

    List<Copy> getAllByBookId(int id);
}
