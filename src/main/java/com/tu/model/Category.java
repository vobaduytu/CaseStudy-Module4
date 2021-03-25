package com.tu.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2,max = 40)
    private String name;


    @NotBlank
    @Size(min = 10)
    private String description;

    @Column(name = "is_delete")
    private boolean isDelete;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
    private boolean deleted;
}
