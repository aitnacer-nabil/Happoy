package com.nabilaitnacer.service;

import com.nabilaitnacer.exceptions.NotFoundException;
import com.nabilaitnacer.exceptions.ServiceException;
import com.nabilaitnacer.repository.MediaRepository;
import com.nabilaitnacer.dtos.MediaDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.nabilaitnacer.entities.Media;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MediaServiceImpl implements MediaService{
    private final ModelMapper modelMapper;
    private final MediaRepository mediaRepository;


    @Override
    public MediaDto saveMedia(String imageUrl, Long adId) {
        try {
            Media media = new Media();
            media.setImageUrl(imageUrl);
            media.setAdId(adId);
            Media savedMedia = mediaRepository.save(media);
            return modelMapper.map(savedMedia, MediaDto.class);
        } catch (Exception e) {
            throw new ServiceException("Erreur lors de l'enregistrement du media", e);
        }

    }

    @Override
    public MediaDto getMedialById(Long id) {
        try {
            Optional<Media> optionalMedia = mediaRepository.findById(id);
            if (optionalMedia.isPresent()) {
                Media media = optionalMedia.get();
                log.info("recuperation de l 'image avec id {} ",id);
                return modelMapper.map(media, MediaDto.class);
            } else {
                log.warn("media avec cet id {} non trouvable",id);
                throw new NotFoundException("Media non trouvee: " + id);
            }
        } catch (Exception e) {
            log.error("error lors de la recupeerration du media");
            throw new ServiceException("Erreur lors de la recuperation du media: " + id, e);
        }
    }

    @Override
    public List<MediaDto> getAllMediaByAdId(Long adId) {
        List<Media> mediaList = mediaRepository.findByAdId(adId);
        return mediaList.stream().map(media -> modelMapper.map(media, MediaDto.class)).toList();
    }

    @Override
    public MediaDto updateMedia(Long id, String url) {
        try {
            Optional<Media> optionalMedia = mediaRepository.findById(id);
            if (optionalMedia.isPresent()) {
                Media existingMedia = optionalMedia.get();
                existingMedia.setImageUrl(url);
                Media updatedMedia = mediaRepository.saveAndFlush(existingMedia);
                log.info("image updated successfuly {} ",id);
                return modelMapper.map(updatedMedia, MediaDto.class);
            } else {
                log.warn("media avec cet id {} non trouvable ",id);
                throw new NotFoundException("Media non trouvee avec cet id: " + id);
            }
        } catch (Exception e) {
            log.error("error lors de la modification du media");
            throw new ServiceException("Erreur lors de la recuperation du media:  " + id, e);
        }
    }

    @Override
    public void deleteMediaById(Long id) {
        try {
            log.info("image deleted successfuly {} ",id);
            mediaRepository.deleteById(id);
        } catch (Exception e) {
            log.error("error lors de la suppression du media");
            throw new ServiceException("erreur lors de la suppression du media avec id : " + id, e);
        }
    }
}
