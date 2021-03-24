package com.tu.service.Ipml;

import com.tu.model.Category;
import com.tu.repository.CategoryReponsitory;
import com.tu.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryReponsitory categoryReponsitory;

    @Override
    public Page<Category> showAll(Pageable pageable) {
        return categoryReponsitory.findAll(pageable);
    }

    @Override
    public void save(Category category) {
    categoryReponsitory.save(category);
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryReponsitory.findById(id);
    }

    @Override
    public void delete(Long id) {
    categoryReponsitory.deleteById(id);
    }
}
