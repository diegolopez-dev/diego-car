package com.diego.car.controller.Dto;

import com.diego.car.entities.Model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BrandDto {

    private Long id;
    private String name;
    private List<Model> modelList = new ArrayList<>();
}
