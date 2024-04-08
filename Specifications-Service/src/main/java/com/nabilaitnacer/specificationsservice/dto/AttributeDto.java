package com.nabilaitnacer.specificationsservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.nabilaitnacer.specificationsservice.entity.Attribute}
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class AttributeDto implements Serializable {
    private  Long id;
    private  String name;
    private  long categoryId;
}