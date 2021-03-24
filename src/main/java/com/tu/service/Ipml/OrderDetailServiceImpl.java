package com.tu.service.Ipml;

import com.tu.model.OrderDetail;
import com.tu.repository.OrderDetailReponsitory;
import com.tu.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailReponsitory orderDetailReponsitory;


    @Override
    public Page<OrderDetail> showAll(Pageable pageable) {
        return orderDetailReponsitory.findAll(pageable);
    }

    @Override
    public void save(OrderDetail orderDetail) {
    orderDetailReponsitory.save(orderDetail);
    }

    @Override
    public Optional<OrderDetail> findById(Long id) {
        return orderDetailReponsitory.findById(id);
    }

    @Override
    public void delete(Long id) {
    orderDetailReponsitory.deleteById(id);
    }
}
