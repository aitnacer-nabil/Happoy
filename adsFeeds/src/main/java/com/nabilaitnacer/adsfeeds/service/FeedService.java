package com.nabilaitnacer.adsfeeds.service;

import com.nabilaitnacer.adsfeeds.clients.AdsClient;
import com.nabilaitnacer.adsfeeds.clients.AttributeValueClient;
import com.nabilaitnacer.adsfeeds.clients.MediaServiceClient;
import com.nabilaitnacer.adsfeeds.dto.AdDto;
import com.nabilaitnacer.adsfeeds.dto.AdsDto;
import com.nabilaitnacer.adsfeeds.dto.AttributeValueResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedService {
    private final AttributeValueClient attributeValueClient;
    private final MediaServiceClient mediaServiceClient;
    private final AdsClient adsClient;

    public AdDto getAttributeValueRequestByAdsId(Long adsId) {
        AttributeValueResponse attributeValueResponse = attributeValueClient.getAttributeValueRequestByAdsId(adsId).getBody();
        AdDto adDto = new AdDto();
        adDto.setAttribute(attributeValueResponse);
        adDto.setMedia(mediaServiceClient.getAllMediaByAdId(adsId).getBody());
        adDto.setAd(adsClient.getAdById(adsId).getBody());
        return adDto;
    }
    public List<AdDto> getAllaDS() {
        List<AdsDto> adDto = adsClient.getAllAds().getBody();
        assert adDto != null;
        return adDto.stream().map(adsDto -> {
            AdDto adDto1 = new AdDto();
            adDto1.setAd(adsDto);
            adDto1.setAttribute(attributeValueClient.getAttributeValueRequestByAdsId(adsDto.getId()).getBody());
            adDto1.setMedia(mediaServiceClient.getAllMediaByAdId(adsDto.getId()).getBody());
            return adDto1;
        }).toList();
    }
    public List<AdDto> getAllByUser(String userId) {
        List<AdsDto> adDto = adsClient.getAdsByUserId(userId).getBody();
        assert adDto != null;
        return adDto.stream().map(adsDto -> {
            AdDto adDto1 = new AdDto();
            adDto1.setAd(adsDto);
            adDto1.setAttribute(attributeValueClient.getAttributeValueRequestByAdsId(adsDto.getId()).getBody());
            adDto1.setMedia(mediaServiceClient.getAllMediaByAdId(adsDto.getId()).getBody());
            return adDto1;
        }).toList();
    }
}
