package com.nabilaitnacer.categoryservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.nabilaitnacer.categoryservice.entity.Category}
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
@Schema(
        name = "Category",
        description = "Schema for Category"

)
public class CategoryDto implements Serializable {
    @Schema(
            name = "id",
            description = "The unique identifier of the category",
            example = "1",
            required = false
    )
    private  Long id;
    @Schema(
            name = "name",
            description = "The name of the category",
            example = "Electronics"
    )
    private  String name;
    @Schema(
            name = "description",
            description = "The description of the category",
            example = "All electronics products"
    )
    private  String description;
    @Schema(
            name = "parentId",
            description = "The parent category ",
            example = "1"

    )
    private  Long parentId;
}