package com.tu.service.Ipml;


import com.tu.model.Product;
import com.tu.repository.ProductReponsitory;
import com.tu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductReponsitory productReponsitory;

    @Override
    public Page<Product> showAll(Pageable pageable) {
        return productReponsitory.findAll(pageable);
    }

    @Override
    public void save(Product product) {
    productReponsitory.save(product);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productReponsitory.findById(id);
    }

    @Override
    public void delete(Long id) {
    productReponsitory.deleteById(id);
    }
}
