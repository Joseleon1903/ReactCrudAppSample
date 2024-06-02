package com.ap.crud.samnple.ReactCrudApp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {

    @Id
    private String id;
    private String title;
    private String time;
    private Integer distance;
    private String imageUrl;
    private String owner;
    private String code;
    private String logoUrl;
    private Integer rating;
    private Integer ratingCount;
    @OneToOne
    private Coord coords;


    @Override
    public String toString() {
        return "Restaurant{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", time='" + time + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", owner='" + owner + '\'' +
                ", code='" + code + '\'' +
                ", logoUrl='" + logoUrl + '\'' +
                ", rating=" + rating +
                ", ratingCount=" + ratingCount +
                ", coords=" + coords +
                '}';
    }
}
