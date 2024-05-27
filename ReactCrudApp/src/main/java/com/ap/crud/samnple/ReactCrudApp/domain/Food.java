package com.ap.crud.samnple.ReactCrudApp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food {

    @Id
    private String id;
    private String title;
    @OneToMany
    private List<Tags> foodTags;
    @OneToMany
    private List<FoodType> foodType;
    private String code;
    private boolean isAvailable;
    @OneToOne
    private Restaurant restaurant;
    private Integer rating;
    private String ratingCount;
    private String description;
    private BigDecimal price;

    @OneToMany
    private List<Additives> additives;
    private String imageUrl;
    private Integer version;
    private String category;
    private String time;


    @Override
    public String toString() {
        return "Food{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", isAvailable=" + isAvailable +
                ", restaurantId=" + restaurant +
                ", rating=" + rating +
                ", ratingCount='" + ratingCount + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", additives=" + additives +
                ", imageUrl='" + imageUrl + '\'' +
                ", version=" + version +
                ", category='" + category + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
