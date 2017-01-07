/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loansystem.entidad;

/**
 *
 * @author cgarcia
 */
public class GraficoEntidad {

 private String serie;
 private String valorEje;
 private double valor;

    
    /**
     * @return the serie
     */
    public String getSerie() {
        return serie;
    }

    /**
     * @param serie the serie to set
     */
    public void setSerie(String serie) {
        this.serie = serie;
    }

    /**
     * @return the valorEje
     */
    public String getValorEje() {
        return valorEje;
    }

    /**
     * @param valorEje the valorEje to set
     */
    public void setValorEje(String valorEje) {
        this.valorEje = valorEje;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
