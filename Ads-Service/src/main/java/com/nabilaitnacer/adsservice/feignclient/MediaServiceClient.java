package com.nabilaitnacer.adsservice.feignclient;

import com.nabilaitnacer.adsservice.dto.UploadResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@FeignClient(name = "media-service", url = "http://localhost:8099/api/v1/media")
public interface MediaServiceClient {
    @PostMapping(value = "/list", consumes = "multipart/form-data")
    ResponseEntity<UploadResponse> uploadListMedia(@RequestPart("files") List<MultipartFile> files, @RequestPart("adId") Long adId, @RequestHeader("Authorization") String token);
}