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
import loansystem.entidad.AbonoEntidad;
import loansystem.utilidades.MetodosGenerales;

/**
 *
 * @author jechavarria
 */
public class AbonoDAO {

    private Connection con;
    private ResultSet rs;
    private Statement s;

    public AbonoDAO(Connection con) {
        this.con = con;
    }

    public int insertarPrestamo(AbonoEntidad obj) {
        //ProductoEntidad id = null;
        boolean exito = false;
        int id = 0;
        try {
            s = con.createStatement();
            StringBuilder query = new StringBuilder();

            query.append("INSERT INTO abono (idPrestamo, fecha, montoAbonado, nuevoSaldo) ");

            query.append("VALUES (" + obj.getIdPrestamo() + ", '" + obj.getFecha() + "', " + obj.getMontoAbonado() + ", " + obj.getNuevoSaldo() + ")");

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

    /**
     * 
     * @param idPrestamo
     * @return 
     */
    public ArrayList<AbonoEntidad> obtenerPrestamosPorCliente(int idPrestamo) {

        ArrayList<AbonoEntidad> lista = new ArrayList<AbonoEntidad>();

        try {
            //preparamos la ejecucion del query
            s = con.createStatement();

            StringBuilder query = new StringBuilder();
            query.append("select idAbono, idPrestamo, fecha, montoAbonado, nuevoSaldo from abono ");
            query.append("where idPrestamo = " + idPrestamo + ";");

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

    private AbonoEntidad convertir(ResultSet respuesta) {
        AbonoEntidad obj = new AbonoEntidad();
        try {

            obj.setIdAbono(respuesta.getInt("idAbono"));
            obj.setIdPrestamo(respuesta.getInt("idPrestamo"));
            obj.setFecha(MetodosGenerales.formatFecha(respuesta.getDate("fecha"), "dd/MM/yyyy") );
            obj.setMontoAbonado(Double.parseDouble(respuesta.getString("montoAbonado")));
            obj.setNuevoSaldo(Double.parseDouble(respuesta.getString("nuevoSaldo")));

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return obj;
    }

}
