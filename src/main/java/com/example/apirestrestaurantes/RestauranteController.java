package com.example.apirestrestaurantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurante")
public class RestauranteController {
    @Autowired
    private RestauranteRepository repository;
    @Autowired
    private SecurityService security;

    @GetMapping("/")
    public List<Restaurante> getAll() {
        return repository.findAll();
    }

    @GetMapping("/id/{id}")
    public Restaurante getRestaurantePorId(@PathVariable Long id) {
        return repository.getRestauranteById(id);
    }

    @GetMapping("/nombre/{nombre}")
    public Restaurante getRestaurantePorNombre(@PathVariable String nombre) {
        return repository.getRestauranteByNombre(nombre);
    }

    @GetMapping("/puntuacion/{puntuacion}")
    public List<Restaurante> getRestaurantesPorPuntuacion(@PathVariable Integer puntuacion) {
        return repository.getRestaurantesByPuntuacion(puntuacion);
    }

    @GetMapping("/ubicacion/{ubicacion}")
    public Restaurante getRestaurantePorUbicacion(@PathVariable String ubicacion) {
        return repository.getRestauranteByUbicacion(ubicacion);
    }

    @GetMapping("/tipoComida/{tipoComida}")
    public List<Restaurante> getRestaurantePorTipoComida(@PathVariable String tipoComida) {
        return repository.getRestauranteByTipocomida(tipoComida);
    }

    @GetMapping("/menuDia/{menuDelDia}")
    public List<Restaurante> getRestaurantesPorMenuDia(@PathVariable Boolean menuDelDia) {
        return repository.getRestaurantesByMenu(menuDelDia);
    }

    @GetMapping("/menuInfantil/{menuInfantil}")
    public List<Restaurante> getRestaurantesPorMenuInfantil(@PathVariable Boolean menuInfantil) {
        return repository.getRestaurantesByMenuinfantil(menuInfantil);
    }

    @GetMapping("/precioMedio/{precioMedio}")
    public List<Restaurante> getRestaurantesPorPrecioMedio(@PathVariable Double precioMedio) {
        return repository.getRestaurantesByPrecio(precioMedio);
    }

    // Obtiene lista con todos los nombres de los restaurantes
    @GetMapping("/listaNombres")
    public List<String> getListaNombres() {
        return repository.nombreRestaurantes();
    }

    // Obtiene la cantidad de restaurantes que hay
    @GetMapping("/cantidad")
    public Integer getNumeroRestaurantes() {
        return repository.cantidadDeRestaurantes();
    }

    // Obtiene lista de restaurantes con la puntuación mayor o igual a la indicada
    @GetMapping("/puntuacionMinima/{puntuacionMinima}")
    public List<Restaurante> getRestaurantesPuntuacionMinima(@PathVariable Integer puntuacionMinima) {
        return repository.getRestaurantesConPuntuacionMayorOIgual(puntuacionMinima);
    }

    // Obtiene la lista de restaurantes con el precio menor o igual al indicado
    @GetMapping("/precioMaximo/{precioMax}")
    public List<Restaurante> getRestaurantesPrecioMaximo(@PathVariable Double precioMax) {
        return repository.restaurantesPorPrecioMaximo(precioMax);
    }

    // Obtiene la lista de restaurantes con el precio mayor o igual al indicado
    @GetMapping("/precioMinimo/{precioMin}")
    public List<Restaurante> getRestaurantesPrecioMinimo(@PathVariable Double precioMin) {
        return repository.restaurantesPorPrecioMinimo(precioMin);
    }

    // Método POST
    @PostMapping("/post")
    public ResponseEntity<Restaurante> nuevo(@RequestBody Restaurante restaurante, @RequestParam String token) {
        if (security.validateToken(token)) {
            return new ResponseEntity<>(repository.save(restaurante), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    // Método PUT
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

    // Método DELETE
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
