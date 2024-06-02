package com.ap.crud.samnple.ReactCrudApp.service;

import com.ap.crud.samnple.ReactCrudApp.domain.Restaurant;

import java.util.List;

public interface RestaurantService {

    List<Restaurant> getAll();

    List<Restaurant> saveAll(Restaurant[] restaurants);

    List<Restaurant> findNearByRestaurant();
}
