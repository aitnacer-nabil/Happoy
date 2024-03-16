package com.nabilaitnacer.categoryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriesAllResponseDto {
    private  Long id;
    private  String name;
    private  String description;
    private List<CategoryDto> children;
}
