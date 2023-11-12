package com.azoulux.dataLayer.repository;

import com.azoulux.dataLayer.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

    public Iterable<Category> findByName(String name);

    public Iterable<Category> findByProductsName(String name);
}
