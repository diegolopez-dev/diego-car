package com.diego.car.persistence.Impl;

import com.diego.car.entities.Brand;
import com.diego.car.persistence.IBrandDao;
import com.diego.car.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BrandDaoImpl implements IBrandDao {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Optional<Brand> findById(Long id) {
        return brandRepository.findById(id);
    }

    @Override
    public List<Brand> findAll() {
        return (List<Brand>) brandRepository.findAll();
    }

    @Override
    public void save(Brand brand) {
        brandRepository.save(brand);
    }

    @Override
    public void deleteById(Long id) {
        brandRepository.deleteById(id);
    }
}
