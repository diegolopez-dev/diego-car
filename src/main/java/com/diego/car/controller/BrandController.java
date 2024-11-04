package com.diego.car.controller;

import com.diego.car.controller.Dto.BrandDto;
import com.diego.car.controller.payload.MessageResponse;
import com.diego.car.entities.Brand;
import com.diego.car.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/brand")
public class BrandController {

    @Autowired
    private IBrandService brandService;

    @GetMapping("find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Brand> brandOptional = brandService.findById(id);
        if (brandOptional.isPresent()) {
            Brand brand = brandOptional.get();
            BrandDto brandDto = BrandDto.builder()
                    .id(brand.getId())
                    .name(brand.getName())
                    .modelList(brand.getModelList())
                    .build();
            return new ResponseEntity<>(MessageResponse.builder()
                            .message("Registro encontrado.")
                            .object(brandDto)
                            .build(), HttpStatus.OK);
        }
        return new ResponseEntity<>(MessageResponse.builder()
                .message("Registro no encotrado.")
                .object(null)
                .build(), HttpStatus.NOT_FOUND);
    }

    @GetMapping("findAll")
    public ResponseEntity<?> findAll() {
        List<BrandDto> brandDtoList = brandService.findAll()
                .stream()
                .map(brand -> BrandDto.builder()
                        .id(brand.getId())
                        .name(brand.getName())
                        .modelList(brand.getModelList())
                        .build())
                .toList();
        return new ResponseEntity<>(MessageResponse.builder()
                        .message("Lista de registros de marcas.")
                        .object(brandDtoList)
                        .build(), HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<?> save(@RequestBody BrandDto brandDto) {
        try {
            if (!brandDto.getName().isBlank()) {
                brandService.save(Brand.builder()
                        .name(brandDto.getName())
                        .build());
                return new ResponseEntity<>(MessageResponse.builder()
                        .message("Guardado correctamente")
                        .object(brandDto.builder()
                                .id(brandDto.getId())
                                .name(brandDto.getName())
                                .modelList(brandDto.getModelList())
                                .build())
                        .build(), HttpStatus.CREATED);
            }
            else {
                return new ResponseEntity<>(MessageResponse.builder()
                        .message("Error al crear.")
                        .object(null)
                        .build(), HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(MessageResponse.builder()
                    .message(e.getMessage())
                    .object(null)
                    .build(), HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateBrand(@RequestBody BrandDto brandDto, @PathVariable Long id) {
        Optional<Brand> brandOptional = brandService.findById(id);
        try {
            if (brandOptional.isPresent()) {
                Brand brand = brandOptional.get();
                brand.setName(brandDto.getName());
                brandService.save(brand);
                return new ResponseEntity<>(MessageResponse.builder()
                        .message("Registro actualizado.")
                        .object(brandDto.builder()
                                .id(brandDto.getId())
                                .name(brandDto.getName())
                                .modelList(brandDto.getModelList())
                                .build())
                        .build(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(MessageResponse.builder()
                                .message("Registro no encontrado")
                                .object(null)
                                .build(), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(MessageResponse.builder()
                            .message(e.getMessage())
                            .object(null)
                            .build(), HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteBrand(@PathVariable Long id) {
        Optional<Brand> brandOptional = brandService.findById(id);
        if (brandOptional.isPresent()) {
            brandService.deleteById(id);
            return new ResponseEntity<>(MessageResponse.builder()
                    .message("Registro eliminado")
                    .object(null)
                    .build(), HttpStatus.OK);
        }
        return new ResponseEntity<>(MessageResponse.builder()
                        .message("Registro no encontrado")
                        .object(null)
                        .build(), HttpStatus.BAD_REQUEST);
    }
}