/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio_apistream;

import java.util.List;

public class Director {
    private int idDirector;
    private String nombreDirector;
    private List<String> premios;

    public Director(int idDirector, String nombreDirector, List<String> premios) {
        this.idDirector = idDirector;
        this.nombreDirector = nombreDirector;
        this.premios = premios;
    }

    public String getNombreDirector() {
        return nombreDirector;
    }
}
