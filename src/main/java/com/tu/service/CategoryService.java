package com.tu.service;

import com.tu.model.Category;
import com.tu.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CategoryService {
    Page<Category> showAll(Pageable pageable);

    void save(Category category);

    Optional<Category> findById(Long id);

    void delete(Long id);
}
