package com.ap.crud.samnple.ReactCrudApp.controller;

import com.ap.crud.samnple.ReactCrudApp.domain.Coord;
import com.ap.crud.samnple.ReactCrudApp.service.CoordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping(value="/api/coord")
@CrossOrigin("http://localhost:3000/")
public class CoordsController {

    Logger logger = Logger.getLogger(CoordsController.class.getName());

    private final CoordService coordService;

    @Autowired
    public CoordsController (CoordService coordService){
        this.coordService= coordService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<Coord[]> findAll(){
        Coord[] entityList = coordService.getAll();
        return new ResponseEntity<>(entityList, HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Coord[]> saveRestaurants( @RequestBody Coord[] coords){
        Coord[] entityList = coordService.saveAll(coords);
        return new ResponseEntity<>(entityList, HttpStatus.OK);
    }

}
