package com.gb.spring_1.hib_2.services;

import com.gb.spring_1.hib_2.entities.Customer;
import com.gb.spring_1.hib_2.entities.Product;
import com.gb.spring_1.hib_2.repositories.CustomerRepo;
import com.gb.spring_1.hib_2.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class GetService {
    
    @Autowired
    ProductRepo productRepo;

    @Autowired
    CustomerRepo customerRepo;


    public Optional<List<Product>> getProductListById(long customerId){
        Customer customer = customerRepo.getCustomerById(customerId);
        return Optional.of(customer.getProducts());
    }

    public Optional<List<Customer>> getCustomersByProductId(long productId){
        Product product = productRepo.readProductById(productId);
        return Optional.of(product.getCustomers());
    }
}
