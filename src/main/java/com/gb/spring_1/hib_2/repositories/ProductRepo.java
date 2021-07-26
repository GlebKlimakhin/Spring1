package com.gb.spring_1.hib_2.repositories;
import com.gb.spring_1.hib_2.entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class ProductRepo implements IProductRepo{

    private SessionFactory factory;

    public ProductRepo(SessionFactory factory) {
        this.factory = factory.unwrap(SessionFactory.class);
    }

    @Override
    public void saveOrUpdate(Product product) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(product);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Product product) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.delete(product);
        session.getTransaction().commit();
    }

    @Override
    public Product readProductById(long id) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.getTransaction().commit();
        return product;
    }

    @Override
    public List<Product> readAllProducts() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        return session.createQuery("select a from products a").getResultList();
    }
}
