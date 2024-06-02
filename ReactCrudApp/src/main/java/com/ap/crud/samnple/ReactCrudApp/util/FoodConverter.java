package com.ap.crud.samnple.ReactCrudApp.util;

import com.ap.crud.samnple.ReactCrudApp.domain.Additives;
import com.ap.crud.samnple.ReactCrudApp.domain.Food;
import com.ap.crud.samnple.ReactCrudApp.domain.FoodType;
import com.ap.crud.samnple.ReactCrudApp.domain.Tags;
import com.ap.crud.samnple.ReactCrudApp.dto.AdditivesDto;
import com.ap.crud.samnple.ReactCrudApp.dto.FoodDto;

import java.util.ArrayList;
import java.util.List;

public class FoodConverter {


    public static FoodDto convert(Food food){

        FoodDto dto = new FoodDto();
        dto.setId(food.getId());
        dto.setTitle(food.getTitle());

        if(food.getFoodTags() != null){
            List<String> listTag = food.getFoodTags().stream().map(Tags::getValue).toList();
            dto.setFoodTags(listTag.toArray(String[]::new));
        }

        if(food.getFoodType() != null){
            List<String> listType = food.getFoodType().stream().map(FoodType::getValue).toList();
            dto.setFoodType(listType.toArray(String[]::new));
        }


        dto.setCode(food.getCode());
        dto.setAvailable(food.isAvailable());
        dto.setRestaurant(food.getRestaurant().getId());
        dto.setRating(food.getRating());
        dto.setRatingCount(food.getRatingCount());
        dto.setDescription(food.getDescription());
        dto.setPrice(food.getPrice());

        List<AdditivesDto> lisdAdd = new ArrayList<>();
        for (Additives addi : food.getAdditives()){
            AdditivesDto additivesDto =  new AdditivesDto();
            additivesDto.setId(addi.getId());
            additivesDto.setTitle(addi.getTitle());
            additivesDto.setPrice(addi.getPrice());
            lisdAdd.add(additivesDto);
            dto.setAdditives(lisdAdd.toArray(AdditivesDto[]::new));
        }

        List<String> images = new ArrayList<>();
        images.add(food.getImageUrl());

        dto.setImageUrl(images.toArray(String[] :: new));
        dto.setVersion(food.getVersion());
        dto.setCategory(food.getCategory().getId());
        dto.setTime(food.getTime());
        return dto;
    }


}
