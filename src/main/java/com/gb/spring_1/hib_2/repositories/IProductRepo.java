package com.gb.spring_1.hib_2.repositories;

import com.gb.spring_1.hib_2.entities.Product;

import java.util.List;
import java.util.Optional;

public interface IProductRepo {
    void saveOrUpdate(Product product);

    void delete(Product product);

    Product readProductById(long id);

    List<Product> readAllProducts();
}
