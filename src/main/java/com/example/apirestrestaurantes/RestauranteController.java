package com.example.apirestrestaurantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/restaurante")
public class RestauranteController {
    @Autowired
    private RestauranteRepository repository;

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
        return repository.getRestauranteByTipoComida(tipoComida);
    }

    @GetMapping("/menuDia/{menuDelDia}")
    public List<Restaurante> getRestaurantesPorMenuDia(@PathVariable Boolean menuDelDia) {
        return repository.getRestaurantesByMenuDelDia(menuDelDia);
    }

    @GetMapping("/menuInfantil/{menuInfantil}")
    public List<Restaurante> getRestaurantesPorMenuInfantil(@PathVariable Boolean menuInfantil) {
        return repository.getRestaurantesByMenuInfantil(menuInfantil);
    }

    @GetMapping("/precioMedio/{precioMedio}")
    public List<Restaurante> getRestaurantesPorPrecioMedio(@PathVariable Double precioMedio) {
        return repository.getRestaurantesByPrecioMedio(precioMedio);
    }

    @GetMapping("/listaNombres")
    public List<String> getListaNombres() {
        return repository.nombreRestaurantes();
    }

    @GetMapping("/cantidad")
    public Integer getNumeroRestaurantes() {
        return repository.cantidadDeRestaurantes();
    }
}
