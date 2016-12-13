/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loansystem.bd;

 
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jenniffer
 */
public class Conexion {
private Connection con;
private String usuario;
private String contrasenia;
private String baseDatos;
private String servidor;
/**
     *
     * @param usuario
     * @param contrasenia
     * @param baseDatos
     * @param servidor
     */
public Conexion(String usuario, String contrasenia, String baseDatos, String servidor)
{
    this.usuario = usuario;
    this.contrasenia = contrasenia;
    this.baseDatos = baseDatos;
    this.servidor = servidor;

    System.out.println("======= "+this.usuario+"  "+this.contrasenia+"  "+this.baseDatos+"  "+this.servidor);
}

    /**
     * Retorna el objeto conexion, pero primero verifica que este abierta, de lo contrario vuelve a realizar la conexion
     * @return con
     */
    public Connection getCon() {
        try {
            if (con == null ||con.isClosed()) {
                abrirConeccion();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return con;
      
    }

    /**
     * Abre la conexion
     * @return
     */
    public boolean abrirConeccion()
    {
        try
            {
                MysqlDataSource dataSource = new MysqlDataSource();
                dataSource.setUser(usuario);
                dataSource.setPassword(contrasenia);
                dataSource.setDatabaseName(baseDatos);
                dataSource.setServerName(servidor);
              

                con = dataSource.getConnection();

                System.out.println("Conexión Establecida");
                return true;
            }catch(Exception e)
            {
              System.out.println("Error al intentar conectarse con "+servidor+"\n"+e.getMessage());
              return false;
            }
    }

    /**
     * Cierra las conexiones abiertas..
     */
    public void cerrarSesion()
    {   try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
 }

    public void VerifiarCuentaSistema(){
    

    }

}
