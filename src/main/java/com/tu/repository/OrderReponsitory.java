package com.tu.repository;

import com.tu.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderReponsitory extends JpaRepository<Order,Long> {
}
