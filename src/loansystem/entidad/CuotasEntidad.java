/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loansystem.entidad;

import java.util.Date;

/**
 *
 * @author cgarcia
 */
public class CuotasEntidad {
    private int idCuota;
    private int idPrestamo;
    private String pagoNumero;
    private String fecha;
    private String dia;
    private double monto;
    private double saldo;
    private int cancelado;

    /**
     * @return the idCuota
     */
    public int getIdCuota() {
        return idCuota;
    }

    /**
     * @param idCuota the idCuota to set
     */
    public void setIdCuota(int idCuota) {
        this.idCuota = idCuota;
    }

    /**
     * @return the idPrestamo
     */
    public int getIdPrestamo() {
        return idPrestamo;
    }

    /**
     * @param idPrestamo the idPrestamo to set
     */
    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    /**
     * @return the pagoNumero
     */
    public String getPagoNumero() {
        return pagoNumero;
    }

    /**
     * @param pagoNumero the pagoNumero to set
     */
    public void setPagoNumero(String pagoNumero) {
        this.pagoNumero = pagoNumero;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the dia
     */
    public String getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(String dia) {
        this.dia = dia;
    }

    /**
     * @return the monto
     */
    public double getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }

    /**
     * @return the saldo
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * @return the cancelado
     */
    public int getCancelado() {
        return cancelado;
    }

    /**
     * @param cancelado the cancelado to set
     */
    public void setCancelado(int cancelado) {
        this.cancelado = cancelado;
    }
    
    
    
}
