package com.example.ohmall.dtos;

import com.example.ohmall.models.entity.Product;

import java.util.List;

public class ProductsDto {
    private List<ProductResultDto> products;
    private PageDto page;

    public ProductsDto() {
    }

    public ProductsDto(List<ProductResultDto> products) {
        this.products = products;
    }

    public List<ProductResultDto> getProducts() {
        return products;
    }

    public PageDto getPage() {
        return page;
    }

    public void setPage(PageDto page) {
        this.page = page;
    }
}
