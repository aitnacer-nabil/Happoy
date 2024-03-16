package com.nabilaitnacer.categoryservice;

import com.nabilaitnacer.categoryservice.dto.CategoriesAllResponseDto;
import com.nabilaitnacer.categoryservice.dto.CategoryDto;
import com.nabilaitnacer.categoryservice.entity.Category;
import com.nabilaitnacer.categoryservice.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootApplication
@RequiredArgsConstructor
public class CategoryServiceApplication {
    private final CategoryRepository categoryRepository;

    public static void main(String[] args) {
        SpringApplication.run(CategoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ModelMapper modelMapper) {
        return args -> {
            System.out.println("Category Service is running...");
            List<Category> categories = categoryRepository.findAll();

        };


    }

}
