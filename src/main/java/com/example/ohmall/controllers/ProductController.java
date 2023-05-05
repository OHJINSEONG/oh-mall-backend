package com.example.ohmall.controllers;

import com.example.ohmall.dtos.PageDto;
import com.example.ohmall.dtos.ProductResultDto;
import com.example.ohmall.dtos.ProductsDto;
import com.example.ohmall.exceptions.CategoryNotFound;
import com.example.ohmall.exceptions.InvalidPrice;
import com.example.ohmall.exceptions.ProductNotFound;
import com.example.ohmall.models.entity.Product;
import com.example.ohmall.services.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("{productId}")
    @ApiOperation(value = "Find Product", notes = "find product by id")
    public ProductResultDto product(
            @PathVariable Long productId
    ) {
        Product product = productService.find(productId);

        return product.toDto();
    }

    @GetMapping
    @ApiOperation(value = "Fetch Products", notes = "fetch products by page and category")
    public ProductsDto listByCategory(
            @RequestParam(required = true) Long categoryId,
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
