package com.gb.spring_1.hib_2.repositories;

import com.gb.spring_1.hib_2.entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepo implements ICustomerRepo{

    private SessionFactory factory;

    public CustomerRepo(SessionFactory factory) {
        this.factory = factory.unwrap(SessionFactory.class);
    }

    @Override
    public void saveOrUpdate(Customer customer) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
    }


    @Override
    public void deleteUser(Customer customer) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.delete(customer);
        session.getTransaction().commit();
    }

    @Override
    public Customer getCustomerById(long id){
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Customer customer = session.get(Customer.class, id);
        session.getTransaction().commit();
        return customer;
    }

    @Override
    public List<Customer> readAllCustomers() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List<Customer> customers = session.createQuery("select c from customers c").getResultList();
        session.getTransaction().commit();
        return customers;
    }



}
