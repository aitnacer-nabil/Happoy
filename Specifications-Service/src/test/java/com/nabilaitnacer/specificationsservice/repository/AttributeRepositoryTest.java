package com.nabilaitnacer.specificationsservice.repository;

import com.nabilaitnacer.specificationsservice.entity.Attribute;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AttributeRepositoryTest {
        @Autowired
        private AttributeRepository  attributeRepository;
        @Autowired
        private AttributeValueRepository attributeValueRepository;
        private static  Attribute attribute;
        @Test
        @Order(1)
        void loadContext() {
           assertNotNull(attributeRepository);
              assertNotNull(attributeValueRepository);
        }
        @Test
        @DisplayName("Save attribute")
        void shouldSaveAttribute() {
            Attribute attribute = new Attribute();
            attribute.setName("Color");
            attribute.setCategoryId(1L);
            Attribute savedAttribute = attributeRepository.save(attribute);
            assertNotNull(savedAttribute);
            assertNotNull(savedAttribute.getId());
            assertEquals(attribute.getName(), savedAttribute.getName());
            assertEquals(attribute.getCategoryId(), savedAttribute.getCategoryId());
            attribute = savedAttribute;
        }
    @Test
    @DisplayName("Find attribute by id")
    void shouldFindAttributeById() {
        // Arrange
        Attribute attribute = new Attribute();
        attribute.setName("Size");
        attribute.setCategoryId(1L);
        Attribute savedAttribute = attributeRepository.save(attribute);

        // Act
        Optional<Attribute> foundAttribute = attributeRepository.findById(savedAttribute.getId());

        // Assert
        assertTrue(foundAttribute.isPresent());
        assertEquals(savedAttribute.getId(), foundAttribute.get().getId());
        assertEquals(savedAttribute.getName(), foundAttribute.get().getName());
        assertEquals(savedAttribute.getCategoryId(), foundAttribute.get().getCategoryId());
    }
    //create attribute with same name
    //throws exception
}