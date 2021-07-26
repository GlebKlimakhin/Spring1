package com.gb.spring_1.hib_2.repositories;

import com.gb.spring_1.hib_2.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerRepo {
    void saveOrUpdate(Customer customer);

    void deleteUser(Customer customer);

    Customer getCustomerById(long id);

    List<Customer> readAllCustomers();
}
