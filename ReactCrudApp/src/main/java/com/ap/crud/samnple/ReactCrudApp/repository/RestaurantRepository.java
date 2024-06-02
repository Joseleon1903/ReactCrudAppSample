package com.ap.crud.samnple.ReactCrudApp.repository;

import com.ap.crud.samnple.ReactCrudApp.domain.Restaurant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface RestaurantRepository extends CrudRepository<Restaurant, String> {


    Restaurant findByTitle(String restaurant);

    @Query("select r from Restaurant r order by distance asc ")
    List<Restaurant> findNearRestaurant();

}
