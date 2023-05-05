package com.example.ohmall.dtos;

public class PageDto {
    private Integer page;
    private int totalPages;
    private long totalElements;

    public PageDto(Integer page, int totalPages, long totalElements) {
        this.page = page;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
    }

    public Integer getPage() {
        return page;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public long getTotalElements() {
        return totalElements;
    }
}
