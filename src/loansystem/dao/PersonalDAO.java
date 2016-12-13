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
import loansystem.entidad.PersonalEntidad;

/**
 *
 * @author jechavarria
 */
public class PersonalDAO {
  private Connection con;
    private Statement s;
    private ResultSet rs;

    public PersonalDAO(Connection con) {
        this.con = con;
    }
    
        /**** Lista a una persona dependiendo de su idPersona
     * @param idPersona
     * @return toda informacion de la persona
     */
    public PersonalEntidad obtenerXPersona(int idPersona) {
        PersonalEntidad perEntidad = null;
        try {
            s = con.createStatement();
               System.out.println ("SELECT idPersona,\n" +
"    nombres,\n" +
"    apellidos,\n" +
"    numCedula,\n" +
"    sexo,\n" +
"    idCargo,\n" +
"    fechaRegistro,\n" +
"    idEmpresa\n" +
"FROM personal\n" +
"WHERE idPersona = "+idPersona+";");
               
            rs = s.executeQuery("SELECT idPersona,\n" +
"    nombres,\n" +
"    apellidos,\n" +
"    numCedula,\n" +
"    sexo,\n" +
"    idCargo,\n" +
"    fechaRegistro,\n" +
"    idEmpresa\n" +
"FROM personal\n" +
"WHERE idPersona = "+idPersona+";");
             

   
            while (rs.next()) {
                perEntidad = this.convertir(rs);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PersonalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return perEntidad;
    }
       
    
        private PersonalEntidad convertir(ResultSet respuesta) {
        PersonalEntidad obj = new PersonalEntidad();
        try {
            
            obj.setIdPersona(respuesta.getInt("idPersona"));
            obj.setIdEmpresa(respuesta.getInt("idEmpresa"));
            obj.setIdCargo(respuesta.getInt("idCargo"));
            obj.setNombres(respuesta.getString("nombres"));
            obj.setApellidos(respuesta.getString("apellidos"));
            obj.setFechaRegistro(respuesta.getString("fechaRegistro"));
            obj.setNumCedula(respuesta.getString("numCedula"));
            obj.setSexo(respuesta.getString("sexo"));
                    
        } catch (SQLException ex) {
            Logger.getLogger(PersonalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return obj;
    }
}
