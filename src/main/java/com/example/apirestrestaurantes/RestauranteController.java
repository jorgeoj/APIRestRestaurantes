package com.example.apirestrestaurantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador que gestiona las operaciones relacionadas con los restaurantes en la API.
 *
 * @author Jorge Olmedo Jimenez
 * @version 1.0
 * @since 2024-02-14
 */
@RestController
@RequestMapping("/api/restaurante")
public class RestauranteController {

    @Autowired
    private RestauranteRepository repository;

    @Autowired
    private SecurityService security;

    /**
     * Obtiene la lista de todos los restaurantes.
     *
     * @return Lista de todos los restaurantes.
     */
    @GetMapping("/")
    public List<Restaurante> getAll() {
        return repository.findAll();
    }

    /**
     * Obtiene un restaurante por su identificador único.
     *
     * @param id Identificador único del restaurante.
     * @return El restaurante con el identificador proporcionado.
     */
    @GetMapping("/id/{id}")
    public Restaurante getRestaurantePorId(@PathVariable Long id) {
        return repository.getRestauranteById(id);
    }

    /**
     * Obtiene un restaurante por su nombre.
     *
     * @param nombre Nombre del restaurante.
     * @return El restaurante con el nombre proporcionado.
     */
    @GetMapping("/nombre/{nombre}")
    public Restaurante getRestaurantePorNombre(@PathVariable String nombre) {
        return repository.getRestauranteByNombre(nombre);
    }

    /**
     * Obtiene una lista de restaurantes con la puntuación dada.
     *
     * @param puntuacion Puntuación de los restaurantes a buscar.
     * @return Lista de restaurantes con la puntuación proporcionada.
     */
    @GetMapping("/puntuacion/{puntuacion}")
    public List<Restaurante> getRestaurantesPorPuntuacion(@PathVariable Integer puntuacion) {
        return repository.getRestaurantesByPuntuacion(puntuacion);
    }

    /**
     * Obtiene un restaurante por su ubicación.
     *
     * @param ubicacion Ubicación del restaurante.
     * @return El restaurante en la ubicación proporcionada.
     */
    @GetMapping("/ubicacion/{ubicacion}")
    public Restaurante getRestaurantePorUbicacion(@PathVariable String ubicacion) {
        return repository.getRestauranteByUbicacion(ubicacion);
    }

    /**
     * Obtiene una lista de restaurantes por el tipo de comida que ofrecen.
     *
     * @param tipoComida Tipo de comida que ofrecen los restaurantes.
     * @return Lista de restaurantes con el tipo de comida proporcionado.
     */
    @GetMapping("/tipoComida/{tipoComida}")
    public List<Restaurante> getRestaurantePorTipoComida(@PathVariable String tipoComida) {
        return repository.getRestauranteByTipocomida(tipoComida);
    }

    /**
     * Obtiene una lista de restaurantes con la opción de menú del día especificada.
     *
     * @param menuDelDia Indica si los restaurantes ofrecen menú del día.
     * @return Lista de restaurantes con la opción de menú del día proporcionada.
     */
    @GetMapping("/menuDia/{menuDelDia}")
    public List<Restaurante> getRestaurantesPorMenuDia(@PathVariable Boolean menuDelDia) {
        return repository.getRestaurantesByMenu(menuDelDia);
    }

    /**
     * Obtiene una lista de restaurantes con la opción de menú infantil especificada.
     *
     * @param menuInfantil Indica si los restaurantes ofrecen menú infantil.
     * @return Lista de restaurantes con la opción de menú infantil proporcionada.
     */
    @GetMapping("/menuInfantil/{menuInfantil}")
    public List<Restaurante> getRestaurantesPorMenuInfantil(@PathVariable Boolean menuInfantil) {
        return repository.getRestaurantesByMenuinfantil(menuInfantil);
    }

    /**
     * Obtiene una lista de restaurantes con el precio medio indicado.
     *
     * @param precioMedio Precio medio de los restaurantes a buscar.
     * @return Lista de restaurantes con el precio medio proporcionado.
     */
    @GetMapping("/precioMedio/{precioMedio}")
    public List<Restaurante> getRestaurantesPorPrecioMedio(@PathVariable Double precioMedio) {
        return repository.getRestaurantesByPrecio(precioMedio);
    }

    /**
     * Obtiene una lista con los nombres de todos los restaurantes.
     *
     * @return Lista de nombres de restaurantes.
     */
    @GetMapping("/listaNombres")
    public List<String> getListaNombres() {
        return repository.nombreRestaurantes();
    }

