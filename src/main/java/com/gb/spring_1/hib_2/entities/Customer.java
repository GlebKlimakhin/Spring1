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
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue
    @Column(name = "customer_id")
    private long id;

    @Column(name = "customer_title")
    private String title;

    @Column(name = "customer_cost")
    private int cost;

    @ManyToMany
    @JoinTable(
            name = "products_customers",
            joinColumns = @JoinColumn("customer_id"),
            inverseJoinColumns = @JoinColumn("product_id")
    )
    private List<Product> products;

}
