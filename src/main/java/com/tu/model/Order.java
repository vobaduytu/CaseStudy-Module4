package com.tu.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "total_price")
    private double totalPrice;
    @Column(name = "create_date")
    private Date createDate;
    private boolean status;
    @Column(name = "expected_date")
    private Date expectedDate;
    @Column(name = "reality_date")
    private Date realityDate;
    private String address;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;
}
