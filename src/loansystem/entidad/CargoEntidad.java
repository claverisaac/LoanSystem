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
public class CargoEntidad {
    
int idCargo;
String cargo, descripcion;

    public int getIdCargo() {
        return idCargo;
    }

    public String getCargo() {
        return cargo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
