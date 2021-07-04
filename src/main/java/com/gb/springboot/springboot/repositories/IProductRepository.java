package com.gb.springboot.springboot.repositories;

import com.gb.springboot.springboot.models.Product;

import java.util.List;

public interface IProductRepository {

        List<Product> get();

}
