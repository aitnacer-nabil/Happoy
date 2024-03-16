package com.nabilaitnacer.categoryservice.service.impl;

import com.nabilaitnacer.categoryservice.dto.CategoryDto;
import com.nabilaitnacer.categoryservice.entity.Category;
import com.nabilaitnacer.categoryservice.exception.ResourceNotFoundException;
import com.nabilaitnacer.categoryservice.repository.CategoryRepository;
import com.nabilaitnacer.categoryservice.service.ICategoryService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto, Category.class);

        if (categoryDto.getParentId() != null) {
            category.setParent(getCategoryParent(categoryDto.getParentId() ));
        }
        Category savedCategory = categoryRepository.save(category);
        return modelMapper.map(savedCategory, CategoryDto.class);

    }

    @Override
    public CategoryDto updateCategory(Long id ,CategoryDto categoryDto) {
        Category category  = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", id.toString()));
        if(categoryDto.getName() != null) {
            category.setName(categoryDto.getName());
        }
        if(categoryDto.getDescription() != null) {
            category.setDescription(categoryDto.getDescription());
        }
        if(categoryDto.getParentId() != null) {
            category.setParent(getCategoryParent(categoryDto.getParentId() ));
        }
        Category updatedCategory = categoryRepository.save(category);
        return modelMapper.map(updatedCategory, CategoryDto.class);

    }

    @Override
    public CategoryDto getCategory(Long categoryId) {
        return null;
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return null;
    }

    @Override
    public void deleteCategory(Long categoryId) {

    }

    private Category getCategoryParent(Long parentId) {
        return categoryRepository.findById(parentId)
                .orElseThrow(() -> new ResourceNotFoundException("Parent category", "id", parentId.toString()));
    }
}

