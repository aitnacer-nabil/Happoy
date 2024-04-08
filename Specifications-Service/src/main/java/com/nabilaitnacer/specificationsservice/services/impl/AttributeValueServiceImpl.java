package com.nabilaitnacer.specificationsservice.services.impl;

import com.nabilaitnacer.specificationsservice.dto.AttributeValueDto;
import com.nabilaitnacer.specificationsservice.dto.AttributeValueRequest;
import com.nabilaitnacer.specificationsservice.entity.AttributeValue;
import com.nabilaitnacer.specificationsservice.exception.ResourceNotFoundException;
import com.nabilaitnacer.specificationsservice.repository.AttributeRepository;
import com.nabilaitnacer.specificationsservice.repository.AttributeValueRepository;
import com.nabilaitnacer.specificationsservice.services.AttributeValueService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AttributeValueServiceImpl implements AttributeValueService  {
    private  final AttributeRepository attributeRepository;
    private final ModelMapper modelMapper;

    private final AttributeValueRepository attributeValueRepository;

    @Override
    public List<AttributeValueDto> getAllAttributeValues() {
        return null;
    }

    @Override
    public AttributeValueDto getAttributeValueById(Long id) {
        return null;
    }

    @Override
    public AttributeValueRequest getAttributeValueRequestByAdsId(Long AdsId) {
        List<AttributeValue> attributeValues = attributeValueRepository.findByAdsId(AdsId);
        log.info("Getting attribute value request by ads id: {}", AdsId);
        log.info("Attribute values: {}", attributeValues);
        AttributeValueRequest attributeValueRequest = new AttributeValueRequest();
        attributeValueRequest.setAdsId(AdsId);
        attributeValues.forEach(attributeValue -> {
            log.info("Attribute value For : {}", attributeValue);
            AttributeValueDto attributeValueDto = modelMapper.map(attributeValue, AttributeValueDto.class);
            log.info("Attribute value dto: {}", attributeValueDto);
            if (attributeValueRequest.getAttributeValues() == null) {
                attributeValueRequest.setAttributeValues(new ArrayList<>());
            }

            attributeValueRequest.getAttributeValues().add(attributeValueDto);
        });
        log.info("Attribute value request: {}", attributeValueRequest);
        return attributeValueRequest;
    }

    @Override
    @Transactional
    public void createAttributeValue(AttributeValueRequest attributeValueRequest)
    {
    log.info("Creating attribute value: {}", attributeValueRequest);
        attributeValueRequest.getAttributeValues().forEach(attributeValueDto -> {
            AttributeValue attributeValue = new AttributeValue();
            attributeValue.setAdsId(attributeValueRequest.getAdsId());
            attributeValue.setAttribute(attributeRepository.findById(attributeValueDto.getAttributeId()).orElseThrow(() -> new ResourceNotFoundException("Category", "id",attributeValueDto.getAttributeId().toString())));
            attributeValue.setValue(attributeValueDto.getValue());
         AttributeValue  attributeValue1 =         attributeValueRepository.save(attributeValue);
        log.info("Attribute value created: {}", attributeValue1);
        });
    }

    @Override
    public AttributeValueDto updateAttributeValue(AttributeValueDto attributeValueDto) {
        return null;
    }

    @Override
    public void deleteAttributeValue(Long id) {

    }
}
