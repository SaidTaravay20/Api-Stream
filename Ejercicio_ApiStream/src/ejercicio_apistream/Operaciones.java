/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio_apistream;

import java.util.*;
import java.util.stream.Collectors;

public class Operaciones {

    // 1. Encontrar las ciudades más pobladas de cada continente
    public static Map<String, Optional<Ciudad>> ciudadesMasPobladasPorContinente(List<Pais> paises) {
        return paises.stream()
                .flatMap(pais -> pais.getCiudades().stream())
                .collect(Collectors.groupingBy(Ciudad::getCodCiudad, 
                        Collectors.maxBy(Comparator.comparingInt(Ciudad::getNroPoblacion))));
    }

    // 2. Encontrar la ciudad más poblada de todos los continentes
    public static Optional<Ciudad> ciudadMasPoblada(List<Pais> paises) {
        return paises.stream()
                .flatMap(pais -> pais.getCiudades().stream())
                .max(Comparator.comparingInt(Ciudad::getNroPoblacion));
    }

    // 3. Encontrar la lista de películas que tienen los géneros "Drama" y "Comedia" solamente
    public static List<Pelicula> peliculasDramaComedia(List<Pelicula> peliculas) {
        return peliculas.stream()
                .filter(pelicula -> {
                    List<String> nombresGeneros = pelicula.getGeneros().stream()
                            .map(Genero::getNombreGenero)
                            .collect(Collectors.toList());
                    return nombresGeneros.containsAll(Arrays.asList("Drama", "Comedia")) && nombresGeneros.size() == 2;
                })
                .collect(Collectors.toList());
    }

    // 4. Ordena los países por número de sus ciudades en orden descendente
    public static List<Pais> ordenarPaisesPorCiudades(List<Pais> paises) {
        return paises.stream()
                .sorted(Comparator.comparingInt((Pais pais) -> pais.getCiudades().size()).reversed())
                .collect(Collectors.toList());
    }

    // 5. Ordena los países por número de población en orden ascendente
    public static List<Pais> ordenarPaisesPorPoblacion(List<Pais> paises) {
        return paises.stream()
                .sorted(Comparator.comparingInt(Pais::getNroPoblacion))
                .collect(Collectors.toList());
    }
}
