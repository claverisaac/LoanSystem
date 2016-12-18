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
import loansystem.entidad.CuotasEntidad;

/**
 *
 * @author jechavarria
 */
public class CuotasDAO {
private Connection con;
private ResultSet rs;
private Statement s;

public CuotasDAO(Connection con) {
        this.con = con;
}

/**
 * 
 * @param obj
 * @return 
 */
 public int insertarCuota(CuotasEntidad obj) {
        //ProductoEntidad id = null;
        boolean exito = false;
         int id = 0;
         
        try {
            s = con.createStatement();
            StringBuilder query = new StringBuilder();
            
            query.append("INSERT INTO detallecuotas (idPrestamo, pagoNumero, fecha, dia, monto, saldo, cancelado) ");           
            query.append("VALUES ("+obj.getIdPrestamo()+", '"+obj.getPagoNumero()+"', '"+obj.getFecha()+"', '"+obj.getDia()+"', ");
            query.append(""+obj.getMonto()+", "+obj.getSaldo()+",0 );");
           
            System.out.println("QUERY: "+query.toString());
            
            exito = s.execute(query.toString());
           
             ResultSet rs = s.getGeneratedKeys();
            if (rs.next()){
                id=rs.getInt(1);
            }
            
            exito = true;

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
 
}
