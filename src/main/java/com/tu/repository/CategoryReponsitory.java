package com.tu.repository;

import com.tu.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryReponsitory extends JpaRepository<Category,Long> {
}
