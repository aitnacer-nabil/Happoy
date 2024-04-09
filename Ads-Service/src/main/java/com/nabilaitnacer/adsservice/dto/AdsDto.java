package com.nabilaitnacer.adsservice.dto;

import com.nabilaitnacer.adsservice.entity.AdsStatus;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.nabilaitnacer.adsservice.entity.Ads}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdsDto implements Serializable {
    Long id;
    String title;
    String description;
    Long userId;
    String category;
    String city;
    BigDecimal price;
    AdsStatus status;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}