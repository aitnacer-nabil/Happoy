package com.nabilaitnacer.specificationsservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * DTO for {@link com.nabilaitnacer.specificationsservice.entity.Attribute}
 */
@AllArgsConstructor
@Getter
public class AttributeDto implements Serializable {
    private final Long id;
    private final String name;
    private final long categoryId;
}