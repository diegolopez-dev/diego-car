package com.diego.car.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "model")
public class Model  implements Serializable {

    @Id
    @Column(name = "id_model")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idModel;
    private String name;
    private BigDecimal price;
    @ManyToOne()
    @JoinColumn(name = "id_brand", nullable = false)
    @JsonIgnore
    private Brand brand;
}
