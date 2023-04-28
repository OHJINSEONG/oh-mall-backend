package com.example.ohmall.dtos;

import java.util.List;

public class CategoriesDto {
    private List<CategoryResultDto> categories;

    public CategoriesDto() {
    }

    public CategoriesDto(List<CategoryResultDto> categories) {
        this.categories = categories;
    }

    public List<CategoryResultDto> getCategories() {
        return categories;
    }
}
