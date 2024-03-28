package com.nabilaitnacer.specificationsservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttributeValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String value;
    @ManyToOne
    @JoinColumn(name = "attribute_id", nullable = false)
    private Attribute attribute;
    private Long adsId;




}
