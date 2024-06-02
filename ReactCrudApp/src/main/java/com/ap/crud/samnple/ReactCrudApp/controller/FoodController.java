package com.ap.crud.samnple.ReactCrudApp.controller;

import com.ap.crud.samnple.ReactCrudApp.dto.FoodDto;
import com.ap.crud.samnple.ReactCrudApp.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value="/api/food")
@CrossOrigin("http://localhost:3000/")
public class FoodController {

    Logger logger = Logger.getLogger(FoodController.class.getName());

    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<FoodDto>> findAll(){
        List<FoodDto> entityList = foodService.getAll();
        return new ResponseEntity<>(entityList, HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<FoodDto> saveFood( @RequestBody FoodDto food){
        FoodDto foodOut = foodService.saveFood(food);
        return new ResponseEntity<>(foodOut, HttpStatus.OK);
    }

    @GetMapping("/{restaurantId}")
    @ResponseBody
    public ResponseEntity<List<FoodDto>> findByRestaurant(@PathVariable("restaurantId") String restaurantId){
        List<FoodDto> entityList = foodService.getFoodsByRestaurant(restaurantId);
        return new ResponseEntity<>(entityList, HttpStatus.OK);
    }

    @GetMapping("/{category}/{tag}")
    @ResponseBody
    public ResponseEntity<List<FoodDto>> findByRestaurant(@PathVariable("category") String category,@PathVariable("tag") String tag){

        List<FoodDto> entityList = foodService.getFoodsCategoryAndTag(category, tag);
        return new ResponseEntity<>(entityList, HttpStatus.OK);
    }


}
