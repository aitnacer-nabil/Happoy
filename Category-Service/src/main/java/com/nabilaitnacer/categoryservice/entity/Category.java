package com.nabilaitnacer.categoryservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent;



}
