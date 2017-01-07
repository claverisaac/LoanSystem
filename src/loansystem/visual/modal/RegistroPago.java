/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loansystem.visual.modal;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import loansystem.Principal;
import loansystem.bd.Conexion;
import loansystem.dao.AbonoDAO;
import loansystem.dao.CuotasDAO;
import loansystem.dao.PrestamoDAO;
import loansystem.entidad.AbonoEntidad;
import loansystem.entidad.ClienteEntidad;
import loansystem.entidad.CuotasEntidad;
import loansystem.entidad.PrestamoEntidad;
import loansystem.utilidades.MetodosGenerales;
import loansystem.visual.panel.Prestamo;

/**
 *
 * @author cgarcia
 */
public class RegistroPago extends javax.swing.JDialog {

    private Conexion con;
    private Principal prin;
    private Prestamo pres;
    private MetodosGenerales util;
    private PrestamoEntidad p = null;
    private ClienteEntidad cliente = null;

    /**
     * Creates new form RegistroPago
     */
    public RegistroPago(Principal prin, boolean modal, Conexion con, Prestamo pres) {
        super(prin, modal);
        this.prin = prin;
        this.con = con;
        this.pres = pres;

        util = new MetodosGenerales();

        this.p = pres.getPrestamo();
        this.cliente = pres.getCliente();

        initComponents();

        util.formatoDatePicker(this.dtFechaPago);
        cargarDatosGenerales();

        util.soloNumero(txtAbono);
        cargarAbonos();
    }

