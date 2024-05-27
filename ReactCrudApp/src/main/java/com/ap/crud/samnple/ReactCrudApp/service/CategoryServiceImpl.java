package com.ap.crud.samnple.ReactCrudApp.service;

import com.ap.crud.samnple.ReactCrudApp.domain.Category;
import com.ap.crud.samnple.ReactCrudApp.exception.EntityAlreadyExist;
import com.ap.crud.samnple.ReactCrudApp.exception.NoExistEntityException;
import com.ap.crud.samnple.ReactCrudApp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class CategoryServiceImpl implements CategoryService{

    Logger logger = Logger.getLogger(CategoryService.class.getName());

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository= categoryRepository;
    }


    @Override
    public Category register(Category category) throws EntityAlreadyExist {
        logger.info("Entering register method");
        logger.info("param: "+ category);

        if (category.getId() != null && categoryRepository.findById(category.getId()).isPresent()){
            throw new EntityAlreadyExist("Ya existe un registro con este Id");
        }

        String id = UUID.randomUUID().toString();
        category.setId(id);

        Category entity = categoryRepository.save(category);
        logger.info("Existing register method");
        return entity;
    }

    @Override
    public Category findById(String id) throws NoExistEntityException {
        logger.info("Entering findById method");
        logger.info("param id: "+ id);

        if (id != null && categoryRepository.findById(id).isPresent()){
            logger.info("Existing findById method");
            return categoryRepository.findById(id).get();
        }
        throw new NoExistEntityException("No existe una entidad con este Id");
    }

    @Override
    public List<Category> findAll() {
        logger.info("Entering findAll method");
        List<Category> listOut = new ArrayList<>();

        Iterable<Category> list = categoryRepository.findAll();

        for(Category item : list){
            listOut.add(item);
        }
        return listOut;
    }
}
