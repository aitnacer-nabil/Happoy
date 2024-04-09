package com.nabilaitnacer.adsservice.service;

import com.nabilaitnacer.adsservice.dto.AdsDto;
import com.nabilaitnacer.adsservice.dto.AdsRequest;
import com.nabilaitnacer.adsservice.dto.AdsUpdate;
import com.nabilaitnacer.adsservice.entity.Ads;

import java.util.List;
import java.util.Optional;

public interface AdsService {
    List<AdsDto> getAllAds();
    AdsDto getAdById(Long id);
    AdsDto saveAd(AdsRequest adsRequest);
    AdsDto updateAd(Long id, AdsUpdate adsUpdate);
    void deleteAd(Long id);

    AdsDto changeAdStatus(Long id, String newStatus);
}
