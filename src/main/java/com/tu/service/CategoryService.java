package com.tu.service;

import com.tu.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    public List<Category> findByName(String name);

    Page<Category> showAll(Pageable pageable);

    void save(Category category);

    Optional<Category> findById(Long id);

    void delete(Long id);
}
