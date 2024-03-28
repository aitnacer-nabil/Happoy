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
     * @param attributeDto
     * @return updated attributeDto
     */
    AttributeDto updateAttribute(AttributeDto attributeDto);







}
