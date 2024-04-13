package com.nabilaitnacer.adsservice.controller;

import com.nabilaitnacer.adsservice.dto.AdsDto;
import com.nabilaitnacer.adsservice.dto.AdsRequest;
import com.nabilaitnacer.adsservice.dto.AdsStatusDto;
import com.nabilaitnacer.adsservice.dto.AdsUpdate;
import com.nabilaitnacer.adsservice.service.AdsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * AdsController class.
 * This class is a REST controller for managing ads.
 * It provides endpoints for creating, updating, and retrieving ads.
 * It is annotated with @RestController, @RequestMapping, and @RequiredArgsConstructor.
 * It uses the AdsService to perform operations on the ads.
 *
 * @Author Nabil Ait Nacer
 */
@Tag(
        name = "CRUD REST API for Ads in Happoy MarketPlace  microservice",
        description = "CRUD REST API for Ads in Happoy MarketPlace  microservice, this API allows to create, read, update and delete ads."


)
@RestController
@RequiredArgsConstructor
@RequestMapping("/ads")
public class AdsController {
    private final AdsService adsService;

    @Operation(
            summary = "Get all ads",
            description = "Get all ads from the Database"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Ads retrieved successfully"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            })
    @GetMapping("/all")
    public ResponseEntity<List<AdsDto>> getAllAds() {
        return ResponseEntity.ok(adsService.getAllAds());
    }
    @Operation(
            summary = "Create a new ad",
            description = "Create a new ad in the Database"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Ad created successfully"),
                    @ApiResponse(responseCode = "409", description = "Invalid input"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            })
    @PostMapping("/save")
    public ResponseEntity<AdsDto> saveAd(@RequestBody AdsRequest adsDto) {
        return ResponseEntity.ok(adsService.saveAd(adsDto));
    }
    @Operation(
            summary = "Get an ad by id",
            description = "Get an ad by id from the Database"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Ad retrieved successfully"),
                    @ApiResponse(responseCode = "404", description = "Ad not found"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            })
    @GetMapping("/{id}")
    public ResponseEntity<AdsDto> getAdById(@PathVariable Long id) {
        return ResponseEntity.ok(adsService.getAdById(id));
    }
    @Operation(
            summary = "Update an ad",
            description = "Update an ad in the Database"
    )
@ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Ad updated successfully"),
                    @ApiResponse(responseCode = "404", description = "Ad not found"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            })
    @PutMapping("/{id}")
    public ResponseEntity<AdsDto> updateAd(@PathVariable Long id, @RequestBody AdsUpdate adsDto) {
        return ResponseEntity.ok(adsService.updateAd(id, adsDto));
    }
    @Operation(
            summary = "Delete an ad",
            description = "Delete an ad from the Database"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "204", description = "Ad deleted successfully"),
                    @ApiResponse(responseCode = "404", description = "Ad not found"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAd(@PathVariable Long id) {
        adsService.deleteAd(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Change the status of an ad",
            description = "Change the status of an ad in the Database"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Ad status changed successfully"),
                    @ApiResponse(responseCode = "404", description = "Ad not found"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            })
    @PutMapping("/{id}/status")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<AdsDto> changeAdStatus(@PathVariable Long id, @RequestBody AdsStatusDto adsStatusDto) {
        return ResponseEntity.ok(adsService.changeAdStatus(id, adsStatusDto.getStatus()));
    }


}
