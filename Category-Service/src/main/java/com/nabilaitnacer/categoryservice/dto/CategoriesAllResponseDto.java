package com.nabilaitnacer.categoryservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        name = "Categorires With Parent",
        description = "Schema for Categories With Parent"

)
public class CategoriesAllResponseDto {
    @Schema(
            name = "id",
            description = "The unique identifier of the Parent category ",
            example = "1"
    )
    private  Long id;
    @Schema(
            name = "name",
            description = "The name of the Parent category ",
            example = "Electronics"
    )
    private  String name;
    @Schema(
            name = "description",
            description = "The description of the Parent category ",
            example = "All electronics products"
    )
    private  String description;
    @Schema(
            name = "children",
            description = "The children categories of the Parent category ",
            example = "List of children categories"
    )
    private List<CategoryDto> children;
}
