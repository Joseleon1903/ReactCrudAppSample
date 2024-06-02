package com.ap.crud.samnple.ReactCrudApp.controller;

import com.ap.crud.samnple.ReactCrudApp.domain.Restaurant;
import com.ap.crud.samnple.ReactCrudApp.service.RestaurantService;
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

    @GetMapping("/nearByRestaurant")
    @ResponseBody
    public ResponseEntity<List<Restaurant>> findNearByRestaurant(){
        List<Restaurant> entityList = restaurantService.findNearByRestaurant();
        return new ResponseEntity<>(entityList, HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<List<Restaurant>> saveRestaurants( @RequestBody Restaurant[] restaurants){
        List<Restaurant> entityList = restaurantService.saveAll(restaurants);
        return new ResponseEntity<>(entityList, HttpStatus.OK);
    }


}
