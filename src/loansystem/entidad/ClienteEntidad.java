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
public class ClienteEntidad {
    int idCliente,idMunicipio, diasCredito, idRutaVisita, idEmpresa;
String nombres,apellidos,numCedula, sexo, direccionPrincipal,direccionSecundaria,telefonoCasa,
telefonoMovil,telefonoVario_uno,telefonoVario_dos,    centroLaboral,telefonoLaboral, fechaAlta;
double limiteCredito;

    public int getIdCliente() {
        return idCliente;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public int getDiasCredito() {
        return diasCredito;
    }

    public int getIdRutaVisita() {
        return idRutaVisita;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNumCedula() {
        return numCedula;
    }

    public String getSexo() {
        return sexo;
    }

    public String getDireccionPrincipal() {
        return direccionPrincipal;
    }

    public String getDireccionSecundaria() {
        return direccionSecundaria;
    }

    public String getTelefonoCasa() {
        return telefonoCasa;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public String getTelefonoVario_uno() {
        return telefonoVario_uno;
    }

    public String getTelefonoVario_dos() {
        return telefonoVario_dos;
    }

    public String getCentroLaboral() {
        return centroLaboral;
    }

    public String getTelefonoLaboral() {
        return telefonoLaboral;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public void setDiasCredito(int diasCredito) {
        this.diasCredito = diasCredito;
    }

    public void setIdRutaVisita(int idRutaVisita) {
        this.idRutaVisita = idRutaVisita;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setNumCedula(String numCedula) {
        this.numCedula = numCedula;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setDireccionPrincipal(String direccionPrincipal) {
        this.direccionPrincipal = direccionPrincipal;
    }

    public void setDireccionSecundaria(String direccionSecundaria) {
        this.direccionSecundaria = direccionSecundaria;
    }

    public void setTelefonoCasa(String telefonoCasa) {
        this.telefonoCasa = telefonoCasa;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public void setTelefonoVario_uno(String telefonoVario_uno) {
        this.telefonoVario_uno = telefonoVario_uno;
    }

    public void setTelefonoVario_dos(String telefonoVario_dos) {
        this.telefonoVario_dos = telefonoVario_dos;
    }

    public void setCentroLaboral(String centroLaboral) {
        this.centroLaboral = centroLaboral;
    }

    public void setTelefonoLaboral(String telefonoLaboral) {
        this.telefonoLaboral = telefonoLaboral;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

}
