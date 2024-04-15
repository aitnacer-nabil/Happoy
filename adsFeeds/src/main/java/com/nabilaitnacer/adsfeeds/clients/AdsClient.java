package com.nabilaitnacer.adsfeeds.clients;

import com.nabilaitnacer.adsfeeds.dto.AdsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ads-service", url = "http://localhost:8072/ads")
public interface AdsClient {
    @GetMapping("/{id}")
     ResponseEntity<AdsDto> getAdById(@PathVariable Long id);

    @GetMapping("/all")
     ResponseEntity<List<AdsDto>> getAllAds();

    @GetMapping("/user/{userId}")
     ResponseEntity<List<AdsDto>> getAdsByUserId(@PathVariable String userId);
}
