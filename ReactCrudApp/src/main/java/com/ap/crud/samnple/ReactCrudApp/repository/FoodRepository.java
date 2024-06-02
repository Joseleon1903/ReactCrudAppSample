package com.ap.crud.samnple.ReactCrudApp.repository;

import com.ap.crud.samnple.ReactCrudApp.domain.Food;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FoodRepository extends CrudRepository<Food, Long> {

    List<Food> findAll();

    @Query("select f from Food f where restaurant.id = :restaurant ")
    List<Food> getFoodsByRestaurant(String restaurant);

    @Query("select f from Food f join f.category c where c.value = :category")
    List<Food> getFoodsCategory(String category);
}
