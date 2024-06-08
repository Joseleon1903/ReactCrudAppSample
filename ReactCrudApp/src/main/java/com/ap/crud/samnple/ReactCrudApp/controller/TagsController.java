package com.ap.crud.samnple.ReactCrudApp.controller;

import com.ap.crud.samnple.ReactCrudApp.dto.TagsDto;
import com.ap.crud.samnple.ReactCrudApp.service.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.logging.Logger;

@RestController
@RequestMapping(value="/api/tags")
@CrossOrigin("http://localhost:3000/")
public class TagsController {


    Logger logger = Logger.getLogger(CategoryController.class.getName());

    private final TagsService tagsService;

    @Autowired
    public TagsController (TagsService tagsService){
        this.tagsService= tagsService;
    }


    @GetMapping
    @ResponseBody
    public ResponseEntity<Set<TagsDto>> findAll(){
        Set<TagsDto> entityList = tagsService.findAllTags();
        return new ResponseEntity<>(entityList, HttpStatus.OK);
    }



}
