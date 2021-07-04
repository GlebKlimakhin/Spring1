package com.gb.springboot.springboot.models;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Product {

    private Long id;
    private String title;
    private int cost;


}
