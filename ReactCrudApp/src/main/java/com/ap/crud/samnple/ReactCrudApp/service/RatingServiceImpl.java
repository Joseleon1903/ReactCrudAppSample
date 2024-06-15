package com.ap.crud.samnple.ReactCrudApp.service;

import com.ap.crud.samnple.ReactCrudApp.domain.Restaurant;
import com.ap.crud.samnple.ReactCrudApp.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class RatingServiceImpl implements RatingService{


    Logger logger = Logger.getLogger(RatingService.class.getName());

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RatingServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Restaurant updateRating(String id, String rating) {
        logger.info("Entering in updateRating");
        logger.info("param id: "+id);
        logger.info("param rating: "+rating);
        Restaurant rest = null;
        if(restaurantRepository.findById(id).isPresent()){
            logger.info("found resturant..");

            rest = restaurantRepository.findById(id).get();
            Integer rate = Integer.parseInt(rating);
            logger.info("new rate : "+rate);
            rest.setRating(rate);
            rest = restaurantRepository.save(rest);
        }
        return  rest;
    }
}
