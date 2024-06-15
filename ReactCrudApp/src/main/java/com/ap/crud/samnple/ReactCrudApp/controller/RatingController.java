package com.ap.crud.samnple.ReactCrudApp.controller;

import com.ap.crud.samnple.ReactCrudApp.domain.Restaurant;
import com.ap.crud.samnple.ReactCrudApp.dto.FoodDto;
import com.ap.crud.samnple.ReactCrudApp.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping(value="/api/rating")
@CrossOrigin("http://localhost:3000/")
public class RatingController {

    Logger logger = Logger.getLogger(RatingController.class.getName());

    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PutMapping("/{restaurantId}/{rating}")
    @ResponseBody
    public ResponseEntity<Restaurant> updateRestaurantRating(@PathVariable("restaurantId") String restaurantId,
                                                             @PathVariable("rating") String rating){
        Restaurant restaurant = ratingService.updateRating(restaurantId, rating);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }
}
