package com.nabilaitnacer.categoryservice.service.impl;

import com.nabilaitnacer.categoryservice.dto.CategoryDto;
import com.nabilaitnacer.categoryservice.entity.Category;
import com.nabilaitnacer.categoryservice.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CategoryServiceImplTest {
    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    private ModelMapper modelMapper;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        modelMapper= new ModelMapper();
        categoryService = new CategoryServiceImpl(categoryRepository, modelMapper);
    }
    @Test
    @DisplayName("Should map category to categoryDto when creating category")
    void shouldMapCategoryToCategoryDtoWhenCreatingCategory() {
        // Given
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName("Electronics");
        categoryDto.setDescription("All electronics products");

        Category category = modelMapper.map(categoryDto, Category.class);
        category.setId(1L);
        given(categoryRepository.save(any(Category.class))).willReturn(category);

        // When
        CategoryDto result = categoryService.createCategory(categoryDto);

        // Then
        assertEquals(categoryDto.getName(), result.getName());
        assertEquals(categoryDto.getDescription(), result.getDescription());
        assertEquals(category.getId(), result.getId());
    }
    @Test
    @DisplayName("Should update category and map to CategoryDto")
    void shouldUpdateCategoryAndMapToCategoryDto() {
        // Given
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName("Updated Electronics");
        categoryDto.setDescription("Updated description");

        Category existingCategory = new Category();
        existingCategory.setId(1L);
        existingCategory.setName("Electronics");
        existingCategory.setDescription("All electronics products");

        Category updatedCategory = new Category();
        updatedCategory.setId(1L);
        updatedCategory.setName(categoryDto.getName());
        updatedCategory.setDescription(categoryDto.getDescription());

        given(categoryRepository.findById(1L)).willReturn(Optional.of(existingCategory));
        given(categoryRepository.save(any(Category.class))).willReturn(updatedCategory);

        // When
        CategoryDto result = categoryService.updateCategory(1L, categoryDto);

        // Then
        assertEquals(categoryDto.getName(), result.getName());
        assertEquals(categoryDto.getDescription(), result.getDescription());
    }


}