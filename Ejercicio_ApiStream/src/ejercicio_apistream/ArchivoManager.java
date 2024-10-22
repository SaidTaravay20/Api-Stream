/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio_apistream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArchivoManager {

    // Método para escribir datos de Películas en un archivo .txt
    public static void guardarPeliculas(List<Pelicula> peliculas, String archivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Pelicula pelicula : peliculas) {
                writer.write(pelicula.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para escribir datos de Países en un archivo .txt
    public static void guardarPaises(List<Pais> paises, String archivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Pais pais : paises) {
                writer.write(pais.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para leer las líneas de un archivo .txt
    public static List<String> leerArchivo(String archivo) {
        List<String> lineas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineas;
    }
}
