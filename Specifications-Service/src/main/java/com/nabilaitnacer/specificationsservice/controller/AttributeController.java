package com.nabilaitnacer.specificationsservice.controller;

import com.nabilaitnacer.specificationsservice.dto.AttributeDto;
import com.nabilaitnacer.specificationsservice.services.AttributeService;
import com.nabilaitnacer.specificationsservice.services.AttributeValueService;
import jakarta.ws.rs.POST;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for the Attribute entity
 *
 */

@RestController
@RequestMapping("/attributes")
@RequiredArgsConstructor
public class AttributeController {
    private final AttributeService attributeService;



    @GetMapping
    public ResponseEntity<List<AttributeDto>> getAllAttributes() {
        return ResponseEntity.ok(attributeService.getAllAttributes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttributeDto> getAttributeById(@PathVariable Long id) {
        return ResponseEntity.ok(attributeService.getAttributeById(id));
    }

    @PostMapping
    public ResponseEntity<AttributeDto> createAttribute(@RequestBody AttributeDto attributeDto) {
        return ResponseEntity.ok(attributeService.createAttribute(attributeDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AttributeDto> updateAttribute(@PathVariable Long id, @RequestBody AttributeDto attributeDto) {
        return ResponseEntity.ok(attributeService.updateAttribute(id, attributeDto));
    }


}
