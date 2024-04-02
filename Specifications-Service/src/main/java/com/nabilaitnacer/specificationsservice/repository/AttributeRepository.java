package com.nabilaitnacer.specificationsservice.repository;

import com.nabilaitnacer.specificationsservice.entity.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeRepository  extends JpaRepository<Attribute, Long> {

}