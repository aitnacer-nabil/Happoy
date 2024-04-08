package com.nabilaitnacer.service;

import com.nabilaitnacer.exceptions.NotFoundException;
import com.nabilaitnacer.exceptions.ServiceException;
import com.nabilaitnacer.repository.MediaRepository;
import com.nabilaitnacer.dtos.MediaDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.nabilaitnacer.entities.Media;


import java.util.Optional;

@Service
public class MediaServiceImpl implements MediaService{
    private final MediaMapper mediaMapper;
    private final MediaRepository mediaRepository;
    private static final Logger logger = LoggerFactory.getLogger(MediaServiceImpl.class);
    public MediaServiceImpl(MediaMapper mediaMapper,MediaRepository mediaRepository){
        this.mediaMapper=mediaMapper;
        this.mediaRepository=mediaRepository;
    }

    @Override
    public MediaDto saveMedia(String imageUrl) {
        try {
            Media media = new Media();
            media.setImageUrl(imageUrl);
            logger.info("media ajouter avec succes");
            Media savedMedia = mediaRepository.save(media);
            return mediaMapper.toDto(savedMedia);
        } catch (Exception e) {
            logger.error("Erreur lors de l'enregistrement du media", e);
            throw new ServiceException("Erreur lors de l'enregistrement du media", e);
        }

    }

    @Override
    public MediaDto getMedialById(Long id) {
        try {
            Optional<Media> optionalMedia = mediaRepository.findById(id);
            if (optionalMedia.isPresent()) {
                Media media = optionalMedia.get();
                logger.info("recuperation de l 'image avec id {} ",id);
                return mediaMapper.toDto(media);
            } else {
                logger.warn("media avec cet id {} non trouvable",id);
                throw new NotFoundException("Media non trouvee: " + id);
            }
        } catch (Exception e) {
            logger.error("error lors de la recupeerration du media");
            throw new ServiceException("Erreur lors de la recuperation du media: " + id, e);
        }
    }

    @Override
    public MediaDto updateMedia(Long id, String url) {
        try {
            Optional<Media> optionalMedia = mediaRepository.findById(id);
            if (optionalMedia.isPresent()) {
                Media existingMedia = optionalMedia.get();
                existingMedia.setImageUrl(url);
                Media updatedMedia = mediaRepository.saveAndFlush(existingMedia);
                logger.info("image updated successfuly {} ",id);
                return mediaMapper.toDto(updatedMedia);
            } else {
                logger.warn("media avec cet id {} non trouvable ",id);
                throw new NotFoundException("Media non trouvee avec cet id: " + id);
            }
        } catch (Exception e) {
            logger.error("error lors de la modification du media");
            throw new ServiceException("Erreur lors de la recuperation du media:  " + id, e);
        }
    }

    @Override
    public void deleteMediaById(Long id) {
        try {
            logger.info("image deleted successfuly {} ",id);
            mediaRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("error lors de la suppression du media");
            throw new ServiceException("erreur lors de la suppression du media avec id : " + id, e);
        }
    }
}
