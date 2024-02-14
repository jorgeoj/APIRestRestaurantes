package com.example.apirestrestaurantes;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Clase que representa un restaurante en el sistema.
 *
 *
 * @author Jorge Olmedo Jimenez
 * @version 1.0
 * @since 2024-02-14
 */
@Data
@Entity
@Table(name = "restaurantes")
public class Restaurante {
    /**
     * Identificador del restaurante.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del restaurante.
     */
    private String nombre;

    /**
     * Puntuación del restaurante (1 a 5 estrellas).
     */
    private Integer puntuacion;

    /**
     * Ubicación del restaurante.
     */
    private String ubicacion;

    /**
     * Tipo de comida que ofrece el restaurante.
     */
    private String tipocomida;

    /**
     * Indica si el restaurante tiene un menú del día.
     */
    private Boolean menu;

    /**
     * Indica si el restaurante ofrece un menú infantil.
     */
    private Boolean menuinfantil;

    /**
     * Precio promedio en el restaurante.
     */
    private Double precio;
}

