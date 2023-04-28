package com.example.ohmall.controllers;

import com.example.ohmall.dtos.CategoriesDto;
import com.example.ohmall.models.entity.Category;
import com.example.ohmall.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public CategoriesDto list() {
        List<Category> categories = categoryService.list();

        return new CategoriesDto(categories.stream()
                .map(Category::toDto)
                .toList());
    }
}
