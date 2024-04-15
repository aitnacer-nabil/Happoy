package com.nabilaitnacer.adsfeeds.controller;

import com.nabilaitnacer.adsfeeds.dto.AdDto;
import com.nabilaitnacer.adsfeeds.dto.AttributeValueResponse;
import com.nabilaitnacer.adsfeeds.service.FeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/feeds")
@RequiredArgsConstructor
public class HomeFeedsController {
    private final FeedService feedService;
    @GetMapping("ads/{id}")
    public ResponseEntity<AdDto> getHomeFeeds(@PathVariable Long id) {
        return ResponseEntity.ok(feedService.getAttributeValueRequestByAdsId(id));

    }
    @GetMapping
    public ResponseEntity<List<AdDto>> getHomeFeeds() {
        return ResponseEntity.ok(feedService.getAllaDS());
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AdDto>> getAdsByUser(@PathVariable String userId) {
        return ResponseEntity.ok(feedService.getAllByUser(userId));
    }

}
