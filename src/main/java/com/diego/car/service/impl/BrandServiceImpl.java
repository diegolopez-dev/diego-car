package com.diego.car.service.impl;

import com.diego.car.entities.Brand;
import com.diego.car.persistence.IBrandDao;
import com.diego.car.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements IBrandService {

    @Autowired
    private IBrandDao brandDao;

    @Override
    public Optional<Brand> findById(Long id) {
        return brandDao.findById(id);
    }

    @Override
    public List<Brand> findAll() {
        return brandDao.findAll();
    }

    @Override
    public void save(Brand brand) {
        brandDao.save(brand);
    }

    @Override
    public void deleteById(Long id) {
        brandDao.deleteById(id);
    }
}
