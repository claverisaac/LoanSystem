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
public class AbonoEntidad {
    
    int idAbono, idPrestamo;
double montoAbonado,nuevoSaldo;
String fecha;

    public int getIdAbono() {
        return idAbono;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public double getMontoAbonado() {
        return montoAbonado;
    }

    public double getNuevoSaldo() {
        return nuevoSaldo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setIdAbono(int idAbono) {
        this.idAbono = idAbono;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public void setMontoAbonado(double montoAbonado) {
        this.montoAbonado = montoAbonado;
    }

    public void setNuevoSaldo(double nuevoSaldo) {
        this.nuevoSaldo = nuevoSaldo;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    

    
}
