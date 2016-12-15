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

/**
 *
 * @author JChavarria
 */
public class ClienteDAO {

    private Connection con;
    private Statement s;
    private ResultSet rs;

    public ClienteDAO(Connection con) {
        this.con = con;
    }

    /**
     * ** Lista todos los clientes
     *
     * @param
     * @return toda informacion del cliente
     */
    public ArrayList<ClienteEntidad> obtenerTodosClientes() {
        ArrayList<ClienteEntidad> lista = new ArrayList<ClienteEntidad>();
        try {
            s = con.createStatement();
            System.out.println("SELECT idCliente, nombres, apellidos, numCedula, sexo, idMunicipio, "
                    + "direccionPrincipal, direccionSecundaria, limiteCredito, diasCredito,\n"
                    + "telefonoCasa, telefonoMovil, telefonoVario_uno, telefonoVario_dos, idRutaVisita, "
                    + "centroLaboral,"
                    + " telefonoLaboral, fechaAlta, idEmpresa \n"
                    + "FROM loan_system.cliente;");

            rs = s.executeQuery("SELECT idCliente, nombres, apellidos, numCedula, sexo, idMunicipio, "
                    + "direccionPrincipal, direccionSecundaria, limiteCredito, diasCredito,\n"
                    + "telefonoCasa, telefonoMovil, telefonoVario_uno, telefonoVario_dos, idRutaVisita, "
                    + "centroLaboral,"
                    + " telefonoLaboral, fechaAlta, idEmpresa \n"
                    + "FROM loan_system.cliente;");

            while (rs.next()) {
                lista.add(this.convertir(rs));
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }
 /**
     * ** Lista clientes por id
     *
     * @param idcliente
     * @return toda informacion del cliente
     */
    public ClienteEntidad obtenerCliente(int idCliente) {
        ClienteEntidad lista = null;
        try {
            s = con.createStatement();
            System.out.println("SELECT idCliente, nombres, apellidos, numCedula, sexo, idMunicipio, "
                    + "direccionPrincipal, direccionSecundaria, limiteCredito, diasCredito,\n"
                    + "telefonoCasa, telefonoMovil, telefonoVario_uno, telefonoVario_dos, idRutaVisita, "
                    + "centroLaboral,"
                    + " telefonoLaboral, fechaAlta, idEmpresa \n"
                    + "FROM loan_system.cliente\n"
                    + "WHERE idCliente =" + idCliente + ";");

            rs = s.executeQuery("SELECT idCliente, nombres, apellidos, numCedula, sexo, idMunicipio, "
                    + "direccionPrincipal, direccionSecundaria, limiteCredito, diasCredito,\n"
                    + "telefonoCasa, telefonoMovil, telefonoVario_uno, telefonoVario_dos, idRutaVisita, "
                    + "centroLaboral,"
                    + " telefonoLaboral, fechaAlta, idEmpresa \n"
                    + "FROM loan_system.cliente\n"
                    + "WHERE idCliente =" + idCliente + ";");

            while (rs.next()) {
                lista=this.convertir(rs);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    /**
     * ** Lista clientes por id
     *
     * @param idcliente
     * @return toda informacion del cliente
     */
    public ArrayList<ClienteEntidad> obtenerXCliente(int idCliente) {
        ArrayList<ClienteEntidad> lista = new ArrayList<ClienteEntidad>();
        try {
            s = con.createStatement();
            System.out.println("SELECT idCliente, nombres, apellidos, numCedula, sexo, idMunicipio, "
                    + "direccionPrincipal, direccionSecundaria, limiteCredito, diasCredito,\n"
                    + "telefonoCasa, telefonoMovil, telefonoVario_uno, telefonoVario_dos, idRutaVisita, "
                    + "centroLaboral,"
                    + " telefonoLaboral, fechaAlta, idEmpresa \n"
                    + "FROM loan_system.cliente\n"
                    + "WHERE idCliente =" + idCliente + ";");

            rs = s.executeQuery("SELECT idCliente, nombres, apellidos, numCedula, sexo, idMunicipio, "
                    + "direccionPrincipal, direccionSecundaria, limiteCredito, diasCredito,\n"
                    + "telefonoCasa, telefonoMovil, telefonoVario_uno, telefonoVario_dos, idRutaVisita, "
                    + "centroLaboral,"
                    + " telefonoLaboral, fechaAlta, idEmpresa \n"
                    + "FROM loan_system.cliente\n"
                    + "WHERE idCliente =" + idCliente + ";");

            while (rs.next()) {
                lista.add(this.convertir(rs));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    /**
     * ** Lista clientes por cedula
     *
     * @param cedula
     * @return toda informacion del cliente
     */
    public ArrayList<ClienteEntidad> obtenerXCliente(String cedula) {
        ArrayList<ClienteEntidad> lista = new ArrayList<ClienteEntidad>();
        try {
            s = con.createStatement();
            System.out.println("SELECT idCliente, nombres, apellidos, numCedula, sexo, idMunicipio, "
                    + "direccionPrincipal, direccionSecundaria, limiteCredito, diasCredito,\n"
                    + "telefonoCasa, telefonoMovil, telefonoVario_uno, telefonoVario_dos, idRutaVisita, "
                    + "centroLaboral,"
                    + " telefonoLaboral, fechaAlta, idEmpresa \n"
                    + "FROM loan_system.cliente\n"
                    + "WHERE numCedula ='" + cedula + "';");

            rs = s.executeQuery("SELECT idCliente, nombres, apellidos, numCedula, sexo, idMunicipio, "
                    + "direccionPrincipal, direccionSecundaria, limiteCredito, diasCredito,\n"
                    + "telefonoCasa, telefonoMovil, telefonoVario_uno, telefonoVario_dos, idRutaVisita, "
                    + "centroLaboral,"
                    + " telefonoLaboral, fechaAlta, idEmpresa \n"
                    + "FROM loan_system.cliente\n"
                    + "WHERE numCedula ='" + cedula + "';");

            while (rs.next()) {
                lista.add(this.convertir(rs));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    /**
     * ** Lista clientes por nombre
     *
     * @param nombres
     * @return toda informacion del cliente
     */
    public ArrayList<ClienteEntidad> obtenereClientesNombre(String nom) {

        ArrayList<ClienteEntidad> lista = new ArrayList<ClienteEntidad>();

        try {
            //preparamos la ejecucion del query
            s = con.createStatement();
            //Ejecutamos el Query
            rs = s.executeQuery("SELECT idCliente, nombres, apellidos, numCedula, sexo, idMunicipio, direccionPrincipal, direccionSecundaria, limiteCredito, diasCredito,\n"
                    + "telefonoCasa, telefonoMovil, telefonoVario_uno, telefonoVario_dos, idRutaVisita, centroLaboral, telefonoLaboral, fechaAlta, idEmpresa \n"
                    + "FROM loan_system.cliente\n"
                    + "WHERE nombres like '%" + nom + "%' or apellidos like '%" + nom + "%';");

            //   System.out.println("SELECT id_categoria, nombre_categoria,descripcion FROM producto_categoria;");
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
     * ** Lista clientes por nombre
     *
     * @param nombres
     * @return toda informacion del cliente
     */
    public ArrayList<ClienteEntidad> obtenereClientesNombreIDCed(String nom, String cedula, int id) {

        ArrayList<ClienteEntidad> lista = new ArrayList<ClienteEntidad>();

        try {
            //preparamos la ejecucion del query
            s = con.createStatement();
            //Ejecutamos el Query
            System.out.println("SELECT idCliente, nombres, apellidos, numCedula, sexo, idMunicipio, direccionPrincipal, direccionSecundaria, limiteCredito, diasCredito,\n"
                    + "telefonoCasa, telefonoMovil, telefonoVario_uno, telefonoVario_dos, idRutaVisita, centroLaboral, telefonoLaboral, fechaAlta, idEmpresa \n"
                    + "FROM loan_system.cliente\n"
                    + "WHERE nombres like '%" + nom + "%' or apellidos like '%" + nom + "%' or numCedula ='" + cedula + "' or idCliente =" + id+ ";");
            
            rs = s.executeQuery("SELECT idCliente, nombres, apellidos, numCedula, sexo, idMunicipio, direccionPrincipal, direccionSecundaria, limiteCredito, diasCredito,\n"
                    + "telefonoCasa, telefonoMovil, telefonoVario_uno, telefonoVario_dos, idRutaVisita, centroLaboral, telefonoLaboral, fechaAlta, idEmpresa \n"
                    + "FROM loan_system.cliente\n"
                    + "WHERE nombres like '%" + nom + "%' or apellidos like '%" + nom + "%' or numCedula ='" + cedula + "' or idCliente =" + id+ ";");

            //   System.out.println("SELECT id_categoria, nombre_categoria,descripcion FROM producto_categoria;");
            //Recorremos cada registro agregandolo al ArrayList
            while (rs.next()) {
                lista.add(this.convertir(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public boolean insertarCliente(ClienteEntidad obj) {
        //ProductoEntidad id = null;
        boolean exito = false;
        try {
            s = con.createStatement();
            /*  System.out.println("INSERT INTO distribution.productos_catalogo (nombre_producto,descripcion," +
                    "precio,costo,fecha_vencimiento,presentacion,estado,conversion,id_categoria,"
                    + "unid_medida_mayor,unid_medida_menor) VALUES ('"+obj.getNombre()+"','"+obj.getDescripcion()+"'"
                    + ","+obj.getPrecio()+","+obj.getCosto()+",'"+obj.getFecha_venc()+"','"+obj.getPresentacion()+"',"+obj.isActivo()+","
                    +obj.getConversion()+","+obj.getId_categoria()+","+obj.getId_unidad_mayor()+","+obj.getId_unidad_menor()+");"); */

           /* exito = s.execute("INSERT INTO loan_system.cliente(\n"
                    + "   idCliente\n"
                    + "  ,nombres\n"
                    + "  ,apellidos\n"
                    + "  ,numCedula\n"
                    + "  ,sexo\n"
                    + "  ,idMunicipio\n"
                    + "  ,direccionPrincipal\n"
                    + "  ,direccionSecundaria\n"
                    + "  ,limiteCredito\n"
                    + "  ,diasCredito\n"
                    + "  ,telefonoCasa\n"
                    + "  ,telefonoMovil\n"
                    + "  ,telefonoVario_uno\n"
                    + "  ,telefonoVario_dos\n"
                    + "  ,idRutaVisita\n"
                    + "  ,centroLaboral\n"
                    + "  ,telefonoLaboral\n"
                    + "  ,fechaAlta\n"
                    + "  ,idEmpresa\n"
                    + ") VALUES ("
                    + "   NULL, '"
                    + obj.getNombres() + "','"
                    + obj.getApellidos() + "','"
                    + obj.getNumCedula() + "','"
                    + obj.getSexo() + "',"
                    + obj.getIdMunicipio() + ",'"
                    + obj.getDireccionPrincipal() + "','"
                    + obj.getDireccionSecundaria() + "',"
                    + obj.getLimiteCredito() + ", null,'"
                    + obj.getTelefonoCasa() + "','"
                    + obj.getTelefonoMovil() + "','"
                    + obj.getTelefonoVario_uno() + "','"
                    + obj.getTelefonoVario_dos()) + "',"
                    + obj.getIdRutaVisita() + ",'"
                    + obj.getCentroLaboral() + "','"
                    + obj.getTelefonoLaboral() + "','"
                    + obj.getFechaAlta() + "'," 
                    + obj.getIdEmpresa() + ");");*/

            exito = true;

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exito;
    }

    /* ACTUALIZAR CLEINTE
     */
    public boolean updateCliente(ClienteEntidad obj, int id) {
        //ProductoEntidad id = null;
        boolean exito = false;
        try {
            s = con.createStatement();
            System.out.println("");

          /*  exito = s.execute("UPDATE clientes set nombre_cliente = '" + obj.getNombre_cliente() + "', nombre_negocio = '" + obj.getNombre_negocio() + "', "
                    + "telefono= '" + obj.getTelefono() + "'," + "ubicacion ='" + obj.getUbicacion() + "' , ubicacion2 ='" + obj.getUbicacion2()
                    + "' , id_tipo_cliente=" + obj.getId_tipo_cliente() + " , id_departamento=" + obj.getId_departamento() + ","
                    + "id_municipio=" + obj.getId_municipio() + ",barrio='" + obj.getBarrio() + "',id_ruta_entrega=" + obj.getId_ruta_entrega() + ","
                    + "id_ruta_preventa=" + obj.getId_ruta_preventa() + ", credito =" + obj.getCredito() + ",limite_credito = " + obj.getLimite_credito() + ",\n"
                    + "dias_credito=" + obj.getDias_credito() + ", secuencia=" + obj.getSecuencia() + ", frecuencia =" + obj.getFrecuencia() + " , estado=" + obj.getEstado() + " "
                    + "where id_cliente= " + id + ";");*/

            exito = true;

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exito;
    }

    private ClienteEntidad convertir(ResultSet respuesta) {
        ClienteEntidad obj = new ClienteEntidad();
        try {

            obj.setIdCliente(respuesta.getInt("idCliente"));
            obj.setApellidos(respuesta.getString("apellidos"));
            obj.setNombres(respuesta.getString("nombres"));
            obj.setIdEmpresa(respuesta.getInt("idEmpresa"));
            obj.setFechaAlta(respuesta.getString("fechaAlta"));
            obj.setNumCedula(respuesta.getString("numCedula"));
            obj.setSexo(respuesta.getString("sexo"));
            obj.setCentroLaboral(respuesta.getString("centroLaboral"));
            obj.setDiasCredito(respuesta.getInt("diasCredito"));
            obj.setDireccionPrincipal(respuesta.getString("direccionPrincipal"));
            obj.setDireccionSecundaria(respuesta.getString("direccionSecundaria"));
            obj.setIdMunicipio(respuesta.getInt("idMunicipio"));
            obj.setIdRutaVisita(respuesta.getInt("idRutaVisita"));
            obj.setLimiteCredito(respuesta.getDouble("limiteCredito"));
            obj.setTelefonoCasa(respuesta.getString("telefonoCasa"));
            obj.setTelefonoLaboral(respuesta.getString("telefonoLaboral"));
            obj.setTelefonoMovil(respuesta.getString("telefonoMovil"));
            obj.setTelefonoVario_dos(respuesta.getString("telefonoVario_dos"));
            obj.setTelefonoVario_uno(respuesta.getString("telefonoVario_uno"));

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return obj;
    }

}
