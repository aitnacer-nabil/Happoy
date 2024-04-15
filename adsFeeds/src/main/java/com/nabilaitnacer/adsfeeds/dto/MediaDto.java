package com.nabilaitnacer.adsfeeds.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MediaDto implements Serializable {
    Long id;
    String imageUrl;
}