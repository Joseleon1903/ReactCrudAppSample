package com.ap.crud.samnple.ReactCrudApp.service;

import com.ap.crud.samnple.ReactCrudApp.domain.Restaurant;
import com.ap.crud.samnple.ReactCrudApp.reporitory.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

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
}
