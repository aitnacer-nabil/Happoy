package com.nabilaitnacer.specificationsservice.services.impl;

import com.nabilaitnacer.specificationsservice.dto.AttributeValueDto;
import com.nabilaitnacer.specificationsservice.services.AttributeValueService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class AttributeValueServiceImpl implements AttributeValueService  {
    private  final AttributeValueService attributeValueService;

    @Override
    public List<AttributeValueDto> getAllAttributeValues() {
        return null;
    }

    @Override
    public AttributeValueDto getAttributeValueById(Long id) {
        return null;
    }

    @Override
    public AttributeValueDto createAttributeValue(AttributeValueDto attributeValueDto) {
        return null;
    }

    @Override
    public AttributeValueDto updateAttributeValue(AttributeValueDto attributeValueDto) {
        return null;
    }

    @Override
    public void deleteAttributeValue(Long id) {

    }
}
