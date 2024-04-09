package com.nabilaitnacer.adsservice.controller;

import com.nabilaitnacer.adsservice.dto.AdsDto;
import com.nabilaitnacer.adsservice.dto.AdsRequest;
import com.nabilaitnacer.adsservice.service.AdsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ads")
public class AdsController {
    private final AdsService adsService;

    @GetMapping("/all")
    public ResponseEntity<List<AdsDto>> getAllAds() {
        return ResponseEntity.ok(adsService.getAllAds());
    }
    @PostMapping("/save")
    public ResponseEntity<AdsDto> saveAd(@RequestBody AdsRequest adsDto) {
        return ResponseEntity.ok(adsService.saveAd(adsDto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<AdsDto> getAdById(@PathVariable Long id) {
        return ResponseEntity.ok(adsService.getAdById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdsDto> updateAd(@PathVariable Long id, @RequestBody AdsRequest adsDto) {
        return ResponseEntity.ok(adsService.updateAd(id, adsDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAd(@PathVariable Long id) {
        adsService.deleteAd(id);
        return ResponseEntity.noContent().build();
    }




}
