package com.ap.crud.samnple.ReactCrudApp.repository;


import com.ap.crud.samnple.ReactCrudApp.domain.School;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SchoolRepository extends CrudRepository<School, Long> {

    @Query("select s from School s")
    List<School> findAll();

}
