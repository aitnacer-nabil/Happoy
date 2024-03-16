package com.nabilaitnacer.categoryservice.service;

import com.nabilaitnacer.categoryservice.dto.CategoriesAllResponseDto;
import com.nabilaitnacer.categoryservice.dto.CategoryDto;

import java.util.List;

public interface ICategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(Long id ,CategoryDto categoryDto);
    CategoriesAllResponseDto getCategory(Long categoryId);
    List<CategoriesAllResponseDto> getAllCategories();
    void deleteCategory(Long categoryId);
}
