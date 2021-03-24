package com.tu.service;

import com.tu.model.Order;
import com.tu.model.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface OrderDetailService {

    Page<OrderDetail> showAll(Pageable pageable);

    void save(OrderDetail orderDetail);

    Optional<OrderDetail> findById(Long id);

    void delete(Long id);
}
