package com.nabilaitnacer.adsservice.feignclient;

import com.nabilaitnacer.adsservice.dto.AttributeValueRequest;
import com.nabilaitnacer.adsservice.dto.full.AttributeValueResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "specifications-service", url = "http://localhost:8092")
public interface AttributeValueClient {


    @PostMapping("/attributeValues")
    void createAttributeValue(@RequestBody AttributeValueRequest attributeValueRequest, @RequestHeader("Authorization") String token);
}
