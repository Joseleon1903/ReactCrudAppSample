package com.ap.crud.samnple.ReactCrudApp.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Arrays;

@Data
public class FoodDto {

    private String id;
    private String title;
    private String [] foodTags;
    private String [] foodType;
    private String code;
    private boolean isAvailable;
    private String restaurant;
    private Integer rating;
    private String ratingCount;
    private String description;
    private BigDecimal price;
    private AdditivesDto[] additives;
    private String[] imageUrl;
    private Integer version;
    private String category;
    private String time;


    @Override
    public String toString() {
        return "FoodDto{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", foodTags=" + Arrays.toString(foodTags) +
                ", foodType=" + Arrays.toString(foodType) +
                ", code='" + code + '\'' +
                ", isAvailable=" + isAvailable +
                ", restaurant='" + restaurant + '\'' +
                ", rating='" + rating + '\'' +
                ", ratingCount='" + ratingCount + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", additives=" + Arrays.toString(additives) +
                ", imageUrl=" + Arrays.toString(imageUrl) +
                ", version=" + version +
                ", category='" + category + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

}
