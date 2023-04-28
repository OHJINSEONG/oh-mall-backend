package com.example.ohmall.models.entity;

import com.example.ohmall.dtos.CategoryResultDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Category {
    @Id
    @GeneratedValue
    private Long id;

    private String type;

    public Category() {
    }

    public Category(Long id, String type) {
        this.id = id;
        this.type = type;
    }

    public CategoryResultDto toDto() {
        return new CategoryResultDto(id, type);
    }
}
