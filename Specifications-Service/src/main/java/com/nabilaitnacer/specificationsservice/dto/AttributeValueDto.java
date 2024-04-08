package com.nabilaitnacer.specificationsservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
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