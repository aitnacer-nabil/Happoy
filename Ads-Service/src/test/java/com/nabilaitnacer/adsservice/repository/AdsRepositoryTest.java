package com.nabilaitnacer.adsservice.repository;

import com.nabilaitnacer.adsservice.entity.Ads;
import com.nabilaitnacer.adsservice.entity.AdsStatus;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AdsRepositoryTest {
    @Autowired
    private AdsRepository  adsRepository;

    @Test
    @DisplayName("Test AdsRepository Save")
    void testAdsRepositorySave() {
        // given
        Ads ads = new Ads();
        ads.setTitle("Test Title");
        ads.setDescription("Test Description");
        ads.setUserId(1L);
        ads.setCategory("Test Category");
        ads.setCity("Test City");
        ads.setPrice(BigDecimal.valueOf(100));
        ads.setStatus(AdsStatus.PUBLISHED);
        ads.setCreatedAt(LocalDateTime.now());
        ads.setUpdatedAt(LocalDateTime.now());
        // when
        Ads savedAds = adsRepository.save(ads);
        // then
        assertNotNull(savedAds);
        assertNotNull(savedAds.getId());
        assertEquals(ads.getTitle(), savedAds.getTitle());
        assertEquals(ads.getDescription(), savedAds.getDescription());
        assertEquals(ads.getUserId(), savedAds.getUserId());
        assertEquals(ads.getCategory(), savedAds.getCategory());
        assertEquals(ads.getCity(), savedAds.getCity());
        assertEquals(ads.getPrice(), savedAds.getPrice());
        assertEquals(ads.getStatus(), savedAds.getStatus());
        assertEquals(ads.getCreatedAt(), savedAds.getCreatedAt());
        assertEquals(ads.getUpdatedAt(), savedAds.getUpdatedAt());
    }
    @Test
    @DisplayName("Test AdsRepository Find By Id")

    void testAdsRepositoryFindById() {
        // given
        Ads ads = new Ads();
        ads.setTitle("Test Title");
        ads.setDescription("Test Description");
        ads.setUserId(1L);
        ads.setCategory("Test Category");
        ads.setCity("Test City");
        ads.setPrice(BigDecimal.valueOf(100));
        ads.setStatus(AdsStatus.PUBLISHED);
        ads.setCreatedAt(LocalDateTime.now());
        ads.setUpdatedAt(LocalDateTime.now());
        Ads savedAds = adsRepository.save(ads);
        // when
        Ads foundAds = adsRepository.findById(savedAds.getId()).orElse(null);
        // then
        assertNotNull(foundAds);
        assertNotNull(foundAds.getId());
        assertEquals(ads.getTitle(), foundAds.getTitle());
        assertEquals(ads.getDescription(), foundAds.getDescription());
        assertEquals(ads.getUserId(), foundAds.getUserId());
        assertEquals(ads.getCategory(), foundAds.getCategory());
        assertEquals(ads.getCity(), foundAds.getCity());
        assertEquals(ads.getPrice(), foundAds.getPrice());
        assertEquals(ads.getStatus(), foundAds.getStatus());
        assertEquals(ads.getCreatedAt(), foundAds.getCreatedAt());
        assertEquals(ads.getUpdatedAt(), foundAds.getUpdatedAt());
    }
    @Test
    @DisplayName("Test AdsRepository Delete")
    void testAdsRepositoryDelete() {
        // given
        Ads ads = new Ads();
        ads.setTitle("Test Title");
        ads.setDescription("Test Description");
        ads.setUserId(1L);
        ads.setCategory("Test Category");
        ads.setCity("Test City");
        ads.setPrice(BigDecimal.valueOf(100));
        ads.setStatus(AdsStatus.PUBLISHED);
        ads.setCreatedAt(LocalDateTime.now());
        ads.setUpdatedAt(LocalDateTime.now());
        Ads savedAds = adsRepository.save(ads);
        // when
        adsRepository.deleteById(savedAds.getId());
        // then
        Ads foundAds = adsRepository.findById(savedAds.getId()).orElse(null);
        assertNull(foundAds);
    }
}