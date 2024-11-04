package com.diego.car.service.impl;

import com.diego.car.entities.Model;
import com.diego.car.persistence.IModelDao;
import com.diego.car.service.IModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ModelServiceImpl implements IModelService {

    @Autowired
    private IModelDao modelDao;

    @Override
    public Optional<Model> findById(Long id) {
        return modelDao.findById(id);
    }

    @Override
    public List<Model> findAll() {
        return (List<Model>) modelDao.findAll();
    }

    /*@Override
    public List<Model> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return modelDao.findByPriceInRange(minPrice, maxPrice);
    }*/

    @Override
    public void save(Model model) {
        modelDao.save(model);
    }

    @Override
    public void deleteById(Long id) {
        modelDao.deleteById(id);
    }
}
