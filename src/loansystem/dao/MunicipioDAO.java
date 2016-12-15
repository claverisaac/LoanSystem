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
import loansystem.entidad.ClienteEntidad;
import loansystem.entidad.MunicipioEntidad;
import loansystem.entidad.UsuarioEntidad;

/**
 *
 * @author jechavarria
 */
public class MunicipioDAO {

    private Connection con;
    private Statement s;
    private ResultSet rs;

    public MunicipioDAO(Connection con) {
        this.con = con;

    }

    /**
     * *
     * Lista a un usuario dependiendo de su usuario y contraseña
     *
     * @param nombre_usuario
     * @param pass
     * @return toda informacion del usuario
     */
    public ArrayList<MunicipioEntidad> obtenerTodosxDepto(String depto) {
        ArrayList<MunicipioEntidad> lista = new ArrayList<MunicipioEntidad>();
        try {
            s = con.createStatement();
            rs = s.executeQuery("SELECT idMunicipio, Departamento, Municipio from Municipio where Departamento = '" + depto + "';");

            while (rs.next()) {
                lista.add(this.convertir(rs));
            }

        } catch (SQLException ex) {
            Logger.getLogger(MunicipioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }
    
    public MunicipioEntidad obtenerMunicipioXNombre(String municipio) {
        MunicipioEntidad lista = null;
        try {
            s = con.createStatement();
            rs = s.executeQuery("SELECT idMunicipio, Departamento, [Municipio] from Municipio where [Municipio] = '"+municipio+"';");

            while (rs.next()) {
                lista = this.convertir(rs);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MunicipioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }
    
    public MunicipioEntidad obtenerMunicipioXId(int idMunicipio) {
        MunicipioEntidad lista = null;
        try {
            s = con.createStatement();
            rs = s.executeQuery("SELECT idMunicipio, Departamento, Municipio from Municipio where idMunicipio = "+idMunicipio+";");

            while (rs.next()) {
                lista = this.convertir(rs);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MunicipioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    private MunicipioEntidad convertir(ResultSet respuesta) {
        MunicipioEntidad obj = new MunicipioEntidad();
        try {

            obj.setIdMunicipio(respuesta.getInt("idMunicipio"));
            obj.setDepartamento(respuesta.getString("Departamento"));
            obj.setMunicipio(respuesta.getString("Municipio"));

        } catch (SQLException ex) {
            Logger.getLogger(MunicipioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return obj;
    }
}
