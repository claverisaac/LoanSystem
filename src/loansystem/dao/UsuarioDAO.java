/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loansystem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import loansystem.entidad.UsuarioEntidad;

/**
 *
 * @author jechavarria
 */
public class UsuarioDAO {
 private Connection con;
    private Statement s;
    private ResultSet rs;
    
    
    public UsuarioDAO(Connection con){
    this.con = con;
       
    }
    
    /***
     * Lista a un usuario dependiendo de su usuario y contraseña
     * @param nombre_usuario
     * @param pass
     * @return toda informacion del usuario
     */
    public UsuarioEntidad obtenerXUsuarioPass(String nombre_usuario, String pass) {
        UsuarioEntidad userEntidad = null;
        try {
            s = con.createStatement();
            rs = s.executeQuery("select idusuario, idpersona, login, pass, estado "
                    + "from  usuario where login= '" + nombre_usuario + "' " +
                    "and pass =  md5('"+pass+"');");
            
             System.out.println("select idusuario, idpersona, login, pass, estado "
                    + "from  usuario where login= '" + nombre_usuario + "' " +
                    "and pass =  md5('"+pass+"');");
   
            while (rs.next()) {
                userEntidad = this.convertir(rs);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return userEntidad;
    }

        private UsuarioEntidad convertir(ResultSet respuesta) {
        UsuarioEntidad obj = new UsuarioEntidad();
        try {

            obj.setIdUsuario(respuesta.getInt("idUsuario"));
            obj.setIdPersona(respuesta.getInt("idPersona"));
            obj.setLogin(respuesta.getString("login"));
            obj.setPass(respuesta.getString("pass"));
            obj.setEstado(respuesta.getInt("estado"));

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return obj;
    }
}
