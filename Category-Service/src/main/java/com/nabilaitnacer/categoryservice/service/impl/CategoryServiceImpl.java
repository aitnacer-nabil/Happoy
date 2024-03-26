package com.nabilaitnacer.categoryservice.service.impl;

import com.nabilaitnacer.categoryservice.dto.CategoriesAllResponseDto;
import com.nabilaitnacer.categoryservice.dto.CategoryDto;
import com.nabilaitnacer.categoryservice.entity.Category;
import com.nabilaitnacer.categoryservice.exception.ResourceNotFoundException;
import com.nabilaitnacer.categoryservice.repository.CategoryRepository;
import com.nabilaitnacer.categoryservice.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * CategoryRepository interface for Category entity.
 * This interface extends JpaRepository which provides JPA related methods
 * like save(), findById(), findAll(), deleteById() etc. for performing CRUD operations.
 *
 * @author aitnacer-nabil
 */
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    /**
     * Creates a new category.
     *
     * @param categoryDto the category DTO
     * @return the created category DTO
     */
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto, Category.class);

        if (categoryDto.getParentId() != null) {
            category.setParent(getCategoryParent(categoryDto.getParentId() ));
        }
        Category savedCategory = categoryRepository.save(category);
        return modelMapper.map(savedCategory, CategoryDto.class);

    }
    /**
     * Updates an existing category.
     *
     * @param id the id of the category to update
     * @param categoryDto the category DTO with updated values
     * @return the updated category DTO
     */

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
    /**
     * Retrieves a category by its id.
     *
     * @param categoryId the id of the category to retrieve
     * @return the retrieved category DTO
     */
    @Override
    public CategoriesAllResponseDto getCategory(Long categoryId) {
        //TODO: Implement this method
        return null;
    }
    /**
     * Retrieves all categories.
     *
     * @return a list of all categories DTO
     */
    @Override
    public List<CategoriesAllResponseDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        Map<Category, List<CategoryDto>> categoryMap = groupCategoriesByParent(categories, modelMapper);
        List<CategoriesAllResponseDto> categoriesAllResponseDtos = new ArrayList<>();
        categoryMap.forEach((k, v) -> {
            CategoriesAllResponseDto categoriesWithParent = new CategoriesAllResponseDto();
            categoriesWithParent.setId(k.getId());
            categoriesWithParent.setName(k.getName());
            categoriesWithParent.setDescription(k.getDescription());
            categoriesWithParent.setChildren(new ArrayList<>());

            v.forEach(category ->
                    categoriesWithParent.getChildren().add(modelMapper.map(category, CategoryDto.class))
            );

            categoriesAllResponseDtos.add(categoriesWithParent);
        });
        return categoriesAllResponseDtos;
    }

    /**
     * Deletes a category by its id.
     *
     * @param categoryId the id of the category to delete
     */
    @Override
    public void deleteCategory(Long categoryId) {
    //TODO : Implement this method
    }
    /**
     * Retrieves a parent category by its id.
     *
     * @param parentId the id of the parent category to retrieve
     * @return the retrieved parent category
     */
    private Category getCategoryParent(Long parentId) {
        return categoryRepository.findById(parentId)
                .orElseThrow(() -> new ResourceNotFoundException("Parent category", "id", parentId.toString()));
    }
    /**
     * Groups categories by their parent.
     *
     * @param categories the list of categories to group
     * @param modelMapper the ModelMapper to map Category to CategoryDto
     * @return a map of categories grouped by their parent
     */
    private Map<Category, List<CategoryDto>> groupCategoriesByParent(List<Category> categories, ModelMapper modelMapper) {

        return categories.stream()
                .filter(category -> category.getParent() != null)
                .collect(Collectors.groupingBy(Category::getParent,
                        Collectors.mapping(category -> modelMapper.map(category, CategoryDto.class), Collectors.toList())));
    }
}

