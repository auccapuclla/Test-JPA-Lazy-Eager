package com.joel.app.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Customer {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String email;
    private String gender;
//    One Customer could have many products
//    Should target an entity. This case Product class
    @OneToMany(targetEntity =  Product.class, cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
//      id column will be added to Product table
    @JoinColumn(name = "cp_fk", referencedColumnName = "id")
//    Customer could have multiples products
    private List<Product> products;
}
