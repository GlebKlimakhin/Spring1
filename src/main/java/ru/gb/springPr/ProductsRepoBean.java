package ru.gb.springPr;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class ProductsRepoBean implements ProductsRepo{

    private List<Product> products;

    @PostConstruct
    public void init(){
        products = new ArrayList<>();
        products.add(new Product(123123, "soap", 32));
        products.add(new Product(1223, "plate", 332));
        products.add(new Product(121313123, "fork", 13));
        System.out.println("dad");
    }

    @Override
    public List<Product> get() {
        return products;
    }
}
