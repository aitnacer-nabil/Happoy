package com.nabilaitnacer.adsservice.dto;

import com.nabilaitnacer.adsservice.entity.AdsStatus;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    String title;
    @NotNull
    String description;
    @NotNull
    Long userId;
    @NotNull
    String category;
    @NotNull
    String city;
    @NotNull
    BigDecimal price;

}