    private void cargarDatosGenerales() {
        this.txtNombres.setText(cliente.getNombres() + " " + cliente.getApellidos());
        this.txtMontoOriginal.setText(p.getSimboloMoneda() + " " + String.valueOf(p.getMontoTotal()));
        this.txtCuota.setText(p.getSimboloMoneda() + " " + String.valueOf(p.getMontoCuota()));
        this.txtSaldo.setText(p.getSimboloMoneda() + " " + String.valueOf(p.getSaldoActual()));
        this.txtNuevoSaldo.setText(p.getSimboloMoneda() + " " + String.valueOf(p.getSaldoActual()));

        this.txtAbono.setText("");

        if (p.getSaldoActual() > 0) {
            btnAplicarPago.setEnabled(true);

        } else {
            btnAplicarPago.setEnabled(false);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnAplicarPago = new javax.swing.JButton();
        btnVerEstadoCuenta = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtNombres = new javax.swing.JTextField();
        dtFechaPago = new org.jdesktop.swingx.JXDatePicker();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtMontoOriginal = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtAbono = new javax.swing.JTextField();
        txtNuevoSaldo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAbonos = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtCuota = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de Pago");
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblTitulo.setBackground(new java.awt.Color(0, 0, 102));
        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("REGISTRO DE PAGO");
        lblTitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblTitulo.setFocusable(false);
        lblTitulo.setIconTextGap(10);
        lblTitulo.setMaximumSize(new java.awt.Dimension(178, 20));
        lblTitulo.setMinimumSize(new java.awt.Dimension(178, 28));
        lblTitulo.setOpaque(true);
        lblTitulo.setPreferredSize(new java.awt.Dimension(178, 28));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setToolTipText("");
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnAplicarPago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loansystem/recursos/paneles/pago.png"))); // NOI18N
        btnAplicarPago.setText("Aplicar");
        btnAplicarPago.setToolTipText("Aceptar");
        btnAplicarPago.setFocusable(false);
        btnAplicarPago.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAplicarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarPagoActionPerformed(evt);
            }
        });
        jPanel2.add(btnAplicarPago);

        btnVerEstadoCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loansystem/recursos/paneles/estado_cuenta.png"))); // NOI18N
        btnVerEstadoCuenta.setText("Estado de Cuenta");
        btnVerEstadoCuenta.setToolTipText("Estado de Cuenta");
        btnVerEstadoCuenta.setFocusable(false);
        btnVerEstadoCuenta.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnVerEstadoCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerEstadoCuentaActionPerformed(evt);
            }
        });
        jPanel2.add(btnVerEstadoCuenta);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loansystem/recursos/paneles/cerrar.png"))); // NOI18N
        btnCancelar.setText("Cerrar");
        btnCancelar.setToolTipText("Cerrar");
        btnCancelar.setFocusable(false);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCancelar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar);

        txtNombres.setEditable(false);
        txtNombres.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        dtFechaPago.setToolTipText("Fecha de Inicio");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Nombres y Apellidos:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 153, 153));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Monto Original:");

        txtMontoOriginal.setEditable(false);
        txtMontoOriginal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 153, 153));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Saldo a la Fecha:");

        txtSaldo.setEditable(false);
        txtSaldo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Fecha del Pago:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Monto del Pago:");

        txtAbono.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtAbono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAbonoKeyReleased(evt);
            }
        });

        txtNuevoSaldo.setEditable(false);
        txtNuevoSaldo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        tblAbonos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número de Abono", "Número de Préstamo", "Fecha", "Monto", "Saldo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAbonos);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(153, 153, 153));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Nuevo Saldo:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(153, 153, 153));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Monto de Cuota:");

        txtCuota.setEditable(false);
        txtCuota.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombres)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(dtFechaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtAbono, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtMontoOriginal, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCuota, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNuevoSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 12, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMontoOriginal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel18)
                            .addComponent(txtCuota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dtFechaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14)
                            .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAbono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(txtNuevoSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAplicarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarPagoActionPerformed
        try {

            AbonoEntidad abono = new AbonoEntidad();
            AbonoDAO abonoDao = new AbonoDAO(con.getCon());

            abono.setIdPrestamo(p.getIdPrestamo());
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String fecha = format.format(dtFechaPago.getDate());
            abono.setFecha(fecha);
            double abonado = Double.parseDouble(txtAbono.getText());
            abono.setMontoAbonado(abonado);
            abono.setNuevoSaldo(getNuevoSaldo());

            if (getNuevoSaldo() >= 0) {
                abonoDao.insertarPrestamo(abono);

                JOptionPane.showMessageDialog(prin, "Pago aplicado Correctamente");
                PrestamoDAO prestamoDao = new PrestamoDAO(con.getCon());
                
                
                if(abono.getNuevoSaldo()<=0)
                {
                     boolean res = prestamoDao.cambiarEstado(p.getIdPrestamo(), 2 );
                }
                
                p = prestamoDao.obtenerPrestamosPorIdPrestamo(p.getIdPrestamo());
                actualizarCuotas();
                cargarAbonos();
                cargarDatosGenerales();
                
                pres.cargarDatosCliente(cliente, p);

                //this.dispose();
            } else {
                JOptionPane.showMessageDialog(prin, "El Monto abonado no puede ser mayor al Saldo!", "Error al Registrar Pago!", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(prin, "Por favor valide los datos", "Error al Registrar Pago!", JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_btnAplicarPagoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        pres.cargarDatosCliente(cliente, p);

        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtAbonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAbonoKeyReleased
        try {

            txtNuevoSaldo.setText(this.p.getSimboloMoneda() + " " + String.valueOf(getNuevoSaldo()));
        } catch (Exception e) {
            txtNuevoSaldo.setText(this.p.getSimboloMoneda() + " " + String.valueOf(p.getSaldoActual()));
        }

    }//GEN-LAST:event_txtAbonoKeyReleased

    private void btnVerEstadoCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerEstadoCuentaActionPerformed
       String reporte =  "EstadoCuentaPrestamo.jrxml";
       URL fileName = getClass().getResource("/loansystem/reportes/"+reporte);
                    String archivo = fileName.getPath();
       
       HashMap<String,Object> param = new HashMap<String,Object>(); //aquí construyo un HashMap para parámetros adicionales
       param.put("idPrestamo", p.getIdPrestamo());       
       param.put("SUBREPORT_DIR",archivo.replaceAll(reporte, "") );
       System.out.println("ruta: "+archivo.replaceAll(reporte, ""));
      
       
       prin.abrirReporte("EstadoCuentaPrestamo", param,"Estado "+util.completarCerosID(p.getIdPrestamo(), 6),"registrar_prestamo");
       this.dispose();
    }//GEN-LAST:event_btnVerEstadoCuentaActionPerformed

    private void cargarAbonos() {
        ArrayList<AbonoEntidad> abonosArray;
        AbonoDAO abonoDao = new AbonoDAO(con.getCon());

        abonosArray = abonoDao.obtenerPrestamosPorCliente(p.getIdPrestamo());

        int fila = 0;
        util.limpiarTabla(tblAbonos);

        for (AbonoEntidad abono : abonosArray) {
            util.agregarFila(tblAbonos);
            tblAbonos.setValueAt(util.completarCerosID(abono.getIdAbono(), 6), fila, 0);
            tblAbonos.setValueAt(util.completarCerosID(abono.getIdPrestamo(), 6), fila, 1);
            tblAbonos.setValueAt(abono.getFecha(), fila, 2);
            tblAbonos.setValueAt(util.formatearMoneda(abono.getMontoAbonado(), p.getSimboloMoneda()), fila, 3);
            tblAbonos.setValueAt(util.formatearMoneda(abono.getNuevoSaldo(), p.getSimboloMoneda()), fila, 4);

            fila++;
        }

    }

    private double getNuevoSaldo() {
        double abono = 0;
        abono = Double.parseDouble(txtAbono.getText());
        double saldo = this.p.getSaldoActual() - abono;

        return saldo;
    }
    
    /**
     * Actualizamos la cuotas pagadas!
     */
    private void actualizarCuotas()
    {
        double mCuota = p.getMontoCuota();
        double mSaldo = p.getSaldoActual();
        double mTotal = p.getMontoTotal();
        int cuotasPagadas = (int) ((mTotal-mSaldo)/mCuota);
        
        ArrayList<CuotasEntidad> arrayCuota = null;
        CuotasDAO cuotaDao = new CuotasDAO(con.getCon());
        
        arrayCuota = cuotaDao.obtenerCuotasPorPrestamo(p.getIdPrestamo());
        if(arrayCuota.size()>0)
        {
           
             int i = 0;
            for(CuotasEntidad cuota : arrayCuota)
            {
                cuotaDao.actualizarEstadoCuota(cuota.getIdCuota(), ((i+1)<=cuotasPagadas?1:0 ) );              
                
                i++;
            }
        }
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAplicarPago;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnVerEstadoCuenta;
    private org.jdesktop.swingx.JXDatePicker dtFechaPago;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblAbonos;
    private javax.swing.JTextField txtAbono;
    private javax.swing.JTextField txtCuota;
    private javax.swing.JTextField txtMontoOriginal;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtNuevoSaldo;
    private javax.swing.JTextField txtSaldo;
    // End of variables declaration//GEN-END:variables
}