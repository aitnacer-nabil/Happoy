package com.nabilaitnacer.categoryservice.repository;

import com.nabilaitnacer.categoryservice.entity.Category;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
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
                .name("Electronics 1 ")
                .description("All electronics products 1")
                .build();

        // When
        Category savedParentCategory = categoryRepository.save(parentCategory);
        Category childCategory = Category.builder()
                .name("Mobile Phones 2")
                .description("All mobile phones 2")
                .parent(savedParentCategory)
                .build();
        Category savedChildCategory = categoryRepository.save(childCategory);

        // Then
        assertNotNull(savedChildCategory);
        assertEquals(savedParentCategory.getId(), savedChildCategory.getParent().getId());
    }


    @Test
    @Order(4)
    void shouldNotCreateChildCategoryWithParentCategoryBeingItself() {
        // Given
        Category category = Category.builder()
                .name("Electronics 3")
                .description("All electronics products 3")
                .build();

        // When
        Category savedCategory = categoryRepository.save(category);
        Category childCategory = Category.builder()
                .name("Mobile Phones 4")
                .description("All mobile phones 3")
                .parent(savedCategory)
                .build();

        // Then
        assertThrows(DataIntegrityViolationException.class, () -> childCategory.setParent(childCategory));


    }
}