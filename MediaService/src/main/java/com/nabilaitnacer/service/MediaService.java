package com.nabilaitnacer.service;

import com.nabilaitnacer.dtos.MediaDto;

import java.util.List;

public interface MediaService {
    MediaDto saveMedia(String imageUrl, Long adId);
    MediaDto getMedialById(Long id);
    List<MediaDto> getAllMediaByAdId(Long adId);
    MediaDto updateMedia(Long id,String url);
    void deleteMediaById(Long id);


}
