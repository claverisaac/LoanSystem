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
public class UsuarioEntidad {
int idUsuario,idPersona, estado;
String login,pass;

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }
    
    
}
