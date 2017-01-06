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
import loansystem.entidad.CuotasEntidad;
import loansystem.entidad.CuotasEntidad;
import loansystem.utilidades.MetodosGenerales;

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
 
 /**
  * 
  * @param idPrestamo
  * @return 
  */
  public ArrayList<CuotasEntidad> obtenerCuotasPorPrestamo(int idPrestamo) {

        ArrayList<CuotasEntidad> lista = new ArrayList<CuotasEntidad>();

        try {
            //preparamos la ejecucion del query
            s = con.createStatement();

            StringBuilder query = new StringBuilder();
            query.append("select idCuota,pagoNumero, dc.idPrestamo, fecha, dia, monto, saldo, cancelado, (select ifnull(sum(montoAbonado),0) ");            
            query.append("from abono as a where a.idPrestamo = dc.idPrestamo) as 'Abonado'  ");
            query.append("from detallecuotas as dc  ");
            query.append("where dc.idPrestamo = " + idPrestamo + ";");

            System.out.println(query.toString());
            rs = s.executeQuery(query.toString());

            //Recorremos cada registro agregandolo al ArrayList
            while (rs.next()) {
                lista.add(this.convertir(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }
  
  public int actualizarEstadoCuota(int idCuota, int cancelado) {
        //ProductoEntidad id = null;
        boolean exito = false;
         int id = 0;
         
        try {
            s = con.createStatement();
            StringBuilder query = new StringBuilder();
            
            query.append("update detallecuotas set cancelado = "+cancelado+" where idCuota = "+idCuota +";");           
          
           
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
 
  private CuotasEntidad convertir(ResultSet respuesta) {
        CuotasEntidad obj = new CuotasEntidad();
        try {

            obj.setIdCuota(respuesta.getInt("idCuota"));            
            obj.setIdPrestamo(respuesta.getInt("idPrestamo"));
            obj.setPagoNumero(respuesta.getString("pagoNumero"));
            obj.setFecha(MetodosGenerales.formatFecha(respuesta.getDate("fecha"), "dd/MM/yyyy"));
            obj.setDia(respuesta.getString("dia"));
            obj.setMonto(respuesta.getDouble("monto"));
            obj.setSaldo(respuesta.getDouble("saldo"));
            obj.setCancelado(respuesta.getInt("cancelado"));
            obj.setAbonado(respuesta.getDouble("abonado"));
            

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return obj;
    }
    
 
}
