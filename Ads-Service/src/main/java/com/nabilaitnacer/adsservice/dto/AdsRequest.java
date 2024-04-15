package com.nabilaitnacer.adsservice.dto;

import com.nabilaitnacer.adsservice.entity.AdsStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

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
    String userId;
    @NotNull
     String category;
    @NotNull
    Long categoryId;
    @NotNull
    String city;
    @NotNull
    BigDecimal price;
    @NotNull
     List<MultipartFile> files;
    AttributeValueRequest attributeValue;

}