package com.ap.crud.samnple.ReactCrudApp.service;

import com.ap.crud.samnple.ReactCrudApp.domain.Restaurant;
import com.ap.crud.samnple.ReactCrudApp.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    Logger logger = Logger.getLogger(RestaurantService.class.getName());

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Restaurant> getAll() {

        List<Restaurant> listOut = new ArrayList<>();
        restaurantRepository.findAll().iterator().forEachRemaining(
                listOut::add
        );
        return listOut;
    }

    @Override
    public List<Restaurant> saveAll(Restaurant[] restaurants) {
        logger.entering(RestaurantServiceImpl.class.getName(),"saveAll" );
        logger.info("entering in saveAll");
        logger.info("restaurants count: "+restaurants.length);

        for (Restaurant entity : restaurants){
            logger.info("save: "+entity);
            restaurantRepository.save(entity);
        }
        return List.of(restaurants);
    }

    @Override
    public List<Restaurant> findNearByRestaurant() {
        logger.info("entering in findNearByRestaurant");
        List<Restaurant> listOut = new ArrayList<>();
        listOut = restaurantRepository.findNearRestaurant();
        return listOut;
    }
}
