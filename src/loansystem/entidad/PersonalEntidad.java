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
public class PersonalEntidad {
int idPersona,idCargo, idEmpresa;
String nombres,apellidos,numCedula,sexo, fechaRegistro;
String login;

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public int getIdCargo() {
        return idCargo;
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

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
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

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

        
}
