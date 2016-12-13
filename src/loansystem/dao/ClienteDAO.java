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
import loansystem.entidad.ClienteEntidad;
import loansystem.entidad.PersonalEntidad;

/**
 *
 * @author JChavarria
 */

public class ClienteDAO {
     private Connection con;
    private Statement s;
    private ResultSet rs;

    public ClienteDAO(Connection con) {
        this.con = con;
    }
    
         /**** Lista clientes por id
     * @param idcliente
     * @return toda informacion del cliente*/
    
    public ClienteEntidad obtenerXCliente(int idCliente) {
       ClienteEntidad clieEntidad = null;
        try {
            s = con.createStatement();
               System.out.println ("SELECT idCliente, nombres, apellidos, numCedula, sexo, idMunicipio, "
                       + "direccionPrincipal, direccionSecundaria, limiteCredito, diasCredito,\n" +
                            "telefonoCasa, telefonoMovil, telefonoVario_uno, telefonoVario_dos, idRutaVisita, "
                       + "centroLaboral,"
                       + " telefonoLaboral, fechaAlta, idEmpresa \n" +
"FROM loan_system.cliente\n" +
"WHERE idCliente ="+idCliente+";");
               
            rs = s.executeQuery("SELECT idCliente, nombres, apellidos, numCedula, sexo, idMunicipio, "
                       + "direccionPrincipal, direccionSecundaria, limiteCredito, diasCredito,\n" +
                            "telefonoCasa, telefonoMovil, telefonoVario_uno, telefonoVario_dos, idRutaVisita, "
                       + "centroLaboral,"
                       + " telefonoLaboral, fechaAlta, idEmpresa \n" +
"FROM loan_system.cliente\n" +
"WHERE idCliente ="+idCliente+";");
             

   
            while (rs.next()) {
               clieEntidad = this.convertir(rs);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return clieEntidad;
    }
    
    
        private ClienteEntidad convertir(ResultSet respuesta) {
        ClienteEntidad obj = new ClienteEntidad();
        try {
            
            obj.setIdCliente(respuesta.getInt("idCliente"));
            obj.setApellidos(respuesta.getString("apellidos"));
            obj.setNombres(respuesta.getString("nombres"));
            obj.setIdEmpresa(respuesta.getInt("idEmpresa"));
            obj.setFechaAlta(respuesta.getString("fechaAlta"));
            obj.setNumCedula(respuesta.getString("numCedula"));
            obj.setSexo(respuesta.getString("sexo"));
            obj.setCentroLaboral(respuesta.getString("centroLaboral"));
            obj.setDiasCredito(respuesta.getInt("diasCredito"));
            obj.setDireccionPrincipal(respuesta.getString("direccionPrincipal"));
            obj.setDireccionSecundaria(respuesta.getString("direccionSecundaria"));
            obj.setIdMunicipio(respuesta.getInt("idMunicipio"));
            obj.setIdRutaVisita(respuesta.getInt("idRutaVisita"));
            obj.setLimiteCredito(respuesta.getDouble("limiteCredito"));
            obj.setTelefonoCasa(respuesta.getString("telefonoCasa"));
            obj.setTelefonoLaboral(respuesta.getString("telefonoLaboral"));
            obj.setTelefonoMovil(respuesta.getString("telefonoMovil"));
            obj.setTelefonoVario_dos(respuesta.getString("telefonoVario_dos"));
            obj.setTelefonoVario_uno(respuesta.getString("telefonoVario_uno"));
                    
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return obj;
    }
    
}
