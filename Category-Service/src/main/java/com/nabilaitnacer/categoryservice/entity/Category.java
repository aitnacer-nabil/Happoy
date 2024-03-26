package com.nabilaitnacer.categoryservice.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.dao.DataIntegrityViolationException;

/**
 * Category entity class.
 * This class is annotated with @Entity indicating that it is a JPA entity.
 * Lombok annotations are used for generating getters, setters, toString, and constructors.
 * The class represents the Category table in the database.
 *
 * @author aitnacer-nabil
 */
@Entity
@Data
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
@Builder
public class Category {
    /**
     * Id of the category.
     * It is generated automatically by the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    /**
     * Description of the category.
     */
    @Column(unique = true, nullable = false)
    private String name;
    /**
     * Name of the category.
     * It is unique and cannot be null.
     */
    private String description;
    /**
     * Parent category of the current category.
     * It is a many-to-one relationship with the Category entity itself.
     */
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent;

    public void  setParent(Category parent){
        if(this.equals(parent)){
            throw new DataIntegrityViolationException("Category cannot be parent of itself");
        }
        this.parent = parent;
    }

}
