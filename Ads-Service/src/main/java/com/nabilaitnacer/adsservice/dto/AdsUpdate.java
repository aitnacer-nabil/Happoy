package com.nabilaitnacer.adsservice.dto;

import com.nabilaitnacer.adsservice.entity.AdsStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdsUpdate {
    Long id;
    String title;
    String description;
    Long userId;
    String category;
    String city;
    BigDecimal price;

}
