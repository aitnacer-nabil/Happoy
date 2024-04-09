package com.nabilaitnacer.adsservice.repository;

import com.nabilaitnacer.adsservice.entity.Ads;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdsRepository  extends JpaRepository<Ads, Long>{
}
