/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loansystem.entidad;

/**
 *
 * @author jechavarria
 */
public class PlazoEntidad {
    int idPlazo, dias;
String  plazo,descripcion;

    public int getIdPlazo() {
        return idPlazo;
    }

    public int getDias() {
        return dias;
    }

    public String getPlazo() {
        return plazo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setIdPlazo(int idPlazo) {
        this.idPlazo = idPlazo;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public void setPlazo(String plazo) {
        this.plazo = plazo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    

}
