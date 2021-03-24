package com.tu.service;

import com.tu.model.Category;
import com.tu.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface OrderService {
    Page<Order> showAll(Pageable pageable);

    void save(Order order);

    Optional<Order> findById(Long id);

    void delete(Long id);
}
