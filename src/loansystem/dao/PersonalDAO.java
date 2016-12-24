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

    public ArrayList<PersonalEntidad> obtenerTodosPersonas() {
        ArrayList<PersonalEntidad> lista = new ArrayList<PersonalEntidad>();
        try {
            s = con.createStatement();
            System.out.println("SELECT idPersona,\n"
                    + "    nombres,\n"
                    + "    apellidos,\n"
                    + "    numCedula,\n"
                    + "    sexo,\n"
                    + "    idCargo,\n"
                    + "    fechaRegistro,\n"
                    + "    idEmpresa\n"
                    + "FROM personal;");

            rs = s.executeQuery("SELECT idPersona,\n"
                    + "    nombres,\n"
                    + "    apellidos,\n"
                    + "    numCedula,\n"
                    + "    sexo,\n"
                    + "    idCargo,\n"
                    + "    fechaRegistro,\n"
                    + "    idEmpresa\n"
                    + "FROM personal;");

            while (rs.next()) {
                lista.add(this.convertir(rs));

            }

        } catch (SQLException ex) {
            Logger.getLogger(PersonalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public ArrayList<PersonalEntidad> obtenerePersonalNombreIDCed(String nom, String cedula, int id) {

        ArrayList<PersonalEntidad> lista = new ArrayList<PersonalEntidad>();

        try {
            //preparamos la ejecucion del query
            s = con.createStatement();
            //Ejecutamos el Query
            System.out.println("SELECT idPersona,\n"
                    + "    nombres,\n"
                    + "    apellidos,\n"
                    + "    numCedula,\n"
                    + "    sexo,\n"
                    + "    idCargo,\n"
                    + "    fechaRegistro,\n"
                    + "    idEmpresa\n"
                    + "FROM personal\n"
                    + "WHERE nombres like '%" + nom + "%' or apellidos like '%" + nom + "%' or numCedula ='" + cedula + "' or idPersona =" + id + ";");

            rs = s.executeQuery("SELECT idPersona,\n"
                    + "    nombres,\n"
                    + "    apellidos,\n"
                    + "    numCedula,\n"
                    + "    sexo,\n"
                    + "    idCargo,\n"
                    + "    fechaRegistro,\n"
                    + "    idEmpresa\n"
                    + "FROM personal\n"
                    + "WHERE nombres like '%" + nom + "%' or apellidos like '%" + nom + "%' or numCedula ='" + cedula + "' or idPersona =" + id + ";");

            //   System.out.println("SELECT id_categoria, nombre_categoria,descripcion FROM producto_categoria;");
            //Recorremos cada registro agregandolo al ArrayList
            while (rs.next()) {
                lista.add(this.convertir(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public ArrayList<PersonalEntidad> obtenerClientesNombre(String nom) {
        ArrayList<PersonalEntidad> lista = new ArrayList<PersonalEntidad>();
        try {
            //preparamos la ejecucion del query
            s = con.createStatement();
            //Ejecutamos el Query
            rs = s.executeQuery("SELECT idPersona,\n"
                    + "    nombres,\n"
                    + "    apellidos,\n"
                    + "    numCedula,\n"
                    + "    sexo,\n"
                    + "    idCargo,\n"
                    + "    fechaRegistro,\n"
                    + "    idEmpresa\n"
                    + "FROM personal\n"
                    + "WHERE nombres like '%" + nom + "%' or apellidos like '%" + nom + "%';");

            //   System.out.println("SELECT id_categoria, nombre_categoria,descripcion FROM producto_categoria;");
            //Recorremos cada registro agregandolo al ArrayList
            while (rs.next()) {
                lista.add(this.convertir(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public PersonalEntidad obtenerPersonal(int idPersona) {
        PersonalEntidad lista = null;
        try {
            s = con.createStatement();
            System.out.println("SELECT idPersona,\n"
                    + "    nombres,\n"
                    + "    apellidos,\n"
                    + "    numCedula,\n"
                    + "    sexo,\n"
                    + "    idCargo,\n"
                    + "    fechaRegistro,\n"
                    + "    idEmpresa\n"
                    + "FROM personal\n"
                    + "WHERE idPersona =" + idPersona + ";");

            rs = s.executeQuery("SELECT idPersona,\n"
                    + "    nombres,\n"
                    + "    apellidos,\n"
                    + "    numCedula,\n"
                    + "    sexo,\n"
                    + "    idCargo,\n"
                    + "    fechaRegistro,\n"
                    + "    idEmpresa\n"
                    + "FROM personal\n"
                    + "WHERE idPersona =" + idPersona + ";");

            while (rs.next()) {
                lista = this.convertir(rs);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PersonalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public ArrayList<PersonalEntidad> obtenerXidPersona(int idPersona) {
        ArrayList<PersonalEntidad> lista = new ArrayList<PersonalEntidad>();
        try {
            s = con.createStatement();
            System.out.println("SELECT idPersona,\n"
                    + "    nombres,\n"
                    + "    apellidos,\n"
                    + "    numCedula,\n"
                    + "    sexo,\n"
                    + "    idCargo,\n"
                    + "    fechaRegistro,\n"
                    + "    idEmpresa\n"
                    + "FROM personal\n"
                    + "WHERE idPersona =" + idPersona + ";");

            rs = s.executeQuery("SELECT idPersona,\n"
                    + "    nombres,\n"
                    + "    apellidos,\n"
                    + "    numCedula,\n"
                    + "    sexo,\n"
                    + "    idCargo,\n"
                    + "    fechaRegistro,\n"
                    + "    idEmpresa\n"
                    + "FROM personal\n"
                    + "WHERE idPersona =" + idPersona + ";");

            while (rs.next()) {
                lista.add(this.convertir(rs));
            }

        } catch (SQLException ex) {
            Logger.getLogger(PersonalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public ArrayList<PersonalEntidad> obtenerClienteCed(String cedula) {
        ArrayList<PersonalEntidad> lista = new ArrayList<PersonalEntidad>();
        try {
            s = con.createStatement();
            System.out.println("SELECT idPersona,\n"
                    + "    nombres,\n"
                    + "    apellidos,\n"
                    + "    numCedula,\n"
                    + "    sexo,\n"
                    + "    idCargo,\n"
                    + "    fechaRegistro,\n"
                    + "    idEmpresa\n"
                    + "FROM personal\n"
                    + "WHERE numCedula ='" + cedula + "';");

            rs = s.executeQuery("SELECT idPersona,\n"
                    + "    nombres,\n"
                    + "    apellidos,\n"
                    + "    numCedula,\n"
                    + "    sexo,\n"
                    + "    idCargo,\n"
                    + "    fechaRegistro,\n"
                    + "    idEmpresa\n"
                    + "FROM personal\n"
                    + "WHERE numCedula ='" + cedula + "';");

            while (rs.next()) {
                lista.add(this.convertir(rs));
            }

        } catch (SQLException ex) {
            Logger.getLogger(PersonalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    /**
     * ** Lista a una persona dependiendo de su idPersona
     *
     * @param idPersona
     * @return toda informacion de la persona
     */
    public PersonalEntidad obtenerXPersona(int idPersona) {
        PersonalEntidad perEntidad = null;
        try {
            s = con.createStatement();
            System.out.println("SELECT idPersona,\n"
                    + "    nombres,\n"
                    + "    apellidos,\n"
                    + "    numCedula,\n"
                    + "    sexo,\n"
                    + "    idCargo,\n"
                    + "    fechaRegistro,\n"
                    + "    idEmpresa\n"
                    + "FROM personal\n"
                    + "WHERE idPersona = " + idPersona + ";");

            rs = s.executeQuery("SELECT idPersona,\n"
                    + "    nombres,\n"
                    + "    apellidos,\n"
                    + "    numCedula,\n"
                    + "    sexo,\n"
                    + "    idCargo,\n"
                    + "    fechaRegistro,\n"
                    + "    idEmpresa\n"
                    + "FROM personal\n"
                    + "WHERE idPersona = " + idPersona + ";");

            while (rs.next()) {
                perEntidad = this.convertir(rs);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PersonalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return perEntidad;
    }

    /**
     * ** Lista clientes por cedula
     *
     * @param cedula
     * @return toda informacion del cliente
     */
    public ArrayList<PersonalEntidad> obtenerXPersona(String nombre) {
        ArrayList<PersonalEntidad> lista = new ArrayList<PersonalEntidad>();
        try {
            s = con.createStatement();
            System.out.println("SELECT idPersona,\n"
                    + "    nombres,\n"
                    + "    apellidos,\n"
                    + "    numCedula,\n"
                    + "    sexo,\n"
                    + "    idCargo,\n"
                    + "    fechaRegistro,\n"
                    + "    idEmpresa\n"
                    + "FROM personal\n"
                    + "WHERE nombres like '%" + nombre + "%' or apellidos like '%" + nombre + "%' ;");

            rs = s.executeQuery("SELECT idPersona,\n"
                    + "    nombres,\n"
                    + "    apellidos,\n"
                    + "    numCedula,\n"
                    + "    sexo,\n"
                    + "    idCargo,\n"
                    + "    fechaRegistro,\n"
                    + "    idEmpresa\n"
                    + "FROM personal\n"
                    + "WHERE nombres like '%" + nombre + "%' or apellidos like '%" + nombre + "%' ;");

            while (rs.next()) {
                lista.add(this.convertir(rs));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public int insertarPersonal(PersonalEntidad obj) {
        //ProductoEntidad id = null;
        boolean exito = false;
        int id = 0;
        try {
            s = con.createStatement();
            StringBuilder query = new StringBuilder();

            query.append("INSERT INTO loan_system.personal(\n"
                    + "  nombres\n"
                    + "  ,apellidos\n"
                    + "  ,numCedula\n"
                    + "  ,sexo\n"
                    + "  ,idCargo\n"
                    + "  ,fechaRegistro\n"
                    + "  ,idEmpresa\n"
                    + ") VALUES ('"
                    + obj.getNombres() + "','"
                    + obj.getApellidos() + "','"
                    + obj.getNumCedula() + "','"
                    + obj.getSexo() + "',"
                    + obj.getIdCargo() + ","
                    + "current_timestamp(),"
                    + obj.getIdEmpresa() + ");");

            System.out.println("QUERY: " + query.toString());

            exito = s.execute(query.toString());

            ResultSet rs = s.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }

            exito = true;

        } catch (SQLException ex) {
            Logger.getLogger(PersonalDAO.class.getName()).log(Level.SEVERE, null, ex);
            id = 0;
        }
        return id;
    }

    /* ACTUALIZAR PERSONAL
     */
    public boolean updatePersonal(PersonalEntidad obj, int id) {
        //ProductoEntidad id = null;
        boolean exito = false;
        try {
            s = con.createStatement();
            System.out.println("");

            System.out.println("UPDATE loan_system.personal SET nombres = '" + obj.getNombres() + "' ,"
                    + "apellidos = '" + obj.getApellidos() + "' ,numCedula = '" + obj.getNumCedula() + "',"
                    + "sexo = '" + obj.getSexo() + "',idCargo = " + obj.getIdCargo() + " WHERE idPersona = " + id + ";");

            exito = s.execute("UPDATE loan_system.personal SET nombres = '" + obj.getNombres() + "' ,"
                    + "apellidos = '" + obj.getApellidos() + "' ,numCedula = '" + obj.getNumCedula() + "',"
                    + "sexo = '" + obj.getSexo() + "',idCargo = " + obj.getIdCargo() + " WHERE idPersona = " + id + ";");

            exito = true;

        } catch (SQLException ex) {
            Logger.getLogger(PersonalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exito;
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

    /**
     * ** Login propuesto
     *
     * @param idPersona
     * @return Login de usuario
     */
    public PersonalEntidad obtenerLoginPropuesto(int idPersona) {
        PersonalEntidad perEntidad = null;
        try {
            s = con.createStatement();
            System.out.println("select concat(substring(nombres, 1,1),left(apellidos,locate(\" \",apellidos))) as login from personal\n"
                    + "where idPersona = " + idPersona + ";");

            rs = s.executeQuery("select concat(substring(nombres, 1,1),left(apellidos,locate(\" \",apellidos))) as login from personal\n"
                    + "where idPersona = " + idPersona + ";");

            while (rs.next()) {
                perEntidad = this.convertirLogin(rs);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PersonalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return perEntidad;
    }

    private PersonalEntidad convertirLogin(ResultSet respuesta) {
        PersonalEntidad obj = new PersonalEntidad();
        try {

            obj.setLogin(respuesta.getString("login"));

        } catch (SQLException ex) {
            Logger.getLogger(PersonalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return obj;
    }
}
