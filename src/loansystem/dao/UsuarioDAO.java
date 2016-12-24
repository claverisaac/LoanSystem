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
import java.util.ArrayList;
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
    
      /***
     * Lista a un usuario dependiendo de ID
     * @param nombre_usuario
     * @param pass
     * @return toda informacion del usuario
     */
        public UsuarioEntidad obtenerXUsuarioIdPersona(int id) {
        UsuarioEntidad userEntidad = null;
        try {
            s = con.createStatement();
            rs = s.executeQuery("select idusuario, idpersona, login, pass, estado "
                    + "from  usuario where idPersona = " + id + ";");
            
             System.out.println("select idusuario, idpersona, login, pass, estado "
                    + "from  usuario where idPersona = " + id + ";");
   
            while (rs.next()) {
                userEntidad = this.convertir(rs);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return userEntidad;
    }

          public UsuarioEntidad obtenerCantLogins(String login) {
        UsuarioEntidad userEntidad = null;
        try {
            s = con.createStatement();
            rs = s.executeQuery("select count(*) AS cantidad FROM usuario where login like '%" + login + "%';");
            
             System.out.println("select count(*) AS cantidad FROM usuario where login like '%" + login + "%';");
   
            while (rs.next()) {
                userEntidad = this.convertirCant(rs);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return userEntidad;
    }
          
                    public UsuarioEntidad conv_md5(String palabra) {
        UsuarioEntidad userEntidad = null;
        try {
            s = con.createStatement();
            rs = s.executeQuery("SELECT MD5('"+palabra+"') as new_pass;");
            
             System.out.println("SELECT MD5('"+palabra+"') as new_pass;");
   
            while (rs.next()) {
                userEntidad = this.convertirPalabra(rs);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return userEntidad;
    }
                
         public ArrayList<UsuarioEntidad> obtenerTodosUsuarios() {
        ArrayList<UsuarioEntidad> lista = new ArrayList<UsuarioEntidad>();
        try {
            s = con.createStatement();
            System.out.println("select idUsuario,idPersona, login, pass,estado from loan_system.usuario ;");

            rs = s.executeQuery("select idUsuario,idPersona, login, pass,estado from loan_system.usuario;");

            while (rs.next()) {
                lista.add(this.convertir(rs));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }
     
        public ArrayList<UsuarioEntidad> obtenerUsuariosXlogiin(String logi) {
        ArrayList<UsuarioEntidad> lista = new ArrayList<UsuarioEntidad>();
        try {
            s = con.createStatement();
            System.out.println("select idUsuario,idPersona, login, pass,estado from loan_system.usuario where login = '"+logi+"';");

            rs = s.executeQuery("select idUsuario,idPersona, login, pass,estado from loan_system.usuario where login = '"+logi+"';");

            while (rs.next()) {
                lista.add(this.convertir(rs));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }
         
    public boolean insertarUsuario(UsuarioEntidad obj) {
        //ProductoEntidad id = null;
        boolean exito = false;
        try {
            s = con.createStatement();
            System.out.println("INSERT INTO usuario(idPersona, login, pass ,estado) VALUES("
                    + obj.getIdPersona()+ ",'"
                    + obj.getLogin()+ "',md5('"
                    + obj.getPass()+ "'),"
                    + obj.getEstado()+ ");");

            exito = s.execute("INSERT INTO usuario(idPersona, login, pass ,estado) VALUES("
                    + obj.getIdPersona()+ ",'"
                    + obj.getLogin()+ "',md5('"
                    + obj.getPass()+ "'),"
                    + obj.getEstado()+ ");");

            exito = true;

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exito;
    }
         
             /* ACTUALIZAR CLEINTE
     */
    public boolean updateEstadoUsuario(UsuarioEntidad obj, int id) {
        //ProductoEntidad id = null;
        boolean exito = false;
        try {
            s = con.createStatement();
            System.out.println("");

            System.out.println("update usuario set estado = "+obj.getEstado()+" where idUsuario= " + id + ";");

            exito = s.execute("update usuario set estado = "+obj.getEstado()+" where idUsuario= " + id + ";");
            exito = true;

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exito;
    }
         
 
        
        public boolean updatePassUsuario(UsuarioEntidad obj,String login, String passA) {
        //ProductoEntidad id = null;
        boolean exito = false;
        try {
            s = con.createStatement();
            System.out.println("");

            System.out.println("update usuario set pass = md5('"+obj.getPass()+"') where login='"+login+"' and pass =md5('"+passA+"');");

            exito = s.execute("update usuario set pass = md5('"+obj.getPass()+"') where login='"+login+"' and pass =md5('"+passA+"');");
            exito = true;

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exito;
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
                private UsuarioEntidad convertirPalabra(ResultSet respuesta) {
        UsuarioEntidad obj = new UsuarioEntidad();
        try {

       
            obj.setPass_new(respuesta.getString("new_pass"));
          

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return obj;
    }
                
              private UsuarioEntidad convertirCant(ResultSet respuesta) {
        UsuarioEntidad obj = new UsuarioEntidad();
        try {

            obj.setCantidad(respuesta.getInt("cantidad"));
       

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return obj;
    }
}
