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
import loansystem.entidad.PrestamoEntidad;

/**
 *
 * @author jechavarria
 */
public class PrestamoDAO {
private Connection con;
private ResultSet rs;
private Statement s;

public PrestamoDAO(Connection con) {
        this.con = con;
}

/**
 * 
 * @param obj
 * @return 
 */
 public boolean insertarPrestamo(PrestamoEntidad obj) {
        //ProductoEntidad id = null;
        boolean exito = false;
        try {
            s = con.createStatement();
            StringBuilder query = new StringBuilder();
            
            query.append("INSERT INTO prestamo (idCliente, fechaInicio, fechaVencimiento, idPlazo, ");
            query.append("cantPeriodo, idMoneda, plazoDias, montoOriginal, tasa, tasaCargos, montoCargos, ");
            query.append("montoTotal, cantidadCuotas, montoCuota, idFrecuenciaPago, cantFrecuencia, ");
            query.append("frecuenciaDias, montoPenalidad, diasPenalidad, estado, fechaCreacion) ");
            query.append("VALUES ("+obj.getIdCliente()+", '"+obj.getFechaInicio()+"', '"+obj.getFechaVencimiento()+"', ");
            query.append(""+obj.getIdPlazo()+", "+obj.getCantPeriodo()+", "+obj.getIdMoneda()+", "+obj.getPlazoDias()+", "+obj.getMontoOriginal()+", "+obj.getTasa()+", "+obj.getTasaCargo()+", "+obj.getMontoCargos());
            query.append(", "+obj.getMontoTotal()+","+obj.getCantidadCuotas()+","+obj.getMontoCuota()+","+obj.getIdFrecuenciaPago()+","+obj.getCantFrecuencia());
            query.append(","+obj.getFrecuenciaDias()+","+obj.getMontoPenalidad()+","+obj.getDiasPenalidad()+","+obj.getEstado()+", current_timestamp() );");
           
            System.out.println("QUERY: "+query.toString());
            
            exito = s.execute(query.toString());

            exito = true;

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exito;
    }
    
 
}
