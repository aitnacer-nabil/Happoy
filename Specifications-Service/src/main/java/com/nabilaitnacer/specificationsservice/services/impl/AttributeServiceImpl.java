package com.nabilaitnacer.specificationsservice.services.impl;

import com.nabilaitnacer.specificationsservice.dto.AttributeDto;
import com.nabilaitnacer.specificationsservice.services.AttributeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttributeServiceImpl implements AttributeService {
    private final  AttributeService attributeService;
    @Override
    public List<AttributeDto> getAllAttributes() {
        return null;
    }

    @Override
    public AttributeDto getAttributeById(Long id) {
        return null;
    }

    @Override
    public AttributeDto createAttribute(AttributeDto attributeDto) {
        return null;
    }

    @Override
    public AttributeDto updateAttribute(AttributeDto attributeDto) {
        return null;
    }
}
