package com.nabilaitnacer.adsservice.dto;

import com.nabilaitnacer.adsservice.entity.AdsStatus;
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
public class AdsRequest  implements Serializable {
    String title;
    String description;
    Long userId;
    String category;
    String city;
    BigDecimal price;
    AdsStatus status;

}