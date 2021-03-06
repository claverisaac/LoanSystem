/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loansystem.utilidades;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import loansystem.visual.panel.Prestamo;
import org.jdesktop.swingx.JXDatePicker;

/**
 *
 * @author jechavarria
 */
public class MetodosGenerales {

    public String ObtenerPrimeraPalabra(String cadena) {
        String palabra = "";
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.substring(i) == "") {
                palabra = cadena.substring(0, i);
                break;
            } else {
                palabra = cadena;
            }

        }
        System.out.println("la palabra es: " + palabra);
        return palabra;
    }

    public void borrarFilasTabla(JTable tabla) {

        int fila = tabla.getSelectedRow();
        if(fila>=1){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.removeRow(fila);
        //System.out.println("Se elimno la fila " + fila);
        }}

    //validar texfield solo numerico
    public void soloNumeroSinPoint(final JTextField txt) {
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c)
                        || (c == KeyEvent.VK_BACK_SPACE)
                        || (c == KeyEvent.VK_DELETE)
                        || (c == KeyEvent.VK_ENTER))) {
//getToolkit().beep();
                    txt.setText("");
                    e.consume();
                }
            }
        });
    }
    
//validar texfield solo numerico
    public void soloNumero(final JTextField txt) {
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c)
                        || (c == KeyEvent.VK_BACK_SPACE)
                        || (c == KeyEvent.VK_DELETE)
                        || (c == KeyEvent.VK_PERIOD)
                        || (c == KeyEvent.VK_ENTER))) {
//getToolkit().beep();
                    txt.setText("");
                    e.consume();
                }
            }
        });
    }

    //Obtener fecha actual en formato deseado
    //ejemplo: formato = "dd-MM-yyyy"
    public String cargarFechActual() {
        String fec_actual, dia, mes, anio;
        Date fecha = new Date();
        //  SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd-MM-yyyy");
        //formatoDeFecha.format(fecha);
        //System.out.println(fecha);
        dia = String.valueOf(fecha.getDate());
        mes = String.valueOf(fecha.getMonth() + 1);
        anio = String.valueOf(fecha.getYear() + 1900);
        fec_actual = dia + "-" + mes + "-" + anio;
        return fec_actual;
    }
    
    public String getFechaString(Date date){
    String dia, mes, anio, fecha="";
    dia = String.valueOf(date.getDate());
    mes = String.valueOf(date.getMonth()+1);
    anio = String.valueOf(date.getYear()+1900);
        
    fecha=anio.concat("-").concat(mes).concat("-").concat(dia);
    
    return fecha;
    }
    
    /**
     * 
     * @param fecha
     * @param formatoAnt
     * @return 
     */
    public Date formatearFecha(String fecha, String formatoAnt)
    {
        Date fechaRetorno = null;
        
        SimpleDateFormat formato = new SimpleDateFormat(formatoAnt);
        
        try {
            fechaRetorno = formato.parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(Prestamo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return fechaRetorno;        
    }
            
            
    

    public void limpiarTabla(JTable tabla) {

        try {
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            int filas = tabla.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            //  JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }

    public void agregarFila(JTable tabla) {
        Object rowData[] = null;
        try {
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.addRow(rowData);

        } catch (Exception e) {
            //  JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }

    }

    public void limpiarJList(JList lista) {

        DefaultListModel modelo = new DefaultListModel();
        lista = new JList(modelo);
        modelo.removeAllElements();
    }
    
    /**
     * Retorna un String a partir de un Date, dandole el formato indicado.
     * @param fecha
     * @param formato
     * @return 
     */
    public static String formatFecha(Date fecha, String formato){
        String fechaS = "";
        
         SimpleDateFormat format = new SimpleDateFormat(formato);
         fechaS = format.format(fecha);
         
        return fechaS;
    }
    
    /**
     *
     * @param value
     * @param places
     * @return
     */
    public double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
    
     /**
     *
     * @param id
     * @param espacios
     * @return
     */
    public String completarCerosID(int id, int espacios) {
        String idStr = String.valueOf(id);
        String nuevoId = "";
        StringBuilder aux = new StringBuilder();

        if (idStr.length() < espacios) {
            for (int i = 0; i < espacios - idStr.length(); i++) {
                aux.append("0");
            }

            aux.append(idStr);
            nuevoId = aux.toString();

        } else {
            nuevoId = String.valueOf(id);
        }

        return nuevoId;
    }
    
    
    /**
     *
     * @param monto
     * @param moneda
     * @return
     */
    public String formatearMoneda(double monto, String moneda) {
        StringBuilder dinero = new StringBuilder();
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        String formateado = formatter.format(monto);

        dinero.append(moneda); 
        dinero.append(" ");
        dinero.append(formateado);
        return dinero.toString();
    }
    
    
    /**
     *
     * @param picker
     */
    public void formatoDatePicker(JXDatePicker picker) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        picker.setFormats(format);
    }

}
