package com.nabilaitnacer.specificationsservice.repository;

import com.nabilaitnacer.specificationsservice.entity.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttributeRepository  extends JpaRepository<Attribute, Long> {
    List<Attribute> findByCategoryId(Long categoryId);

}
