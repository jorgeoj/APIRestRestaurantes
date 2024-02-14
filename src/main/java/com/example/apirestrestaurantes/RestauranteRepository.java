package com.example.apirestrestaurantes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
    // Consultas simples tipo GET
    public Restaurante getRestauranteById(Long id);
    public Restaurante getRestauranteByNombre(String nombre);
    public List<Restaurante> getRestaurantesByPuntuacion(Integer puntuacion);
    public Restaurante getRestauranteByUbicacion(String ubicacion);
    public List<Restaurante> getRestauranteByTipocomida(String tipocomida);
    public List<Restaurante> getRestaurantesByMenu(Boolean menu);
    public List<Restaurante> getRestaurantesByMenuinfantil(Boolean menuinfantil);
    public List<Restaurante> getRestaurantesByPrecio(Double precio);

    // Consultas mas complejas

    // Obtener lista de todos los nombres de los restaurantes
    @Query("SELECT r.nombre FROM Restaurante r")
    public List<String> nombreRestaurantes();

    // Obtener la cantidad de restaurantes de la API
    @Query("SELECT count(r) FROM Restaurante r")
    public Integer cantidadDeRestaurantes();

    // Obtener los restaurantes con la puntuacion indicada o mayor
    @Query("SELECT r FROM Restaurante r WHERE r.puntuacion >= :puntuacion")
    List<Restaurante> getRestaurantesConPuntuacionMayorOIgual(Integer puntuacion);

    // Obtener lista de restaurantes con precio máximo indicado
    @Query("SELECT r FROM Restaurante  r WHERE r.precio <= :precioMedio")
    List<Restaurante> restaurantesPorPrecioMaximo(Double precioMedio);

    // Obtener lista de restaurantes con precio mínimo indicado
    @Query("SELECT r FROM Restaurante  r WHERE r.precio >= :precioMedio")
    List<Restaurante> restaurantesPorPrecioMinimo(Double precioMedio);

}
