package com.ap.crud.samnple.ReactCrudApp.reporitory;

import com.ap.crud.samnple.ReactCrudApp.domain.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant, String> {


}
