package com.nabilaitnacer.adsfeeds.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdsDto implements Serializable {
    Long id;
    String title;
    String description;
    String userId;
    String category;
    String city;
    BigDecimal price;
    AdsStatus status;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

}