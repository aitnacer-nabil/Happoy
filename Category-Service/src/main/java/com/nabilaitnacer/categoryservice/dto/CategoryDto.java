package com.nabilaitnacer.categoryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.nabilaitnacer.categoryservice.entity.Category}
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class CategoryDto implements Serializable {
    private  Long id;
    private  String name;
    private  String description;
    private  Long parentId;
}