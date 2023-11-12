package com.azoulux.dataLayer.repository;

import com.azoulux.dataLayer.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    Iterable<Product> findByName(String name);

    Iterable<Product> findByCategoriesName(String name);

    @Query("FROM Product WHERE name = ?1")
    Iterable<Product> findByNameJPQL(String name);

    @Query(value = "SELECT * FROM produit WHERE cout = :cout", nativeQuery = true)
    Iterable<Product> findByCostNative(@Param("cout") Integer cost);

    Iterable<Product> findByCostLessThan(Integer cost);
}
