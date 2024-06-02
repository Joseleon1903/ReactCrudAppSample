package com.ap.crud.samnple.ReactCrudApp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food {

    @Id
    private String id;
    private String title;
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Tags> foodTags = new HashSet<>();
    @OneToMany(fetch = FetchType.EAGER)
    private Set<FoodType> foodType= new HashSet<>();;
    private String code;
    private boolean isAvailable;
    @ManyToOne(fetch = FetchType.EAGER)
    private Restaurant restaurant;
    private Integer rating;
    private String ratingCount;
    private String description;
    private BigDecimal price;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Additives> additives = new HashSet<>();
    private String imageUrl;
    private Integer version;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

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
