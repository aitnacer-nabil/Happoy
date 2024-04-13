package com.nabilaitnacer.specificationsservice.services;

import com.nabilaitnacer.specificationsservice.dto.AttributeDto;

import java.util.List;

/**
 * Service for {@link com.nabilaitnacer.specificationsservice.entity.Attribute}
 */
public interface AttributeService {
    /**
     * Get all attributes
     * @return list of all attributesDto
     */
    List<AttributeDto> getAllAttributes();

    /**
     * Get attribute by id
     * @param id of attribute
     * @return attributeDto
     */
    AttributeDto getAttributeById(Long id);

    /**
     * Create attribute
     * @param attributeDto
     * @return created attributeDto
     */
    AttributeDto createAttribute(AttributeDto attributeDto);

    /**
     * Update attribute
     * @param id of attribute
     * @param attributeDto
     * @return updated attributeDto
     */
    AttributeDto updateAttribute(Long id,AttributeDto attributeDto);

    /**
     * Get attribute by category id
     * @param categoryId
     * @return
     */
    List<AttributeDto> getAttributeByCategoryId(Long categoryId);









}
