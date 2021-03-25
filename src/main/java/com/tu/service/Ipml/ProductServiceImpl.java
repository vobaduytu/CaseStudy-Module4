package com.tu.service.Ipml;


import com.tu.model.Product;
import com.tu.repository.ProductReponsitory;
import com.tu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductReponsitory productReponsitory;

    @Override
    public List<Product> findByName(String name) {
        return productReponsitory.findByName(name);
    }

    @Override
    public Page<Product> showAll(Pageable pageable) {
        return productReponsitory.findAllByDeletedIsFalse(pageable);
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
