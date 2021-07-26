package com.gb.klimakhin.spring_data.services;

import com.gb.klimakhin.spring_data.entities.Product;
import com.gb.klimakhin.spring_data.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    IProductRepository productRepository;

    public Optional<Product> getProductById(Long id){
      return productRepository.findById(id);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public void deleteProductById(Long id){
        productRepository.deleteById(id);
    }

    public List<Product> getAllProductsByPriceBetween(int min, int max){
      return productRepository.getAllByPriceBetween(min, max);
    }

    public List<Product> getAllProductsByPriceLessThan(int max){
        return productRepository.getAllByPriceLessThan(max);
    }

    public List<Product> getAllProductsByPriceGreaterThan(int min){
        return productRepository.getAllByPriceGreaterThan(min);
    }

    public List<Product> getProductByPartOfName(String name){
        return productRepository.getProductByPartOfName(name);
    }
}
