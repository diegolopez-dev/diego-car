package com.diego.car.service;

import com.diego.car.entities.Model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IModelService {

    Optional<Model> findById(Long id);
    List<Model> findAll();
    //List<Model> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice);
    void save(Model model);
    void deleteById(Long id);
}