    /**
     * Obtiene la cantidad total de restaurantes en la API.
     *
     * @return Cantidad total de restaurantes.
     */
    @GetMapping("/cantidad")
    public Integer getNumeroRestaurantes() {
        return repository.cantidadDeRestaurantes();
    }

    /**
     * Obtiene una lista de restaurantes con una puntuación igual o mayor a la indicada.
     *
     * @param puntuacionMinima Puntuación mínima de los restaurantes a buscar.
     * @return Lista de restaurantes con una puntuación igual o mayor a la indicada.
     */
    @GetMapping("/puntuacionMinima/{puntuacionMinima}")
    public List<Restaurante> getRestaurantesPuntuacionMinima(@PathVariable Integer puntuacionMinima) {
        return repository.getRestaurantesConPuntuacionMayorOIgual(puntuacionMinima);
    }

    /**
     * Obtiene una lista de restaurantes con un precio máximo indicado.
     *
     * @param precioMax Precio máximo de los restaurantes a buscar.
     * @return Lista de restaurantes con un precio máximo indicado.
     */
    @GetMapping("/precioMaximo/{precioMax}")
    public List<Restaurante> getRestaurantesPrecioMaximo(@PathVariable Double precioMax) {
        return repository.restaurantesPorPrecioMaximo(precioMax);
    }

    /**
     * Obtiene una lista de restaurantes con un precio mínimo indicado.
     *
     * @param precioMin Precio mínimo de los restaurantes a buscar.
     * @return Lista de restaurantes con un precio mínimo indicado.
     */
    @GetMapping("/precioMinimo/{precioMin}")
    public List<Restaurante> getRestaurantesPrecioMinimo(@PathVariable Double precioMin) {
        return repository.restaurantesPorPrecioMinimo(precioMin);
    }

    /**
     * Crea un nuevo restaurante y lo guarda en la base de datos.
     *
     * @param restaurante El nuevo restaurante a ser creado y guardado.
     * @param token       El token de seguridad para autorizar la operación.
     * @return ResponseEntity con el restaurante creado y el código de estado correspondiente.
     */
    @PostMapping("/post")
    public ResponseEntity<Restaurante> nuevo(@RequestBody Restaurante restaurante, @RequestParam String token) {
        if (security.validateToken(token)) {
            return new ResponseEntity<>(repository.save(restaurante), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * Actualiza la información de un restaurante existente.
     *
     * @param id              Identificador único del restaurante a actualizar.
     * @param restauranteNuevo La nueva información del restaurante.
     * @param token           El token de seguridad para autorizar la operación.
     * @return ResponseEntity con el restaurante actualizado y el código de estado correspondiente.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Restaurante> put(@PathVariable Long id, @RequestBody Restaurante restauranteNuevo, @RequestParam String token) {
        if (!security.validateToken(token)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            var restaurante = new Restaurante();
            var restauranteSeleccionado = repository.findById(id);

            if (restauranteSeleccionado.isEmpty()) {
                restaurante = restauranteNuevo;
            } else {
                restaurante = restauranteSeleccionado.get();
                restaurante.setNombre(restauranteNuevo.getNombre());
                restaurante.setPuntuacion(restauranteNuevo.getPuntuacion());
                restaurante.setUbicacion(restauranteNuevo.getUbicacion());
                restaurante.setTipocomida(restauranteNuevo.getTipocomida());
                restaurante.setMenu(restauranteNuevo.getMenu());
                restaurante.setMenuinfantil(restauranteNuevo.getMenuinfantil());
                restaurante.setPrecio(restauranteNuevo.getPrecio());
            }

            return new ResponseEntity<>(repository.save(restaurante), HttpStatus.OK);
        }
    }

    /**
     * Elimina un restaurante por su identificador único.
     *
     * @param id    Identificador único del restaurante a eliminar.
     * @param token El token de seguridad para autorizar la operación.
     * @return ResponseEntity con el restaurante eliminado y el código de estado correspondiente.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Restaurante> delete(@PathVariable Long id, @RequestParam String token) {
        ResponseEntity<Restaurante> response = new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        if (security.validateToken(token)) {
            Restaurante salida = new Restaurante();
            if (repository.existsById(id)) {
                salida = repository.findById(id).get();
                repository.deleteById(id);
                response = new ResponseEntity<>(salida, HttpStatus.OK);
            } else {
                response = new ResponseEntity<>(salida, HttpStatus.NOT_FOUND);
            }
        }

        return response;
    }
}
