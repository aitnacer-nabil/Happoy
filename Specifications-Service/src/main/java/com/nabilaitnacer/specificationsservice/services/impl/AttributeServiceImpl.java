package com.nabilaitnacer.specificationsservice.services.impl;

import com.nabilaitnacer.specificationsservice.dto.AttributeDto;
import com.nabilaitnacer.specificationsservice.entity.Attribute;
import com.nabilaitnacer.specificationsservice.exception.ResourceNotFoundException;
import com.nabilaitnacer.specificationsservice.repository.AttributeRepository;
import com.nabilaitnacer.specificationsservice.services.AttributeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AttributeServiceImpl implements AttributeService {
    private final AttributeRepository attributeRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<AttributeDto> getAllAttributes() {
      List<Attribute> attributes = attributeRepository.findAll();
            return attributes.stream().map(attribute -> modelMapper.map(attribute, AttributeDto.class)).toList();
    }

    @Override
    public AttributeDto getAttributeById(Long id)
    {
        Optional<Attribute> attribute = attributeRepository.findById(id).or(() -> {
            throw new ResourceNotFoundException("Attribute", "id", id.toString());
        });
            return modelMapper.map(attribute.get(), AttributeDto.class);
    }

    @Override
    public AttributeDto createAttribute(AttributeDto attributeDto) {
        Attribute attribute = modelMapper.map(attributeDto, Attribute.class);
        Attribute savedAttribute = attributeRepository.save(attribute);
        return modelMapper.map(savedAttribute, AttributeDto.class);

    }

    @Override
    public AttributeDto updateAttribute(Long id, AttributeDto attributeDto) {
        Attribute Attribute = attributeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Attribute", "id", id.toString()));
        if (attributeDto.getName() != null) {
            Attribute.setName(attributeDto.getName());
        }
    return modelMapper.map(attributeRepository.save(Attribute), AttributeDto.class);

    }
}
