package com.tu.repository;

import com.tu.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailReponsitory extends JpaRepository<OrderDetail,Long> {
}
