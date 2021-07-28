package com.gb.klimakhin.spring_data.controllers;

import com.gb.klimakhin.spring_data.entities.Product;
import com.gb.klimakhin.spring_data.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id){
        return service.getProductById(id);
    }

    @PostMapping
    public Product saveProduct(Product product){
        return service.saveProduct(product);
    }

    @GetMapping("/delete/{id}")
    public void deleteProductById(@PathVariable Long id){
        service.deleteProductById(id);
    }

    @GetMapping("/sort/between/{min}/to/{max}")
    public List<Product> sortBetween(@PathVariable(required = false) Integer min, @PathVariable(required = false) Integer max){
        if(max == null){
            max = Integer.MAX_VALUE;
        }
        if(min == null){
            min = 0;
        }
        return service.getAllProductsByPriceBetween(min, max);
    }

    @GetMapping("/sort/less/{max}")
    public List<Product> sortLess(@PathVariable int max){
        return service.getAllProductsByPriceLessThan(max);
    }

    @GetMapping("/sort/greater/{min}")
    public List<Product> sortGreater(@PathVariable int min){
        return service.getAllProductsByPriceGreaterThan(min);
    }

    @GetMapping("/name/{name}")
    public List<Product> getProductByPartOfName(@PathVariable String name){
        return service.getProductByPartOfName(name.toLowerCase(Locale.ROOT));
    }
}
