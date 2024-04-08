package com.nabilaitnacer.specificationsservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AttributeValueRequest {
    private Long adsId;
    private List<AttributeValueDto> attributeValues;

}
