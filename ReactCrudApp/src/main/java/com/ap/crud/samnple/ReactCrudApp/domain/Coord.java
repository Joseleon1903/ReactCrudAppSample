package com.ap.crud.samnple.ReactCrudApp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coord {

    @Id
    private String id;
    private String urlLocation;
    private Long latitude;
    private Long longitude;
    private String address;
    private String title;
    private Long latitudeDelta;
    private Long longitudeDelta;

    @Override
    public String toString() {
        return "Coord{" +
                "id='" + id + '\'' +
                ", urlLocation='" + urlLocation + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", address='" + address + '\'' +
                ", title='" + title + '\'' +
                ", latitudeDelta=" + latitudeDelta +
                ", longitudeDelta=" + longitudeDelta +
                '}';
    }
}
