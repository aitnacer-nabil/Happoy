package com.nabilaitnacer.adsservice.service.impl;

import com.nabilaitnacer.adsservice.dto.AdsDto;
import com.nabilaitnacer.adsservice.dto.AdsRequest;
import com.nabilaitnacer.adsservice.dto.AdsUpdate;
import com.nabilaitnacer.adsservice.entity.Ads;
import com.nabilaitnacer.adsservice.entity.AdsStatus;
import com.nabilaitnacer.adsservice.exception.ResourceNotFoundException;
import com.nabilaitnacer.adsservice.repository.AdsRepository;
import com.nabilaitnacer.adsservice.service.AdsService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.nio.file.ReadOnlyFileSystemException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdsServiceImpl  implements AdsService {
    private final AdsRepository adsRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<AdsDto> getAllAds() {
        return adsRepository.findAll().stream().map(ads -> modelMapper.map(ads, AdsDto.class)).toList();

    }

    @Override
    public  AdsDto getAdById(Long id) {
        return modelMapper.map( getAds(id),AdsDto.class);
    }

    @Override
    public AdsDto saveAd(AdsRequest adsRequest) {
        Ads ads = modelMapper.map(adsRequest,Ads.class);
        Ads savedAds = adsRepository.save(ads);
        return modelMapper.map(savedAds,AdsDto.class);
    }

    @Override
    public AdsDto updateAd(Long id , AdsUpdate adsUpdate) {
        Ads ads = getAds(id);
        if(adsUpdate.getTitle() != null) {
            ads.setTitle(adsUpdate.getTitle());
        }
        if(adsUpdate.getDescription() != null) {
            ads.setDescription(adsUpdate.getDescription());
        }
        if(adsUpdate.getPrice() != null) {
            ads.setPrice(adsUpdate.getPrice());
        }
        if(adsUpdate.getCategory() != null) {
            ads.setCategory(adsUpdate.getCategory());
        }
        if(adsUpdate.getCity() != null) {
            ads.setCity(adsUpdate.getCity());
        }

        Ads updatedAds = adsRepository.save(ads);
        return modelMapper.map(updatedAds,AdsDto.class);
    }

    @Override
    public void deleteAd(Long id) {
        Ads ads = getAds(id);
        adsRepository.delete(ads);
    }

    @Override
    public AdsDto changeAdStatus(Long id, String newStatus) {
        AdsStatus adsStatus = AdsStatus.valueOf(newStatus);
        Ads ads = getAds(id);
        ads.setStatus(adsStatus)   ;
        Ads updatedAds = adsRepository.save(ads);
        return modelMapper.map(updatedAds,AdsDto.class);
    }

    private Ads getAds(Long id) {
        return adsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ads", "id", id.toString()));
    }
}
