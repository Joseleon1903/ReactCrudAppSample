package com.ap.crud.samnple.ReactCrudApp.controller;


import com.ap.crud.samnple.ReactCrudApp.domain.School;
import com.ap.crud.samnple.ReactCrudApp.exception.EntityAlreadyExist;
import com.ap.crud.samnple.ReactCrudApp.exception.InternalServerError;
import com.ap.crud.samnple.ReactCrudApp.exception.NoExistEntityException;
import com.ap.crud.samnple.ReactCrudApp.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value="/api/school")
public class SchoolController {

    Logger logger = Logger.getLogger(SchoolController.class.getName());

    private final SchoolService schoolService;

    @Autowired
    public SchoolController (SchoolService schoolService){
        this.schoolService= schoolService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<School> findById(@PathVariable("id") Long id){
        try {
            School entity = schoolService.findById(id);
            return new ResponseEntity(entity, HttpStatus.OK);
        } catch (NoExistEntityException e) {
            logger.info("ERROR: "+e.getMessage());
             throw new InternalServerError(e.getMessage());
        }
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<School> createSchool(@RequestBody School school) {
        try {
            School entity = schoolService.register(school);
            return new ResponseEntity(entity, HttpStatus.OK);
        } catch (EntityAlreadyExist e) {
            logger.info("ERROR: "+e.getMessage());
            throw new InternalServerError(e.getMessage());
        }
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<School>> findSchool(@RequestParam(value = "id" , required = false) Long id ,
                                                   @RequestParam(value = "name" , required = false) String name ) {
            List<School> entityList = schoolService.findByParam(id, name);
            return new ResponseEntity(entityList, HttpStatus.OK);
    }


}
