package com.nabilaitnacer.categoryservice.repository;

import com.nabilaitnacer.categoryservice.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CategoryRepository interface for Category entity.
 * This interface extends JpaRepository which provides JPA related methods
 * like save(), findById(), findAll(), deleteById() etc. for performing CRUD operations.
 *
 * @author aitnacer-nabil
 */
public interface CategoryRepository  extends JpaRepository<Category, Long> {

}
