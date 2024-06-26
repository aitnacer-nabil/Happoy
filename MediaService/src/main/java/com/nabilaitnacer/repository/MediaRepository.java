package com.nabilaitnacer.repository;

import com.nabilaitnacer.entities.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MediaRepository extends JpaRepository<Media, Long> {

    Optional<Media> findByImageUrl(String url);
    List<Media> findByAdId(Long adId);
}
