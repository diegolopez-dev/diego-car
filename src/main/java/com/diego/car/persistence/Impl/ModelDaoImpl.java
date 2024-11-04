package com.diego.car.persistence.Impl;

import com.diego.car.entities.Model;
import com.diego.car.persistence.IModelDao;
import com.diego.car.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
public class ModelDaoImpl implements IModelDao {

    @Autowired
    private ModelRepository modelRepository;

    @Override
    public Optional<Model> findById(Long id) {
        return modelRepository.findById(id);
    }

    @Override
    public List<Model> findAll() {
        return (List<Model>) modelRepository.findAll();
    }

    /*@Override
    public List<Model> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return modelRepository.findModelByPriceInRange(minPrice, maxPrice);
    }*/

    @Override
    public void save(Model model) {
        modelRepository.save(model);
    }

    @Override
    public void deleteById(Long id) {
        modelRepository.deleteById(id);
    }
}
