package com.tu.service.Ipml;

import com.tu.model.Category;
import com.tu.repository.CategoryRepository;
import com.tu.repository.ProductReponsitory;
import com.tu.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService
{
    @Autowired
    private ProductReponsitory productReponsitory;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public Page<Category> showAll(Pageable pageable) {
        return categoryRepository.findAllByDeletedIsFalse(pageable);
    }

    @Override
    public void save(Category category) {
    categoryRepository.save(category);
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        boolean result = categoryRepository.softDeleteCategory(id) > 0;
        if (!result)
            throw new RuntimeException("category not found");
        productReponsitory.softDeletePostByCategoryId(id);
    }

}
