package com.ap.crud.samnple.ReactCrudApp.service;

import com.ap.crud.samnple.ReactCrudApp.domain.*;
import com.ap.crud.samnple.ReactCrudApp.dto.AdditivesDto;
import com.ap.crud.samnple.ReactCrudApp.dto.FoodDto;
import com.ap.crud.samnple.ReactCrudApp.repository.*;
import com.ap.crud.samnple.ReactCrudApp.util.FoodConverter;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class FoodServiceImpl implements  FoodService{

    Logger logger = Logger.getLogger(FoodService.class.getName());

    private final FoodRepository foodRepository;

    private final TagsRepository tagsRepository;

    private final FoodTypeRepository foodTypeRepository;

    private final RestaurantRepository restaurantRepository;

    private final AdditivesRepository additivesRepository;

    private final CategoryRepository categoryRepository;

    @Autowired
    public FoodServiceImpl(AdditivesRepository additivesRepository, FoodRepository foodRepository, TagsRepository tagsRepository, FoodTypeRepository foodTypeRepository, RestaurantRepository restaurantRepository, CategoryRepository categoryRepository) {
        this.foodRepository = foodRepository;
        this.tagsRepository = tagsRepository;
        this.foodTypeRepository = foodTypeRepository;
        this.restaurantRepository = restaurantRepository;
        this.additivesRepository = additivesRepository;
        this.categoryRepository =categoryRepository;
    }

    @Override
    public List<FoodDto> getAll() {
        logger.info("entering in getAll");

        List<Food> entityList = foodRepository.findAll();

        List<FoodDto> dtoList = new ArrayList<>();

        FoodDto dto = null;
        for (Food indx: entityList){
            dto = new FoodDto();
            dto.setId(indx.getId());
            dto.setTitle(indx.getTitle());

            if(indx.getFoodTags() != null){
                List<String> listTag = indx.getFoodTags().stream().map(Tags::getValue).toList();
                dto.setFoodTags(listTag.toArray(String[]::new));
            }

            if(indx.getFoodType() != null){
                List<String> listType = indx.getFoodType().stream().map(FoodType::getValue).toList();
                dto.setFoodType(listType.toArray(String[]::new));
            }


            dto.setCode(indx.getCode());
            dto.setAvailable(indx.isAvailable());
            dto.setRestaurant(indx.getRestaurant().getId());
            dto.setRating(indx.getRating());
            dto.setRatingCount(indx.getRatingCount());
            dto.setDescription(indx.getDescription());
            dto.setPrice(indx.getPrice());

            List<AdditivesDto> lisdAdd = new ArrayList<>();
            for (Additives addi : indx.getAdditives()){
                AdditivesDto additivesDto =  new AdditivesDto();
                additivesDto.setId(addi.getId());
                additivesDto.setTitle(addi.getTitle());
                additivesDto.setPrice(addi.getPrice());
                lisdAdd.add(additivesDto);
                dto.setAdditives(lisdAdd.toArray(AdditivesDto[]::new));
            }

            List<String> images = new ArrayList<>();
            images.add(indx.getImageUrl());

            dto.setImageUrl(images.toArray(String[] :: new));
            dto.setVersion(indx.getVersion());
            dto.setCategory(indx.getCategory().getId());
            dto.setTime(indx.getTime());
            dtoList.add(dto);
        }

        return dtoList;
    }

    @Transactional
    @Override
    public FoodDto saveFood(FoodDto foods) {
        logger.info("Entering saveAll");

        logger.info("save food DTO : "+ foods);
        Food foodEntity = new Food();

        foodEntity.setId(foods.getId());
        if(foods.getId() == null){
            String id = UUID.randomUUID().toString();
            foodEntity.setId(id);
        }
        foodEntity.setTitle(foods.getTitle());
        foodEntity.setCode(foods.getCode());
        foodEntity.setAvailable(foods.isAvailable());
        foodEntity.setRating(foods.getRating());
        foodEntity.setRatingCount(foods.getRatingCount());
        foodEntity.setDescription(foods.getDescription());
        foodEntity.setPrice(foods.getPrice());
        foodEntity.setImageUrl(foods.getImageUrl().length >0 ? foods.getImageUrl()[0] : "Unknow");
        foodEntity.setVersion(foods.getVersion());
        foodEntity.setTitle(foods.getTitle());
        foodEntity.setTime(foods.getTime());

        if(foods.getFoodTags() != null & Objects.requireNonNull(foods.getFoodTags()).length > 0){

            for (String foodtag : foods.getFoodTags()){
                Tags tag = new Tags();
                tag.setValue(foodtag);
                tag = tagsRepository.save(tag);
                foodEntity.getFoodTags().add(tag);
            }
        }

        if(foods.getFoodType() != null & Objects.requireNonNull(foods.getFoodType()).length > 0){

            for (String foodtype : foods.getFoodType()){
                FoodType ftype = new FoodType();
                ftype.setValue(foodtype);
                ftype = foodTypeRepository.save(ftype);
                foodEntity.getFoodType().add(ftype);
            }
        }

        if(foods.getAdditives() != null & Objects.requireNonNull(foods.getAdditives()).length > 0){

            for (AdditivesDto additive : foods.getAdditives()){
                Additives addEntity = new Additives();

                if(additivesRepository.findById(additive.getId()).isPresent()){
                    addEntity = additivesRepository.findById(additive.getId()).get();
                    foodEntity.getAdditives().add(addEntity);
                }else{
                    addEntity.setTitle(additive.getTitle());
                    addEntity.setPrice(additive.getPrice());
                    foodEntity.getAdditives().add(addEntity);
                }

            }
        }

        if(foods.getRestaurant() != null){
            if(restaurantRepository.findById(foods.getRestaurant()).isPresent()){
                Restaurant rest = restaurantRepository.findById(foods.getRestaurant()).get();
                foodEntity.setRestaurant(rest);
            }
        }

        if(foods.getCategory() != null){
            if(categoryRepository.findById(foods.getCategory()).isPresent()){
                Category cate = categoryRepository.findById(foods.getCategory()).get();
                foodEntity.setCategory(cate);
            }
        }
        foodEntity = foodRepository.save(foodEntity);
        logger.info("save food Entity : "+ foodEntity);

        return foods;
    }

    @Override
    public List<FoodDto> getFoodsByRestaurant(String restaurantId) {
        logger.info("entering in findNearByRestaurant");
        List<FoodDto> listOut = new ArrayList<>();
        List<Food> listEntity = foodRepository.getFoodsByRestaurant(restaurantId);
        listEntity.forEach( entity ->{
            listOut.add(FoodConverter.convert(entity));
        });
        return listOut;
    }

    @Override
    public List<FoodDto> getFoodsCategoryAndTag(String category, String tag) {
        logger.info("entering in getFoodsCategoryAndTag");
        logger.info("category : "+category);
        logger.info("tag : "+tag);

        List<FoodDto> listOut = new ArrayList<>();

        List<Food> listEntity = foodRepository.getFoodsCategory(category);

        logger.info(" listEntity : "+listEntity.size());

        listEntity.forEach( entity ->{
            if(entity.getFoodTags().stream().anyMatch(s -> s.getValue().equals(tag))){
                listOut.add(FoodConverter.convert(entity));
            }
        });

        return listOut;
    }
}
