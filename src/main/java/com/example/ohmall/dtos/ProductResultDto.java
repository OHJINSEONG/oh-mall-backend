package com.example.ohmall.dtos;

public class ProductResultDto {
    private Long id;
    private String name;
    private Integer value;

    public ProductResultDto() {
    }

    public ProductResultDto(Long id, String name, Integer value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getValue() {
        return value;
    }
}
