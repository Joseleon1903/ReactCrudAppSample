package com.ap.crud.samnple.ReactCrudApp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Discount {

    @Id
    private Long id;

    private Integer percent;

    @OneToOne(fetch = FetchType.EAGER)
    private Food food;


    @Override
    public String toString() {
        return "Discount{" +
                "id=" + id +
                ", percent=" + percent +
                ", food=" + food +
                '}';
    }
}
