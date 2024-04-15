package com.nabilaitnacer.adsfeeds.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdDto {
    private AttributeValueResponse attribute;
    private List<MediaDto> media;
    private AdsDto ad;

}
