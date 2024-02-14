package com.example.apirestrestaurantes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Interfaz que define operaciones de acceso a datos para la entidad {@link Restaurante}.
 * Extiende la interfaz {@link JpaRepository} para heredar operaciones CRUD estándar de Spring Data JPA.
 *
 * @see org.springframework.data.jpa.repository.JpaRepository
 * @see org.springframework.data.jpa.repository.Query
 * @see Restaurante
 *
 * @author Jorge Olmedo Jimenez
 * @version 1.0
 * @since 2024-02-14
 */
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
    // Consultas simples tipo GET
    /**
     * Obtiene un restaurante por su identificador único.
     *
     * @param id Identificador único del restaurante.
     * @return El restaurante con el identificador proporcionado.
     */
    Restaurante getRestauranteById(Long id);

    /**
     * Obtiene un restaurante por su nombre.
     *
     * @param nombre Nombre del restaurante.
     * @return El restaurante con el nombre proporcionado.
     */
    Restaurante getRestauranteByNombre(String nombre);

    /**
     * Obtiene una lista de restaurantes con la puntuación dada.
     *
     * @param puntuacion Puntuación de los restaurantes a buscar.
     * @return Lista de restaurantes con la puntuación proporcionada.
     */
    List<Restaurante> getRestaurantesByPuntuacion(Integer puntuacion);

    /**
     * Obtiene un restaurante por su ubicación.
     *
     * @param ubicacion Ubicación del restaurante.
     * @return El restaurante en la ubicación proporcionada.
     */
    Restaurante getRestauranteByUbicacion(String ubicacion);

    /**
     * Obtiene una lista de restaurantes por el tipo de comida que ofrecen.
     *
     * @param tipocomida Tipo de comida que ofrecen los restaurantes.
     * @return Lista de restaurantes con el tipo de comida proporcionado.
     */
    List<Restaurante> getRestauranteByTipocomida(String tipocomida);

    /**
     * Obtiene una lista de restaurantes con la opción de menú especificada.
     *
     * @param menu Indica si el restaurante tiene menú.
     * @return Lista de restaurantes con la opción de menú proporcionada.
     */
    List<Restaurante> getRestaurantesByMenu(Boolean menu);

    /**
     * Obtiene una lista de restaurantes con la opción de menú infantil especificada.
     *
     * @param menuinfantil Indica si el restaurante ofrece menú infantil.
     * @return Lista de restaurantes con la opción de menú infantil proporcionada.
     */
    List<Restaurante> getRestaurantesByMenuinfantil(Boolean menuinfantil);

    /**
     * Obtiene una lista de restaurantes con el precio igual al proporcionado.
     *
     * @param precio Precio de los restaurantes a buscar.
     * @return Lista de restaurantes con el precio proporcionado.
     */
    List<Restaurante> getRestaurantesByPrecio(Double precio);

    // Consultas mas complejas

    /**
     * Obtiene una lista de nombres de todos los restaurantes.
     *
     * @return Lista de nombres de restaurantes.
     */
    @Query("SELECT r.nombre FROM Restaurante r")
    List<String> nombreRestaurantes();

    /**
     * Obtiene la cantidad total de restaurantes en la API.
     *
     * @return Cantidad total de restaurantes.
     */
    @Query("SELECT count(r) FROM Restaurante r")
    Integer cantidadDeRestaurantes();

    /**
     * Obtiene una lista de restaurantes con una puntuación igual o mayor a la proporcionada.
     *
     * @param puntuacion Puntuación mínima de los restaurantes a buscar.
     * @return Lista de restaurantes con una puntuación igual o mayor a la proporcionada.
     */
    @Query("SELECT r FROM Restaurante r WHERE r.puntuacion >= :puntuacion")
    List<Restaurante> getRestaurantesConPuntuacionMayorOIgual(Integer puntuacion);

    /**
     * Obtiene una lista de restaurantes con un precio máximo indicado.
     *
     * @param precioMedio Precio máximo de los restaurantes a buscar.
     * @return Lista de restaurantes con un precio máximo indicado.
     */
    @Query("SELECT r FROM Restaurante  r WHERE r.precio <= :precioMedio")
    List<Restaurante> restaurantesPorPrecioMaximo(Double precioMedio);

    /**
     * Obtiene una lista de restaurantes con un precio mínimo indicado.
     *
     * @param precioMedio Precio mínimo de los restaurantes a buscar.
     * @return Lista de restaurantes con un precio mínimo indicado.
     */
    @Query("SELECT r FROM Restaurante  r WHERE r.precio >= :precioMedio")
    List<Restaurante> restaurantesPorPrecioMinimo(Double precioMedio);

}
