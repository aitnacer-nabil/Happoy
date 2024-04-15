package com.nabilaitnacer.adsservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.nabilaitnacer.specificationsservice.entity.AttributeValue}
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class AttributeValueDto implements Serializable {
    private  Long id;
    private  String value;
    private  Long attributeId;
}