package com.diego.car.controller.Dto;

import com.diego.car.entities.Brand;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ModelDto {

    private Long idModel;
    private String name;
    private BigDecimal price;
    private Brand brand;
}
