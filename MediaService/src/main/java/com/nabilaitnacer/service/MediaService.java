package com.nabilaitnacer.service;

import com.nabilaitnacer.dtos.MediaDto;

public interface MediaService {
    MediaDto saveMedia(String imageUrl);
    MediaDto getMedialById(Long id);
    MediaDto updateMedia(Long id,String url);
    void deleteMediaById(Long id);


}
