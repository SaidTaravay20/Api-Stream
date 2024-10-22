/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio_apistream;

/**
 *
 * @author saidjo
 */
public class Ciudad {
    private int idCiudad;
    private String nombreCiudad;
    private int nroPoblacion;
    private String codCiudad;

    public Ciudad(int idCiudad, String nombreCiudad, int nroPoblacion, String codCiudad) {
        this.idCiudad = idCiudad;
        this.nombreCiudad = nombreCiudad;
        this.nroPoblacion = nroPoblacion;
        this.codCiudad = codCiudad;
    }

    public int getNroPoblacion() {
        return nroPoblacion;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public String getCodCiudad() {
        return codCiudad;
    }

    @Override
    public String toString() {
        return nombreCiudad + " (" + nroPoblacion + ")";
    }
}
