package com.nabilaitnacer.adsservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UploadResponse {
    public List<MediaDto> mediaDtos;
    public Long adId;
}
