package com.ap.crud.samnple.ReactCrudApp.service;

import com.ap.crud.samnple.ReactCrudApp.domain.Category;
import com.ap.crud.samnple.ReactCrudApp.exception.EntityAlreadyExist;
import com.ap.crud.samnple.ReactCrudApp.exception.NoExistEntityException;

import java.util.List;

public interface CategoryService {

    Category register(Category Category) throws EntityAlreadyExist;

    Category findById(String id) throws NoExistEntityException;

    List<Category> findAll();


}
