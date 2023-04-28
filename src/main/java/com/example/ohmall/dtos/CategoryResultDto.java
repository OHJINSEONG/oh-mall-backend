package com.example.ohmall.dtos;

public class CategoryResultDto {
    private Long id;
    private String type;

    public CategoryResultDto() {
    }

    public CategoryResultDto(Long id, String type) {
        this.id = id;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}
