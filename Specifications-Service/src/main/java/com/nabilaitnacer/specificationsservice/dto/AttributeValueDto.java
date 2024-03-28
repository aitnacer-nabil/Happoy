package com.nabilaitnacer.specificationsservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * DTO for {@link com.nabilaitnacer.specificationsservice.entity.AttributeValue}
 */
@AllArgsConstructor
@Getter
public class AttributeValueDto implements Serializable {
    private final Long id;
    private final String value;
    private final Long attributeId;
    private final String attributeName;
    private final Long adsId;
}