package com.gb.springboot.springboot.repositories;

import com.gb.springboot.springboot.models.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements IProductRepository{

    private List<Product> products;

    @PostConstruct
    private void init(){
        products = new ArrayList<>();
        products.addAll(List.of(
                new Product(213L, "Picnic", 100),
                new Product(13L, "Mars", 32),
                new Product(23L, "Nuts", 77)
        ));
    }
    @Override
    public List<Product> get() {
        return Collections.unmodifiableList(products);
    }

    public Optional<Product> findProductById(long id){
        return products.stream().filter(product -> product.getId().equals(id)).findFirst();
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public void deleteProduct(Product product){
        products.remove(product);
    }


}
