package com.ap.crud.samnple.ReactCrudApp.repository;

import com.ap.crud.samnple.ReactCrudApp.domain.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant, String> {


}
