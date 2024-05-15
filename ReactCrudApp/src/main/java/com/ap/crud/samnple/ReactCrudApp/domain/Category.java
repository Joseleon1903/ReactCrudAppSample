package com.ap.crud.samnple.ReactCrudApp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    private String id;
    private String title;
    private String value;
    private String imageUrl;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private Integer version;

    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", value='" + value + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", version=" + version +
                '}';
    }
}
