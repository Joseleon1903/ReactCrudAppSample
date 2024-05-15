package com.ap.crud.samnple.ReactCrudApp.controller;

import com.ap.crud.samnple.ReactCrudApp.domain.Category;
import com.ap.crud.samnple.ReactCrudApp.domain.Restaurant;
import com.ap.crud.samnple.ReactCrudApp.service.RestaurantService;
import com.ap.crud.samnple.ReactCrudApp.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value="/api/restaurant")
@CrossOrigin("http://localhost:3000/")
public class RestaurantController {

    Logger logger = Logger.getLogger(RestaurantController.class.getName());

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController (RestaurantService restaurantService){
        this.restaurantService= restaurantService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Restaurant>> findAll(){
        List<Restaurant> entityList = restaurantService.getAll();
        return new ResponseEntity<>(entityList, HttpStatus.OK);
    }


}
