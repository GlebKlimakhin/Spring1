package com.gb.klimakhin.spring_data.repositories;

import com.gb.klimakhin.spring_data.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

    List<Product> getAllByPriceBetween(int min, int max);

    List<Product> getAllByPriceLessThan(int max);

    List<Product> getAllByPriceGreaterThan(int min);

    @Query("select p from Product p where p.name LIKE CONCAT('%', :name, '%') ")
    List<Product> getProductByPartOfName(String name);

}
