package com.gb.spring.les3.repositories;

import com.gb.spring.les3.models.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@org.springframework.stereotype.Repository
public class ProductRepository implements Repository{

    List<Product> products;

    @PostConstruct
    public void init(){
        products = new ArrayList<>();
        products.addAll(List.of(
                new Product(102, "table", 200),
                new Product(134, "chair", 232),
                new Product(14, "closet", 2321)
                ));
    }

    @Override
    public List<Product> get() {
        return products;
    }

    public Product getProductById(long id){
        for (Product p: products) {
            if(p.getId() == id){
                return p;
            }
        }
        throw new NoSuchElementException("no product with provided ID");
    }

    public void  addProduct(Product product){
        products.add(product);
    }



}
