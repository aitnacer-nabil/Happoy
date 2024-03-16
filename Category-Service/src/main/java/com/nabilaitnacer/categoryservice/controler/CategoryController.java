package com.nabilaitnacer.categoryservice.controler;

import com.nabilaitnacer.categoryservice.dto.CategoriesAllResponseDto;
import com.nabilaitnacer.categoryservice.dto.CategoryDto;
import com.nabilaitnacer.categoryservice.service.ICategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Nabil Ait Nacer
 */
@Tag(
        name = "CRUD REST API for Category in Happoy MarketPlace  microservice",
        description = "CRUD REST API for Category in Happoy MarketPlace  microservice, this API allows to create, read, update and delete categories."

)
@RestController
@RequestMapping(path = "/api/v1/categories", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class CategoryController {
    private final ICategoryService categoryService;

    @Operation(
            summary = "Create a new category",
            description = "Create a new category in the Database"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Category created successfully"),
                    @ApiResponse(responseCode = "400", description = "Invalid input"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            })
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
        return ResponseEntity.ok(categoryService.createCategory(categoryDto));
    }
    @Operation(
            summary = "Update a category",
            description = "Update a category in the Database"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Category updated successfully"),
                    @ApiResponse(responseCode = "400", description = "Invalid input"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            })
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable Long id, @RequestBody CategoryDto categoryDto) {
        return ResponseEntity.ok(categoryService.updateCategory(id, categoryDto));
    }
    @Operation(
            summary = "Get All Categories With Parent",
            description = "Get All Categories With Parent in the Database"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Categories retrieved successfully"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            })
    @GetMapping("/all")
    public ResponseEntity<List<CategoriesAllResponseDto>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

}
