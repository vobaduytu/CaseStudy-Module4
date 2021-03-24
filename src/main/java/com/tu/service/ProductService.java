package com.tu.service;

import com.tu.model.Product;
import com.tu.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductService {

    Page<Product> showAll(Pageable pageable);

    void save(Product product);

    Optional<Product> findById(Long id);

    void delete(Long id);
}
