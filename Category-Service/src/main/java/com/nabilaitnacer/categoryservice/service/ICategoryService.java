package com.nabilaitnacer.categoryservice.service;

import com.nabilaitnacer.categoryservice.dto.CategoryDto;

import java.util.List;

public interface ICategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(Long id ,CategoryDto categoryDto);
    CategoryDto getCategory(Long categoryId);
    List<CategoryDto> getAllCategories();
    void deleteCategory(Long categoryId);
}
