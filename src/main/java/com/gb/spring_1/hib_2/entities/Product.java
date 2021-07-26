package com.gb.spring_1.hib_2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private long id;

    @Column(name = "product_title")
    private String title;

    @Column(name = "product_price")
    private int cost;

    @ManyToMany
    @JoinTable(
            name = "products_customers",
            joinColumns = @JoinColumn("product_id"),
            inverseJoinColumns = @JoinColumn("customer_id")
    )
    private List<Customer> customers;
}
