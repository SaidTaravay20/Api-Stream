/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio_apistream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        // Crear algunos ejemplos de Genero
        Genero drama = new Genero(1, "Drama");
        Genero comedia = new Genero(2, "Comedia");
        Genero accion = new Genero(3, "Accion");
        Genero terror = new Genero(4, "Terror");
        Genero cienciaFiccion = new Genero(5, "Ciencia Ficcion");
        Genero aventura = new Genero(6, "Aventura");


        // Crear algunos ejemplos de Ciudad
        Ciudad ciudad1 = new Ciudad(1, "Lima", 10000000, "AMERICA");
        Ciudad ciudad2 = new Ciudad(2, "Bogota", 8000000, "AMERICA");
        Ciudad ciudad3 = new Ciudad(3, "Paris", 2000000, "EUROPA");
        Ciudad ciudad4 = new Ciudad(4, "Nueva York", 8500000, "AMERICA");
        Ciudad ciudad5 = new Ciudad(5, "Ciudad de Mexico", 9200000, "AMERICA");
        Ciudad ciudad6 = new Ciudad(6, "Tokio", 37000000, "ASIA");
        Ciudad ciudad7 = new Ciudad(7, "Sídney", 5000000, "OCEANIA");
        Ciudad ciudad8 = new Ciudad(8, "El Cairo", 20000000, "AFRICA");


        // Crear algunos ejemplos de País
        Pais peru = new Pais("PE", "Peru", "AMERICA", 1285216, 1, 33000000, Arrays.asList(ciudad1));
        Pais colombia = new Pais("CO", "Colombia", "AMERICA", 1141748, 1, 50800000, Arrays.asList(ciudad2));
        Pais francia = new Pais("FR", "Francia", "EUROPA", 643801, 1, 67000000, Arrays.asList(ciudad3));
        Pais mexico = new Pais("MX", "Mexico", "AMERICA", 1964375, 1, 128932753, Arrays.asList(ciudad5));
       Pais japon = new Pais("JP", "Japon", "ASIA", 377975, 1, 126476461, Arrays.asList(ciudad6));
       Pais australia = new Pais("AU", "Australia", "OCEANIA", 7692024, 1, 25687041, Arrays.asList(ciudad7));
       Pais egipto = new Pais("EG", "Egipto", "AFRICA", 1010408, 1, 102334404, Arrays.asList(ciudad8));
      Pais estadosUnidos = new Pais("US", "Estados Unidos", "AMERICA", 9833517, 1, 331449281, Arrays.asList(ciudad4));


        // Crear algunos ejemplos de Pelicula
        Pelicula pelicula1 = new Pelicula(1, "La vida es bella", 1997, "9.5", Arrays.asList(drama, comedia), null);
        Pelicula pelicula2 = new Pelicula(2, "El Gran Lebowski", 1998, "9.0", Arrays.asList(comedia), null);

        List<Pais> paises = Arrays.asList(peru, colombia, francia);
        List<Pelicula> peliculas = Arrays.asList(pelicula1, pelicula2);

        // Guardar los datos en archivos .txt
        ArchivoManager.guardarPaises(paises, "paises.txt");
        ArchivoManager.guardarPeliculas(peliculas, "peliculas.txt");

        // Leer los datos de los archivos (opcional)
        List<String> paisesLeidos = ArchivoManager.leerArchivo("paises.txt");
        List<String> peliculasLeidas = ArchivoManager.leerArchivo("peliculas.txt");

        // Mostrar lo leído
        paisesLeidos.forEach(System.out::println);
        peliculasLeidas.forEach(System.out::println);

        // 1. Ciudades más pobladas de cada continente
        Map<String, Optional<Ciudad>> ciudadesPorContinente = Operaciones.ciudadesMasPobladasPorContinente(paises);
        ciudadesPorContinente.forEach((continente, ciudad) -> 
            System.out.println("Continente: " + continente + " -> Ciudad mas poblada: " + ciudad.orElse(null)));

        // 2. Ciudad más poblada de todos los continentes
        Optional<Ciudad> ciudadMasPoblada = Operaciones.ciudadMasPoblada(paises);
        ciudadMasPoblada.ifPresent(ciudad -> System.out.println("Ciudad mas poblada: " + ciudad));

        // 3. Películas que son solo Drama y Comedia
        List<Pelicula> dramaComedia = Operaciones.peliculasDramaComedia(peliculas);
        dramaComedia.forEach(pelicula -> System.out.println("Pelicula Drama-Comedia: " + pelicula));

        // 4. Ordenar países por número de ciudades
        List<Pais> paisesPorCiudades = Operaciones.ordenarPaisesPorCiudades(paises);
        paisesPorCiudades.forEach(pais -> System.out.println("Pais por ciudades: " + pais));

        // 5. Ordenar países por número de población
        List<Pais> paisesPorPoblacion = Operaciones.ordenarPaisesPorPoblacion(paises);
        paisesPorPoblacion.forEach(pais -> System.out.println("Pais por poblacion: " + pais));
    }
}
