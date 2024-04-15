package com.nabilaitnacer.adsfeeds.clients;

import com.nabilaitnacer.adsfeeds.dto.AttributeValueResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "specifications-service", url = "http://localhost:8092/attributeValues")
public interface AttributeValueClient {
    @GetMapping("/ad/{adsId}")
    public ResponseEntity<AttributeValueResponse> getAttributeValueRequestByAdsId(@PathVariable Long adsId);
}
