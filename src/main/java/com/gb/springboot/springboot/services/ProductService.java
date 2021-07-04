package com.gb.springboot.springboot.services;

import com.gb.springboot.springboot.exceptions.ResourceNotFoundException;
import com.gb.springboot.springboot.models.Product;
import com.gb.springboot.springboot.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.get();
    }

    public Product getProductById(long id){
        return productRepository.findProductById(id).orElseThrow(()->new ResourceNotFoundException
                ("the product with provided id doesn't exist"));
    }

    public void deleteProduct(Product product){
        productRepository.deleteProduct(product);
    }

    public void addProduct(Product product){
        productRepository.addProduct(product);
    }

}
