package com.nabilaitnacer.categoryservice.repository;

import com.nabilaitnacer.categoryservice.entity.Category;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository  categoryRepository;

    @Test
    @Order(1)
    void shouldSaveCategory() {
        Category category = new Category();
        category.setName("Electronics");
        category.setDescription("All electronics products");
        Category savedCategory = categoryRepository.save(category);
        assertNotNull(savedCategory);
        assertNotNull(savedCategory.getId());
        assertEquals(category.getName(), savedCategory.getName());
        assertEquals(category.getDescription(), savedCategory.getDescription());
    }
    @Test
    @Order(2)
    void shouldCreateChildCategoryWithParentCategory() {
        // Given
        Category parentCategory = Category.builder()
                .name("Electronics")
                .description("All electronics products")
                .build();

        // When
        Category savedParentCategory = categoryRepository.save(parentCategory);
        Category childCategory = Category.builder()
                .name("Mobile Phones")
                .description("All mobile phones")
                .parent(savedParentCategory)
                .build();
        Category savedChildCategory = categoryRepository.save(childCategory);

        // Then
        assertNotNull(savedChildCategory);
        assertEquals(savedParentCategory.getId(), savedChildCategory.getParent().getId());
    }
    @Test
    @Order(3)
    void shouldNotCreateCategoryWithSameName() {
        // Given
        Category category = Category.builder()
                .name("Electronics")
                .description("All electronics products")
                .build();

        // When
        Category savedCategory = categoryRepository.save(category);
        Category duplicateCategory = Category.builder()
                .name("Electronics")
                .description("All electronics products")
                .build();

        // Then
        assertThrows(DataIntegrityViolationException.class, () -> categoryRepository.save(duplicateCategory));
    }

    @Test
    @Order(4)
    void shouldNotCreateChildCategoryWithParentCategoryBeingItself() {
        // Given
        Category category = Category.builder()
                .name("Electronics")
                .description("All electronics products")
                .build();

        // When
        Category savedCategory = categoryRepository.save(category);
        Category childCategory = Category.builder()
                .name("Mobile Phones")
                .description("All mobile phones")
                .parent(savedCategory)
                .build();

        // Then
        assertThrows(DataIntegrityViolationException.class, () -> childCategory.setParent(childCategory));


    }
}