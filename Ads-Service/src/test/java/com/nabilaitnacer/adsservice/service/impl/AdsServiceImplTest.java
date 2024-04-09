package com.nabilaitnacer.adsservice.service.impl;

import com.nabilaitnacer.adsservice.dto.AdsDto;
import com.nabilaitnacer.adsservice.dto.AdsRequest;
import com.nabilaitnacer.adsservice.entity.Ads;
import com.nabilaitnacer.adsservice.entity.AdsStatus;
import com.nabilaitnacer.adsservice.repository.AdsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import static org.mockito.ArgumentMatchers.any;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AdsServiceImplTest {
    @Mock
    private AdsRepository adsRepository;
    @InjectMocks
    private AdsServiceImpl adsService;
    private ModelMapper modelMapper;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        modelMapper= new ModelMapper();
        adsService = new AdsServiceImpl(adsRepository, modelMapper);
    }
    @Test
    @DisplayName("Should map ads to adsDto when saving ads")
    void saveAd() {
        // given
        AdsRequest ads = new AdsRequest();
        ads.setTitle("Test Title");
        ads.setCategory("Test Category");
        ads.setCity("Test City");
        ads.setPrice(BigDecimal.valueOf(100));
        ads.setStatus(AdsStatus.PUBLISHED);
        ads.setDescription("Test Description");
        ads.setUserId(1L);
        ads.setCategory("Test Category");
        ads.setCity("Test City");
        // when
        when(adsRepository.save(any(Ads.class))).thenReturn(modelMapper.map(ads, Ads.class));

        AdsDto savedAdsDto = adsService.saveAd(ads);
        assertNotNull(savedAdsDto);
        assertNotNull(savedAdsDto);
        assertEquals(ads.getTitle(), savedAdsDto.getTitle());
        assertEquals(ads.getTitle(), savedAdsDto.getTitle());
        assertEquals(ads.getDescription(), savedAdsDto.getDescription());
        assertEquals(ads.getDescription(), savedAdsDto.getDescription());
        assertEquals(ads.getUserId(), savedAdsDto.getUserId());
        assertEquals(ads.getUserId(), savedAdsDto.getUserId());
        assertEquals(ads.getCategory(), savedAdsDto.getCategory());
        assertEquals(ads.getCity(), savedAdsDto.getCity());
        assertEquals(ads.getCategory(), savedAdsDto.getCategory());
        assertEquals(ads.getCity(), savedAdsDto.getCity());
        assertEquals(0, ads.getPrice().compareTo(savedAdsDto.getPrice()));
        assertEquals(0, ads.getPrice().compareTo(savedAdsDto.getPrice()));
        assertEquals(ads.getStatus(), savedAdsDto.getStatus());
    }


}