package com.nabilaitnacer.specificationsservice.services;

import com.nabilaitnacer.specificationsservice.dto.AttributeValueDto;
import com.nabilaitnacer.specificationsservice.dto.AttributeValueRequest;
import com.nabilaitnacer.specificationsservice.dto.AttributeValueResponse;

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
     * Get attribute value request by ads id
     * @param AdsId of attribute value
     * @return attribute value request
     */
    AttributeValueResponse getAttributeValueRequestByAdsId(Long AdsId);

/**
     * Create attribute value
     * @param attributeValueRequest
     * @return created attribute value
     */
    void createAttributeValue(AttributeValueRequest attributeValueRequest);

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
