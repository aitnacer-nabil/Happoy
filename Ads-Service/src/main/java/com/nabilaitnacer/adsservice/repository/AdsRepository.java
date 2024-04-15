package com.nabilaitnacer.adsservice.repository;

import com.nabilaitnacer.adsservice.entity.Ads;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdsRepository  extends JpaRepository<Ads, Long>{
    List<Ads> findAllByUserId(String userId);
}
