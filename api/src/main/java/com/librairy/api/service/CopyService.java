package com.librairy.api.service;

import com.librairy.api.model.Copy;
import com.librairy.api.repository.CopyRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CopyService {

    @Autowired
    private CopyRepository copyRepository;

    public Optional<Copy> getCopy(final Long id){
        return copyRepository.findById(id);
    }

    public Iterable<Copy> getCopy(){
        return copyRepository.findAll();
    }

    public void deleteCopy(final Long id){
        copyRepository.deleteById(id);
    }

    public Copy saveCopy(Copy copy){
        Copy savedCopy = copyRepository.save(copy);
        return savedCopy;
    }
}
