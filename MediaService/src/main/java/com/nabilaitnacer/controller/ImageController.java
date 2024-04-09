package com.nabilaitnacer.controller;

import com.nabilaitnacer.dtos.UploadMediaDto;
import com.nabilaitnacer.dtos.UploadResponse;
import lombok.RequiredArgsConstructor;
import com.nabilaitnacer.dtos.MediaDto;
import com.nabilaitnacer.service.ImageService;
import com.nabilaitnacer.service.MediaServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/media")
public class ImageController {

    private final ImageService imageService;
    private final MediaServiceImpl mediaService;

    @PostMapping("/list")
    public ResponseEntity<UploadResponse> uploadListMedia(@ModelAttribute UploadMediaDto uploadMediaDto) {
                List<String> urls=imageService.uploadMultipleFiles(uploadMediaDto.files);
                UploadResponse uploadResponse= UploadResponse.builder().adId(uploadMediaDto.adId).mediaDtos(new ArrayList<>()).build();
                   urls.forEach(url->{
                       MediaDto media=mediaService.saveMedia(url);
                       uploadResponse.mediaDtos.add(media);
                   });

        return ResponseEntity.ok(uploadResponse);
    }
    @PostMapping
    public ResponseEntity<MediaDto> upload(@RequestParam("file") MultipartFile multipartFile) {
                String url=imageService.upload(multipartFile);
                MediaDto media=mediaService.saveMedia(url);
        return ResponseEntity.ok(media);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MediaDto> getMediaById(@PathVariable Long id) {
        MediaDto mediaDto = mediaService.getMedialById(id);
        return ResponseEntity.ok(mediaDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MediaDto> updateMedia(@RequestParam("file") MultipartFile multipartFile,@PathVariable Long id) {
        String url=imageService.upload(multipartFile);
        MediaDto mediaDto = mediaService.updateMedia(id,url);
        return ResponseEntity.ok(mediaDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMediaById(@PathVariable Long id) {
        mediaService.deleteMediaById(id);
        return ResponseEntity.noContent().build();
    }

}
