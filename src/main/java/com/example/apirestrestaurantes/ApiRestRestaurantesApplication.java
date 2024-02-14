package com.example.apirestrestaurantes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal que inicia la aplicación Spring Boot para el sistema de gestión de restaurantes.
 * Esta clase contiene el método principal {@link #main(String[])} que inicia la aplicación Spring Boot.
 *
 * @see org.springframework.boot.SpringApplication
 * @see org.springframework.boot.autoconfigure.SpringBootApplication
 *
 * @author Jorge Olmedo Jiménez
 * @version 1.0
 * @since 2024-02-14
 */
@SpringBootApplication
public class ApiRestRestaurantesApplication {

    /**
     * Método principal que inicia la aplicación Spring Boot.
     *
     * @param args Los argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        SpringApplication.run(ApiRestRestaurantesApplication.class, args);
    }

}

