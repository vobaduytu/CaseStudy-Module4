package com.tu.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phoneNumber;
    private String password;
    private String fullName;
    private int role;

    @OneToMany(mappedBy = "user")
    private List<OrderDetail> orderDetails;
}
