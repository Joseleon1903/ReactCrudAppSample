package com.ap.crud.samnple.ReactCrudApp.dto;

import lombok.Data;

@Data
public class AdditivesDto {

    private Long id;
    private String title;
    private String price;

    @Override
    public String toString() {
        return "AdditivesDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
