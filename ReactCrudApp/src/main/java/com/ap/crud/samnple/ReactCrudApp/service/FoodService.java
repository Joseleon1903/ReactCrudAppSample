package com.ap.crud.samnple.ReactCrudApp.service;

import com.ap.crud.samnple.ReactCrudApp.dto.FoodDto;
import java.util.List;

public interface FoodService {

    List<FoodDto> getAll();

    FoodDto saveFood(FoodDto food);

    List<FoodDto> getFoodsByRestaurant(String restaurantId);

    List<FoodDto> getFoodsCategoryAndTag(String category, String tag);
}