package com.diego.car.repository;

import com.diego.car.entities.Model;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ModelRepository extends CrudRepository<Model, Long> {

    /*JPQL
    @Query("SELECT m FROM Model m WHERE p.price BETWEEN ?1 AND ?2")
    List<Model> findModelByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice);

    //QueryMethod
    List<Model> findModelByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);*/
}
