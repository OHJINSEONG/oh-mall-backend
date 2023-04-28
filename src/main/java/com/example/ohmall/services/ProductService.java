package com.example.ohmall.services;

import com.example.ohmall.exceptions.CategoryNotFound;
import com.example.ohmall.exceptions.ProductNotFound;
import com.example.ohmall.models.entity.Category;
import com.example.ohmall.models.entity.Product;
import com.example.ohmall.repositories.CategoryRepository;
import com.example.ohmall.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@Transactional
public class ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;

        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public Page<Product> list(Long categoryId,int page) {
        Specification<Product> specification = ((root, query, criteriaBuilder) -> null);

        if (categoryId == null) {
            Category category = categoryRepository.findById(categoryId)
                    .orElseThrow(CategoryNotFound::new);
        }

        Sort sort = Sort.by("id").descending();

        Pageable pageable = PageRequest.of(page - 1, 8, sort);

        Page<Product> products = productRepository.findAll(specification, pageable);

        return products;
    }

    public Product find(Long productId) {
       return productRepository.findById(productId).orElseThrow(ProductNotFound::new);
    }
}
