package com.example.ohmall.controllers;

import com.example.ohmall.dtos.PageDto;
import com.example.ohmall.dtos.ProductResultDto;
import com.example.ohmall.dtos.ProductsDto;
import com.example.ohmall.exceptions.CategoryNotFound;
import com.example.ohmall.exceptions.InvalidPrice;
import com.example.ohmall.exceptions.ProductNotFound;
import com.example.ohmall.models.entity.Product;
import com.example.ohmall.services.CategoryService;
import com.example.ohmall.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
public class ProductController {
    private ProductService productService;
    private CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("{productId}")
    public ProductResultDto product(
            @PathVariable Long productId
    ) {
        Product product = productService.find(productId);

        return product.toDto();
    }

    @GetMapping
    public ProductsDto list(
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false, defaultValue = "1") Integer page
    ) {
        Page<Product> found = productService.list(categoryId, page);

        PageDto pageDto = new PageDto(page, found.getTotalPages(), found.getTotalElements());

        ProductsDto products = new ProductsDto(
                found.stream()
                        .map(Product::toDto)
                        .toList()
        );

        products.setPage(pageDto);

        return products;
    }

    @ExceptionHandler(InvalidPrice.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String invalidPrice(Exception exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(ProductNotFound.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String productNotFound(Exception exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(CategoryNotFound.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String categoryNotFound(Exception exception) {
        return exception.getMessage();
    }
}
