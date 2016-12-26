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
import loansystem.entidad.CargoEntidad;
import loansystem.entidad.ClienteEntidad;

/**
 *
 * @author JChavarria
 */
public class CargoDAO {
      private Connection con;
    private Statement s;
    private ResultSet rs;

    public CargoDAO(Connection con) {
        this.con = con;
    }
    
      public ArrayList<CargoEntidad> obtenerTodosCargos() {
        ArrayList<CargoEntidad> lista = new ArrayList<CargoEntidad>();
        try {
            s = con.createStatement();
            System.out.println("SELECT idCargo, cargo, descripcion \n" +
"FROM loan_system.cargo;");

            rs = s.executeQuery("SELECT idCargo, cargo, descripcion \n" +
"FROM loan_system.cargo;");

            while (rs.next()) {
                lista.add(this.convertir(rs));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }
      
                public CargoEntidad obtenerCargoXnombre(String cargo) {
        CargoEntidad lista = null;
        try {
            s = con.createStatement();
            System.out.println("SELECT idCargo, cargo, descripcion \n" +
"FROM loan_system.cargo WHERE cargo ='" + cargo+ "';");

            rs = s.executeQuery("SELECT idCargo, cargo, descripcion \n" +
"FROM loan_system.cargo WHERE cargo ='" + cargo+ "';");

            while (rs.next()) {
                lista = this.convertir(rs);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }
      
          public CargoEntidad obtenerCargo(int idCargo) {
        CargoEntidad lista = null;
        try {
            s = con.createStatement();
            System.out.println("SELECT idCargo, cargo, descripcion \n" +
"FROM loan_system.cargo WHERE idCargo =" + idCargo+ ";");

            rs = s.executeQuery("SELECT idCargo, cargo, descripcion \n" +
"FROM loan_system.cargo WHERE idCargo =" + idCargo+ ";");

            while (rs.next()) {
                lista = this.convertir(rs);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }
          private CargoEntidad convertir(ResultSet respuesta) {
        CargoEntidad obj = new CargoEntidad();
        try {

            obj.setIdCargo(respuesta.getInt("idCargo"));
            obj.setCargo(respuesta.getString("cargo"));
            obj.setDescripcion(respuesta.getString("descripcion"));
           

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return obj;
    }
}
