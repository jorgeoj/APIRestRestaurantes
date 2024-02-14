package com.example.apirestrestaurantes;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "restaurantes")
public class Restaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Integer puntuacion;
    private String ubicacion;
    private String tipocomida;
    private Boolean menu;
    private Boolean menuinfantil;
    private Double precio;
}
