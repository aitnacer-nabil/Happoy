package com.nabilaitnacer.specificationsservice.services;

import com.nabilaitnacer.specificationsservice.dto.AttributeValueDto;

import java.util.List;

/**
 * Service for {@link com.nabilaitnacer.specificationsservice.entity.AttributeValue}
 *
 */
public interface AttributeValueService {
    /**
     * Get all attribute values
     * @return list of all attribute values
     */
    List<AttributeValueDto> getAllAttributeValues();

    /**
     * Get attribute value by id
     * @param id of attribute value
     * @return attribute value
     */
    AttributeValueDto getAttributeValueById(Long id);

    /**
     * Create attribute value
     * @param attributeValueDto
     * @return created attribute value
     */
    AttributeValueDto createAttributeValue(AttributeValueDto attributeValueDto);

    /**
     * Update attribute value
     * @param attributeValueDto
     * @return updated attribute value
     */
    AttributeValueDto updateAttributeValue(AttributeValueDto attributeValueDto);

    /**
     * Delete attribute value
     * @param id of attribute value
     */
    void deleteAttributeValue(Long id);
}
