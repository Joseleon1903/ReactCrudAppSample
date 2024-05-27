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
public class FoodType {

    @Id
    private Long id;
    private String value;


    @Override
    public String toString() {
        return "FoodType{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
