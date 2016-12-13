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
public class PrestamoEntidad {
int idPrestamo,idCliente, idPlazo, cantPeriodo, idMoneda, idFrecuenciaPago, cantFrecuencia, estado,
diasPenalidad;
String fechaInicio,fechaVencimiento;
double montoOriginal, montoCargos, montoTotal, montoCuota,montoPenalidad;
float tasa;


    public int getIdPrestamo() {
        return idPrestamo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getIdPlazo() {
        return idPlazo;
    }

    public int getCantPeriodo() {
        return cantPeriodo;
    }

    public int getIdMoneda() {
        return idMoneda;
    }

    public int getIdFrecuenciaPago() {
        return idFrecuenciaPago;
    }

    public int getCantFrecuencia() {
        return cantFrecuencia;
    }

    public int getEstado() {
        return estado;
    }

    public int getDiasPenalidad() {
        return diasPenalidad;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public double getMontoOriginal() {
        return montoOriginal;
    }

    public double getMontoCargos() {
        return montoCargos;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public double getMontoCuota() {
        return montoCuota;
    }

    public double getMontoPenalidad() {
        return montoPenalidad;
    }

    public float getTasa() {
        return tasa;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setIdPlazo(int idPlazo) {
        this.idPlazo = idPlazo;
    }

    public void setCantPeriodo(int cantPeriodo) {
        this.cantPeriodo = cantPeriodo;
    }

    public void setIdMoneda(int idMoneda) {
        this.idMoneda = idMoneda;
    }

    public void setIdFrecuenciaPago(int idFrecuenciaPago) {
        this.idFrecuenciaPago = idFrecuenciaPago;
    }

    public void setCantFrecuencia(int cantFrecuencia) {
        this.cantFrecuencia = cantFrecuencia;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setDiasPenalidad(int diasPenalidad) {
        this.diasPenalidad = diasPenalidad;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public void setMontoOriginal(double montoOriginal) {
        this.montoOriginal = montoOriginal;
    }

    public void setMontoCargos(double montoCargos) {
        this.montoCargos = montoCargos;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public void setMontoCuota(double montoCuota) {
        this.montoCuota = montoCuota;
    }

    public void setMontoPenalidad(double montoPenalidad) {
        this.montoPenalidad = montoPenalidad;
    }

    public void setTasa(float tasa) {
        this.tasa = tasa;
    }

}
