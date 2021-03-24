package com.tu.repository;

import com.tu.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductReponsitory extends JpaRepository<Product,Long> {
}
