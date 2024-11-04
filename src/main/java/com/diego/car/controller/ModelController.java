package com.diego.car.controller;

import com.diego.car.controller.Dto.ModelDto;
import com.diego.car.controller.payload.MessageResponse;
import com.diego.car.entities.Brand;
import com.diego.car.entities.Model;
import com.diego.car.service.IModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/model")
public class ModelController {

    @Autowired
    private IModelService modelService;

    @GetMapping("find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Model> modelOptional = modelService.findById(id);
        if (modelOptional.isPresent()) {
            Model model = modelOptional.get();
            ModelDto modelDto = ModelDto.builder()
                    .idModel(model.getIdModel())
                    .name(model.getName())
                    .price(model.getPrice())
                    .brand(model.getBrand())
                    .build();
            return new ResponseEntity<>(MessageResponse.builder()
                    .message("Registro encontrado.")
                    .object(modelDto)
                    .build(), HttpStatus.OK);
        }
        return new ResponseEntity<>(MessageResponse.builder()
                .message("Registro no encotrado.")
                .object(null)
                .build(), HttpStatus.NOT_FOUND);
    }

    @GetMapping("findAll")
    public ResponseEntity<?> findAll() {
        List<ModelDto> modelDtoToList = modelService.findAll()
                .stream()
                .map(model -> ModelDto.builder()
                        .idModel(model.getIdModel())
                        .name(model.getName())
                        .price(model.getPrice())
                        .brand(model.getBrand())
                        .build())
                .toList();
        return new ResponseEntity<>(MessageResponse.builder()
                .message("Lista de registros de marcas.")
                .object(modelDtoToList)
                .build(), HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<?> save(@RequestBody ModelDto modelDto) {
        try {
            if (modelDto.getName().isBlank() || modelDto.getPrice() == null || modelDto.getBrand() == null) {
                return new ResponseEntity<>(MessageResponse.builder()
                        .message("Error al crear.")
                        .object(null)
                        .build(), HttpStatus.BAD_REQUEST);
            } else {
                Model model = Model.builder()
                        .name(modelDto.getName())
                        .price(modelDto.getPrice())
                        .brand(modelDto.getBrand())
                        .build();
                modelService.save(model);
                return new ResponseEntity<>(MessageResponse.builder()
                        .message("Guardado correctamente")
                        .object(modelDto.builder()
                                .idModel(modelDto.getIdModel())
                                .name(modelDto.getName())
                                .price(modelDto.getPrice())
                                .brand(modelDto.getBrand())
                                .build())
                        .build(), HttpStatus.CREATED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(MessageResponse.builder()
                    .message(e.getMessage())
                    .object(null)
                    .build(), HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateModel(@RequestBody ModelDto modelDto, @PathVariable Long id) {
        Optional<Model> modelOptional = modelService.findById(id);
        try {
            if (modelOptional.isPresent()) {
                Model model = modelOptional.get();
                model.setName(modelDto.getName());
                model.setPrice(modelDto.getPrice());
                model.setBrand(modelDto.getBrand());
                modelService.save(model);
                return new ResponseEntity<>(MessageResponse.builder()
                        .message("Registro actualizado.")
                        .object(modelDto.builder()
                                .idModel(modelDto.getIdModel())
                                .name(modelDto.getName())
                                .price(modelDto.getPrice())
                                .brand(modelDto.getBrand())
                                .build())
                        .build(), HttpStatus.CREATED);
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
    public ResponseEntity<?> deleteModel(@PathVariable Long id) {
        Optional<Model> modelOptional = modelService.findById(id);
        if (modelOptional.isPresent()) {
            modelService.deleteById(id);
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
