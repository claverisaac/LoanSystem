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
import loansystem.entidad.GraficoEntidad;
import loansystem.utilidades.MetodosGenerales;

/**
 *
 * @author cgarcia
 */
public class GraficoDAO {

    private Connection con;
    private ResultSet rs;
    private Statement s;

    public GraficoDAO(Connection con) {
        this.con = con;
    }

    /**
     *
     * @return
     */
    public ArrayList<GraficoEntidad> obtenerPrestamosPorMes() {

        ArrayList<GraficoEntidad> lista = new ArrayList<GraficoEntidad>();

        try {
            //preparamos la ejecucion del query
            s = con.createStatement();

            StringBuilder query = new StringBuilder();
            query.append("SELECT 'Prestamos Registrados' as Serie, DATE_FORMAT(fechaCreacion,'%M-%Y') as Valor_Eje, count(idPrestamo) as Valor ");
            query.append("FROM prestamo group by DATE_FORMAT(fechaCreacion,'%M-%Y') ORDER BY fechaCreacion DESC LIMIT 12; ");

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

    public ArrayList<GraficoEntidad> obtenerMontoPagoXMoneda() {

        ArrayList<GraficoEntidad> lista = new ArrayList<GraficoEntidad>();

        try {
            //preparamos la ejecucion del query
            s = con.createStatement();

            StringBuilder query = new StringBuilder();
            query.append("SELECT 'Monto Otorgado' as Serie, m.nombre as Valor_Eje, SUM(montoTotal) as Valor ");
            query.append("FROM prestamo as p inner join moneda as m ON m.idMoneda = p.idMoneda  ");
            query.append("group by m.nombre ");
            query.append("union all ");
            query.append("SELECT 'Pagos Recibidos' as Serie, m.nombre as Valor_Eje, SUM(a.montoAbonado) as Valor ");
            query.append("FROM prestamo as p inner join moneda as m ON m.idMoneda = p.idMoneda  ");
            query.append("left join abono as a on a.idPrestamo = p.idPrestamo ");
            query.append("group by m.nombre; ");

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

    
    public ArrayList<GraficoEntidad> obtenerPrestamosPorEstado() {

        ArrayList<GraficoEntidad> lista = new ArrayList<GraficoEntidad>();

        try {
            //preparamos la ejecucion del query
            s = con.createStatement();

            StringBuilder query = new StringBuilder();
            query.append("SELECT '' as Serie, ep.nombre as Valor_Eje, count(p.idPrestamo) as Valor ");
            query.append("FROM prestamo as p inner join estadoprestamo as ep on p.estado = ep.idEstado  ");
            query.append("group by ep.nombre order by ep.idEstado desc ");
           

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
     *
     * @param respuesta
     * @return
     */
    private GraficoEntidad convertir(ResultSet respuesta) {
        GraficoEntidad obj = new GraficoEntidad();
        try {

            obj.setSerie(respuesta.getString("Serie"));
            obj.setValorEje(respuesta.getString("Valor_Eje"));
            obj.setValor(respuesta.getDouble("Valor"));

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return obj;
    }
}
