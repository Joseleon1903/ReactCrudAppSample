package com.ap.crud.samnple.ReactCrudApp.controller;


import com.ap.crud.samnple.ReactCrudApp.domain.Category;
import com.ap.crud.samnple.ReactCrudApp.exception.EntityAlreadyExist;
import com.ap.crud.samnple.ReactCrudApp.exception.InternalServerError;
import com.ap.crud.samnple.ReactCrudApp.exception.NoExistEntityException;
import com.ap.crud.samnple.ReactCrudApp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value="/api/category")
@CrossOrigin("http://localhost:3000/")
public class CategoryController {

    Logger logger = Logger.getLogger(CategoryController.class.getName());

    private final CategoryService categoryService;

    @Autowired
    public CategoryController (CategoryService categoryService){
        this.categoryService= categoryService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Category> findById(@PathVariable("id") String id){
        try {
            Category entity = categoryService.findById(id);
            return new ResponseEntity<>(entity, HttpStatus.OK);
        } catch (NoExistEntityException e) {
            logger.info("ERROR: "+e.getMessage());
            throw new InternalServerError(e.getMessage());
        }
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        try {
            Category entity = categoryService.register(category);
            return new ResponseEntity<>(entity, HttpStatus.CREATED);
        } catch (EntityAlreadyExist e) {
            logger.info("ERROR: "+e.getMessage());
            throw new InternalServerError(e.getMessage());
        }
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Category>> findAll(){
        List<Category> entityList = categoryService.findAll();
        return new ResponseEntity<>(entityList, HttpStatus.OK);
    }

}
