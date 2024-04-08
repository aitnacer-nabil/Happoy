package com.nabilaitnacer.specificationsservice.repository;

import com.nabilaitnacer.specificationsservice.entity.AttributeValue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttributeValueRepository  extends JpaRepository<AttributeValue, Long>{
    List<AttributeValue> findByAdsId(Long adsId);
}
