package com.gb.spring.les3.services;

import com.gb.spring.les3.models.Product;
import com.gb.spring.les3.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository = new ProductRepository();

    public List<Product> getAllProducts(){
        return productRepository.get();
    }

    public Product getProductById(long id){
       return productRepository.getProductById(id);
    }

    public boolean isEmpty(){
        return productRepository.get().isEmpty();
    }

    public void addProduct(Product product){
        productRepository.addProduct(product);
    }





}
