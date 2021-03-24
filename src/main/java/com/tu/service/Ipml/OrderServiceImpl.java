package com.tu.service.Ipml;


import com.tu.model.Order;
import com.tu.repository.OrderReponsitory;
import com.tu.service.OrderDetailService;
import com.tu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderReponsitory orderReponsitory;

    @Override
    public Page<Order> showAll(Pageable pageable) {
        return orderReponsitory.findAll(pageable);
    }

    @Override
    public void save(Order order) {
    orderReponsitory.save(order);
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderReponsitory.findById(id);
    }

    @Override
    public void delete(Long id) {
        orderReponsitory.deleteById(id);
    }
}
