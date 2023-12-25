package com.ap.crud.samnple.ReactCrudApp.service;

import com.ap.crud.samnple.ReactCrudApp.domain.School;
import com.ap.crud.samnple.ReactCrudApp.exception.EntityAlreadyExist;
import com.ap.crud.samnple.ReactCrudApp.exception.NoExistEntityException;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SchoolService {

    School register(School school) throws EntityAlreadyExist;

    School findById(Long id) throws NoExistEntityException;

    School update(School school) throws NoExistEntityException;

    void deleteById(Long id);

    List<School> findByParam(Long id, String text);

}
