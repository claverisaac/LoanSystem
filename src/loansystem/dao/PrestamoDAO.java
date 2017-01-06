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
import loansystem.entidad.PrestamoEntidad;
import loansystem.utilidades.MetodosGenerales;

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
    public int insertarPrestamo(PrestamoEntidad obj) {
        //ProductoEntidad id = null;
        boolean exito = false;
        int id = 0;
        try {
            s = con.createStatement();
            StringBuilder query = new StringBuilder();

            query.append("INSERT INTO prestamo (idCliente, fechaInicio, fechaVencimiento, idPlazo, ");
            query.append("cantPeriodo, idMoneda, plazoDias, montoOriginal, tasa, montoTasa, tasaCargos, montoCargos, ");
            query.append("montoTotal, cantidadCuotas, montoCuota, idFrecuenciaPago, cantFrecuencia, ");
            query.append("frecuenciaDias, montoPenalidad, diasPenalidad, estado, fechaCreacion) ");
            query.append("VALUES (" + obj.getIdCliente() + ", '" + obj.getFechaInicio() + "', '" + obj.getFechaVencimiento() + "', ");
            query.append("" + obj.getIdPlazo() + ", " + obj.getCantPeriodo() + ", " + obj.getIdMoneda() + ", " + obj.getPlazoDias() + ", " + obj.getMontoOriginal() + ", " + obj.getTasa() + ", " 
                    + obj.getMontoTasa() + ", " + obj.getTasaCargo() + ", " + obj.getMontoCargos());
            query.append(", " + obj.getMontoTotal() + "," + obj.getCantidadCuotas() + "," + obj.getMontoCuota() + "," + obj.getIdFrecuenciaPago() + "," + obj.getCantFrecuencia());
            query.append("," + obj.getFrecuenciaDias() + "," + obj.getMontoPenalidad() + "," + obj.getDiasPenalidad() + "," + obj.getEstado() + ", current_timestamp() );");

            System.out.println("QUERY: " + query.toString());

            exito = s.execute(query.toString());

            ResultSet rs = s.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }

            exito = true;

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            id = 0;
        }
        return id;
    }

    public ArrayList<PrestamoEntidad> obtenerPrestamosPorCliente(int idCliente) {

        ArrayList<PrestamoEntidad> lista = new ArrayList<PrestamoEntidad>();

        try {
            //preparamos la ejecucion del query
            s = con.createStatement();

            StringBuilder query = new StringBuilder();
            query.append("SELECT p.idPrestamo, idCliente, fechaInicio, fechaVencimiento, idPlazo, cantPeriodo, ");
            query.append("idMoneda, plazoDias, montoOriginal, tasa, montoTasa, tasaCargos, montoCargos, montoTotal, ");
            query.append("cantidadCuotas, montoCuota, idFrecuenciaPago, cantFrecuencia, frecuenciaDias, ");
            query.append("montoPenalidad, diasPenalidad, estado ,ep.nombre as 'descEstado', fechaCreacion ");
            query.append("FROM prestamo as p inner join estadoprestamo as ep ");
            query.append("on p.estado = ep.idEstado ");
            query.append("where idCliente = " + idCliente + ";");

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

    /**
     * Retornamos lo Prestamos por cliente y por el estado indicado
     * @param idCliente
     * @param estado
     * @return 
     */
    public ArrayList<PrestamoEntidad> obtenerPrestamosPorClienteEstado(int idCliente, int estado) {

        ArrayList<PrestamoEntidad> lista = new ArrayList<PrestamoEntidad>();

        try {
            //preparamos la ejecucion del query
            s = con.createStatement();

            StringBuilder query = new StringBuilder();
            query.append("SELECT p.idPrestamo, idCliente, fechaInicio, fechaVencimiento, idPlazo, ");
            query.append("(select plazo from plazo as pl where p.idPlazo = pl.idPlazo) as 'PlazoPrestamo', ");
            query.append("cantPeriodo, p.idMoneda, plazoDias, montoOriginal, tasa, montoTasa, tasaCargos, montoCargos, montoTotal, ");
            query.append("cantidadCuotas, montoCuota, idFrecuenciaPago, ");
            query.append("(select plazo from plazo as pl where p.idFrecuenciaPago = pl.idPlazo) as 'FrecuenciaPago', ");
            query.append("cantFrecuencia, frecuenciaDias, ");
            query.append("montoPenalidad, diasPenalidad, estado,ep.nombre as 'descEstado', fechaCreacion, ");
            query.append("(select IFNULL(MAX(a.fecha),'No hay Pago') from abono as a where a.idPrestamo = p.idPrestamo)  as 'fechaUltimoPago', ");
            query.append("(select IFNULL(SUM(a.montoAbonado),0) from abono as a where a.idPrestamo = p.idPrestamo) as 'ultimoPago', ");
            query.append("(montoTotal - (select ifnull(sum(montoAbonado),0) from abono as a where a.idPrestamo = p.idPrestamo) ) as 'saldoActual', ");
            query.append("m.simbolo as 'SimboloMoneda', ");
            query.append("m.nombre as 'moneda' ");
            query.append("FROM prestamo as p  ");
            query.append("inner join estadoprestamo as ep on p.estado = ep.idEstado  ");
            query.append("inner join moneda as m on m.idMoneda = p.idMoneda  ");
            query.append("where idCliente = " + idCliente);
            if(estado!=0)
                query.append(" and estado = "+estado);
            query.append(" ;"); 
             

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
    
    public PrestamoEntidad obtenerPrestamosPorIdPrestamo(int idPrestamo) {

        PrestamoEntidad lista = null;

        try {
            //preparamos la ejecucion del query
            s = con.createStatement();

            StringBuilder query = new StringBuilder();
            query.append("SELECT p.idPrestamo, idCliente, fechaInicio, fechaVencimiento, idPlazo, ");
            query.append("(select plazo from plazo as pl where p.idPlazo = pl.idPlazo) as 'PlazoPrestamo', ");
            query.append("cantPeriodo, p.idMoneda, plazoDias, montoOriginal, tasa, montoTasa, tasaCargos, montoCargos, montoTotal, ");
            query.append("cantidadCuotas, montoCuota, idFrecuenciaPago, ");
            query.append("(select plazo from plazo as pl where p.idFrecuenciaPago = pl.idPlazo) as 'FrecuenciaPago', ");
            query.append("cantFrecuencia, frecuenciaDias, ");
            query.append("montoPenalidad, diasPenalidad, estado,ep.nombre as 'descEstado', fechaCreacion, ");
            query.append("(select IFNULL(MAX(a.fecha),'No hay Pago') from abono as a where a.idPrestamo = p.idPrestamo)  as 'fechaUltimoPago', ");
            query.append("(select IFNULL(SUM(a.montoAbonado),0) from abono as a where a.idPrestamo = p.idPrestamo) as 'ultimoPago', ");
            query.append("(montoTotal - (select ifnull(sum(montoAbonado),0) from abono as a where a.idPrestamo = p.idPrestamo) ) as 'saldoActual', ");
            query.append("m.simbolo as 'SimboloMoneda', ");
            query.append("m.nombre as 'moneda' ");
            query.append("FROM prestamo as p  ");
            query.append("inner join estadoprestamo as ep on p.estado = ep.idEstado  ");
            query.append("inner join moneda as m on m.idMoneda = p.idMoneda  ");
            query.append("where idPrestamo = " + idPrestamo);
           
            query.append(" ;"); 
             

            System.out.println(query.toString());
            rs = s.executeQuery(query.toString());

            //Recorremos cada registro agregandolo al ArrayList
            while (rs.next()) {
                lista = this.convertir(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }
    
    /**
     * Cambiamos el estado del prestamo
     * @param idPrestamo
     * @param estado
     * @return 
     */
    public boolean cambiarEstado(int idPrestamo, int estado) {
        //ProductoEntidad id = null;
        boolean exito = false;
        int id = 0;
        try {
            s = con.createStatement();
            StringBuilder query = new StringBuilder();

            query.append("UPDATE prestamo SET estado = "+estado+" WHERE idPrestamo = "+idPrestamo+"; ");
           
            
            System.out.println("QUERY: " + query.toString());

            exito = s.execute(query.toString());

            ResultSet rs = s.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }

            exito = true;

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            id = 0;
        }
        return exito;
    }
    
    private PrestamoEntidad convertir(ResultSet r) {
        PrestamoEntidad p = new PrestamoEntidad();
        try {
            p.setIdPrestamo(r.getInt("idPrestamo"));
            p.setIdCliente(r.getInt("idCliente"));
            p.setFechaInicio(MetodosGenerales.formatFecha(r.getDate("fechaInicio"),"dd/MM/yyyy"));
            p.setFechaVencimiento(MetodosGenerales.formatFecha(r.getDate("fechaVencimiento"),"dd/MM/yyyy"));
            p.setIdPlazo(r.getInt("idPlazo"));
            p.setCantPeriodo(r.getInt("cantPeriodo"));
            p.setIdMoneda(r.getInt("idMoneda"));
            p.setPlazoDias(r.getInt("plazoDias"));
            p.setMontoOriginal(r.getDouble("montoOriginal"));
            p.setTasa(r.getDouble("tasa"));
            p.setMontoTasa(r.getDouble("montoTasa"));
            p.setTasaCargo(r.getDouble("tasaCargos"));
            p.setMontoCargos(r.getDouble("montoCargos"));
            p.setMontoTotal(r.getDouble("montoTotal"));
            p.setCantidadCuotas(r.getInt("cantidadCuotas"));
            p.setMontoCuota(r.getDouble("montoCuota"));
            p.setIdFrecuenciaPago(r.getInt("idFrecuenciaPago"));
            p.setCantFrecuencia(r.getInt("cantFrecuencia"));
            p.setFrecuenciaDias(r.getInt("frecuenciaDias"));

            p.setMontoPenalidad(r.getDouble("montoPenalidad"));

            p.setDiasPenalidad(r.getInt("diasPenalidad"));
            p.setEstado(r.getInt("estado"));
            p.setDescEstado(r.getString("descEstado"));
            p.setFechaCreacion(r.getDate("fechaCreacion"));
            
            p.setSaldoActual(r.getDouble("saldoActual"));
            p.setFechaUltimoPago(r.getString("fechaUltimoPago"));
            p.setSimboloMoneda(r.getString("simboloMoneda"));
            p.setMoneda(r.getString("moneda"));
            p.setPlazoPrestamo(r.getString("plazoPrestamo"));
            p.setFrecueciaPago(r.getString("frecuenciaPago"));
            

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return p;
    }

}
