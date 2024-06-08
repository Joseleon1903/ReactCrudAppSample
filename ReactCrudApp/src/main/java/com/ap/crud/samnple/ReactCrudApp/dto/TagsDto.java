package com.ap.crud.samnple.ReactCrudApp.dto;

import lombok.Data;

import java.util.Objects;

@Data
public class TagsDto {

    private Long id;
    private String name;
    private String value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TagsDto tagsDto = (TagsDto) o;
        return Objects.equals(name, tagsDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "TagsDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
