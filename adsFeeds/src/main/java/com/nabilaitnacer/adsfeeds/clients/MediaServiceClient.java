package com.nabilaitnacer.adsfeeds.clients;

import com.nabilaitnacer.adsfeeds.dto.MediaDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "media-service", url = "http://localhost:8099/api/v1/media")
public interface MediaServiceClient {
    @GetMapping("/ad/{adId}")
    public ResponseEntity<List<MediaDto>> getAllMediaByAdId(@PathVariable Long adId);
}