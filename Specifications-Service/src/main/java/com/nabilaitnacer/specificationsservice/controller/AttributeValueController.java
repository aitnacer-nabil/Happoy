package com.nabilaitnacer.specificationsservice.controller;


import com.nabilaitnacer.specificationsservice.dto.AttributeValueDto;
import com.nabilaitnacer.specificationsservice.dto.AttributeValueRequest;
import com.nabilaitnacer.specificationsservice.services.AttributeValueService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attributeValues")
@RequiredArgsConstructor
@Slf4j
public class AttributeValueController {

    private final AttributeValueService attributeValueService;



    @GetMapping("/ad/{adsId}")
    public ResponseEntity<AttributeValueRequest> getAttributeValueRequestByAdsId(@PathVariable Long adsId) {
        log.info("Getting attribute value request by ads id: {}", adsId);
        AttributeValueRequest attributeValueRequest = attributeValueService.getAttributeValueRequestByAdsId(adsId);
        log.info("Attribute value request: {}", attributeValueRequest);

        return ResponseEntity.ok(attributeValueRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttributeValueDto> getAttributeValueById(@PathVariable Long id) {
        return ResponseEntity.ok(attributeValueService.getAttributeValueById(id));
    }

    @PostMapping
    public ResponseEntity<Void> createAttributeValue(@RequestBody AttributeValueRequest  attributeValueDto) {
        attributeValueService.createAttributeValue(attributeValueDto);
        return ResponseEntity.ok().build();
    }




}