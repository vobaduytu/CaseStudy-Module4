package com.tu.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 2,max = 40)
    private String name;
    @NotBlank
    @Size(min = 10)
    private String description;
    @NotBlank
    private String color;
    @NotBlank
    private String image;

    private double price;
    @Column(name = "create_date")
    private Date createDate;
    @Column(name = "update_date")
    private Date updateDate;
    @Column(name = "delete_date")
    private Date deleteDate;
    @Column(name = "is_delete")
    private boolean isDelete;
    @Column(name = "restore_date")
    private Date restoreDate;

    private boolean status;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "category_id")

    private Category category;
    private boolean deleted;


    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;
}
