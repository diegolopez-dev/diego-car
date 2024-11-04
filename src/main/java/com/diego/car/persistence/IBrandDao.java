package com.diego.car.persistence;

import com.diego.car.entities.Brand;

import java.util.List;
import java.util.Optional;

public interface IBrandDao {

    Optional<Brand> findById(Long id);
    List<Brand> findAll();
    void save(Brand brand);
    void deleteById(Long id);

}
