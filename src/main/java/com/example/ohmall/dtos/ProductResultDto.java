package com.example.ohmall.dtos;

public class ProductResultDto {
    private Long id;
    private String name;
    private Integer value;
    private String description;
    private String image;

    public ProductResultDto() {
    }

    public ProductResultDto(Long id, String name, Integer value, String description, String image) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.description = description;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public Integer getValue() {
        return value;
    }

    public String getImage() {
        return image;
    }
}
