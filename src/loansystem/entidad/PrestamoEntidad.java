/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loansystem.entidad;

import java.util.Date;

/**
 *
 * @author jechavarria
 */
public class PrestamoEntidad {

    private int idPrestamo, idCliente, idPlazo, cantPeriodo, idMoneda, idFrecuenciaPago, cantFrecuencia, estado,
            diasPenalidad;
    private int plazoDias;
    private int cantidadCuotas;
    private int frecuenciaDias;
    private String fechaInicio, fechaVencimiento;
    private double montoOriginal, montoTasa, montoCargos, montoTotal, montoCuota, montoPenalidad;
    private double tasa, tasaCargo;
    private Date fechaCreacion;
    private String descEstado;
    
    private double saldoActual = 0;
    private String fechaUltimoPago = "";
    private double ultimoPago = 0;
    private String simboloMoneda="", moneda="";
    private String plazoPrestamo = "", frecueciaPago = "";
    
    

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

    public double getTasa() {
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

    public void setTasa(double tasa) {
        this.tasa = tasa;
    }

    /**
     * @return the plazoDias
     */
    public int getPlazoDias() {
        return plazoDias;
    }

    /**
     * @return the cantidadCuotas
     */
    public int getCantidadCuotas() {
        return cantidadCuotas;
    }

    /**
     * @return the frecuenciaDias
     */
    public int getFrecuenciaDias() {
        return frecuenciaDias;
    }

    /**
     * @return the fechaCreacion
     */
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * @param fechaCreacion the fechaCreacion to set
     */
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * @param plazoDias the plazoDias to set
     */
    public void setPlazoDias(int plazoDias) {
        this.plazoDias = plazoDias;
    }

    /**
     * @param cantidadCuotas the cantidadCuotas to set
     */
    public void setCantidadCuotas(int cantidadCuotas) {
        this.cantidadCuotas = cantidadCuotas;
    }

    /**
     * @param frecuenciaDias the frecuenciaDias to set
     */
    public void setFrecuenciaDias(int frecuenciaDias) {
        this.frecuenciaDias = frecuenciaDias;
    }

    /**
     * @return the tasaMonto
     */
    public double getTasaCargo() {
        return tasaCargo;
    }

    /**
     * @param tasaMonto the tasaMonto to set
     */
    public void setTasaCargo(double tasaMonto) {
        this.tasaCargo = tasaMonto;
    }

    /**
     * @return the descEstado
     */
    public String getDescEstado() {
        return descEstado;
    }

    /**
     * @param descEstado the descEstado to set
     */
    public void setDescEstado(String descEstado) {
        this.descEstado = descEstado;
    }

    /**
     * @return the montoTasa
     */
    public double getMontoTasa() {
        return montoTasa;
    }

    /**
     * @param montoTasa the montoTasa to set
     */
    public void setMontoTasa(double montoTasa) {
        this.montoTasa = montoTasa;
    }

    /**
     * @return the saldoActual
     */
    public double getSaldoActual() {
        return saldoActual;
    }

    /**
     * @param saldoActual the saldoActual to set
     */
    public void setSaldoActual(double saldoActual) {
        this.saldoActual = saldoActual;
    }


    /**
     * @return the fechaUltimoPago
     */
    public String getFechaUltimoPago() {
        return fechaUltimoPago;
    }

    /**
     * @param fechaUltimoPago the fechaUltimoPago to set
     */
    public void setFechaUltimoPago(String fechaUltimoPago) {
        this.fechaUltimoPago = fechaUltimoPago;
    }

    /**
     * @return the ultimoPago
     */
    public double getUltimoPago() {
        return ultimoPago;
    }

    /**
     * @param ultimoPago the ultimoPago to set
     */
    public void setUltimoPago(double ultimoPago) {
        this.ultimoPago = ultimoPago;
    }

    /**
     * @return the simboloMoneda
     */
    public String getSimboloMoneda() {
        return simboloMoneda;
    }

    /**
     * @param simboloMoneda the simboloMoneda to set
     */
    public void setSimboloMoneda(String simboloMoneda) {
        this.simboloMoneda = simboloMoneda;
    }

    /**
     * @return the moneda
     */
    public String getMoneda() {
        return moneda;
    }

    /**
     * @param moneda the moneda to set
     */
    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    /**
     * @return the plazoPrestamo
     */
    public String getPlazoPrestamo() {
        return plazoPrestamo;
    }

    /**
     * @param plazoPrestamo the plazoPrestamo to set
     */
    public void setPlazoPrestamo(String plazoPrestamo) {
        this.plazoPrestamo = plazoPrestamo;
    }

    /**
     * @return the frecueciaPago
     */
    public String getFrecueciaPago() {
        return frecueciaPago;
    }

    /**
     * @param frecueciaPago the frecueciaPago to set
     */
    public void setFrecueciaPago(String frecueciaPago) {
        this.frecueciaPago = frecueciaPago;
    }

}
