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
    public List<Restaurante> getRestauranteByTipoComida(String tipoComida);
    public List<Restaurante> getRestaurantesByMenuDelDia(Boolean menuDelDia);
    public List<Restaurante> getRestaurantesByMenuInfantil(Boolean menuInfantil);
    public List<Restaurante> getRestaurantesByPrecioMedio(Double precioMedio);

    // Consultas mas complejas

    // Obtener lista de todos los nombres de los restaurantes
    @Query("SELECT r.nombre FROM Restaurante r")
    public List<String> nombreRestaurantes();

    // Obtener la cantidad de restaurantes de la API
    @Query("SELECT count(r) FROM Restaurante r")
    public Integer cantidadDeRestaurantes();


}
