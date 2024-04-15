package com.nabilaitnacer.adsservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AttributeValueRequest {
    private Long adsId;
    private List<AttributeValueDto> attributeValues;

}
