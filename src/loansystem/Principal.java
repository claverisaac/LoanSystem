/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loansystem;

import javax.swing.Icon;
import javax.swing.JPanel;
import loansystem.bd.Conexion;
import loansystem.visual.panel.*;
import loansystem.visual.panel.Prestamo;

/**
 *
 * @author cgarcia
 */
public class Principal extends javax.swing.JFrame {
private static Conexion con;

    Cliente panelCliente ;
    Prestamo panelPrestamo;
    /**
     * Creates new form Principal
     * Otro comentario mas..
     */
    public Principal(Conexion con) {
        this.con =con;
        initComponents();
        
        setExtendedState(MAXIMIZED_BOTH);
        
        tabPrincipal.add("Asignación de Préstamo", new Prestamo(con, this));
       
    }

       private void cargarModulo(JPanel panel, String titulo, String tooltip, String icono) {
        tabPrincipal.add(titulo, panel);
        tabPrincipal.setSelectedComponent(panel);
        // tabPrincipal.setSelectedIndex(tabPrincipal.getComponentCount() - 1);
        tabPrincipal.setToolTipTextAt(tabPrincipal.getSelectedIndex(), tooltip);
        if (icono.length() > 0) {
            tabPrincipal.setIconAt(tabPrincipal.getSelectedIndex(), cargarIconoTab(icono));
        }
    }
   
     public Icon cargarIconoTab(String nombreIcono) {
        return new javax.swing.ImageIcon(getClass().getResource("/loansystem/recursos/" + nombreIcono + ".png"));
    }
       public void seleccionarTab(JPanel panel) {
           if(panel==null){
       }else{tabPrincipal.setSelectedComponent(panel);}

    }
         public void removerTab(JPanel panel) {
        tabPrincipal.remove(panel);
          if (panel == panelCliente) {
            panelCliente= null;
                }   
          
             if (panel == panelPrestamo) {
            panelPrestamo= null;
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

        pnelOpciones = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pnelOpcionesColl = new javax.swing.JPanel();
        tskCliente = new com.l2fprod.common.swing.JTaskPaneGroup();
        lnkNuevoCliente = new com.l2fprod.common.swing.JLinkButton();
        lnkBuscarCliente = new com.l2fprod.common.swing.JLinkButton();
        lnkModificarCliente = new com.l2fprod.common.swing.JLinkButton();
        tskPrestamo = new com.l2fprod.common.swing.JTaskPaneGroup();
        lnkNuevoPrestamo = new com.l2fprod.common.swing.JLinkButton();
        lnkNuevoPago = new com.l2fprod.common.swing.JLinkButton();
        tskReportes = new com.l2fprod.common.swing.JTaskPaneGroup();
        lnkNuevoPrestamo1 = new com.l2fprod.common.swing.JLinkButton();
        tskEmpresa = new com.l2fprod.common.swing.JTaskPaneGroup();
        lnkEmpresa = new com.l2fprod.common.swing.JLinkButton();
        lnkUsuarios = new com.l2fprod.common.swing.JLinkButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        lnkCargo = new com.l2fprod.common.swing.JLinkButton();
        lnkMonedas = new com.l2fprod.common.swing.JLinkButton();
        tabPrincipal = new javax.swing.JTabbedPane();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuArchivo = new javax.swing.JMenu();
        mnuSalir = new javax.swing.JMenuItem();
        mnuClientes = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Administración de Prestamos");

        pnelOpciones.setBackground(new java.awt.Color(0, 0, 102));
        pnelOpciones.setPreferredSize(new java.awt.Dimension(230, 545));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Loan System");

        pnelOpcionesColl.setOpaque(false);
        com.l2fprod.common.swing.PercentLayout percentLayout3 = new com.l2fprod.common.swing.PercentLayout();
        percentLayout3.setOrientation(1);
        percentLayout3.setGap(20);
        pnelOpcionesColl.setLayout(percentLayout3);

        tskCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loansystem/recursos/cliente.png"))); // NOI18N
        tskCliente.setTitle("Clientes");
        tskCliente.setOpaque(true);

        lnkNuevoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loansystem/recursos/nuevo_cliente.png"))); // NOI18N
        lnkNuevoCliente.setText("Registrar Nuevo Ciente");
        lnkNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnkNuevoClienteActionPerformed(evt);
            }
        });
        tskCliente.getContentPane().add(lnkNuevoCliente);

        lnkBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loansystem/recursos/buscar_cliente.png"))); // NOI18N
        lnkBuscarCliente.setText("Buscar Cliente");
        tskCliente.getContentPane().add(lnkBuscarCliente);

        lnkModificarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loansystem/recursos/modificar_cliente.png"))); // NOI18N
        lnkModificarCliente.setText("Modificar Cliente");
        tskCliente.getContentPane().add(lnkModificarCliente);

        pnelOpcionesColl.add(tskCliente);

        tskPrestamo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loansystem/recursos/prestamo.png"))); // NOI18N
        tskPrestamo.setTitle("Préstamo");

        lnkNuevoPrestamo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loansystem/recursos/registrar_prestamo.png"))); // NOI18N
        lnkNuevoPrestamo.setText("Registrar Préstamo");
        lnkNuevoPrestamo.setToolTipText("Registrar Nuevo Préstamo");
        lnkNuevoPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnkNuevoPrestamoActionPerformed(evt);
            }
        });
        tskPrestamo.getContentPane().add(lnkNuevoPrestamo);

        lnkNuevoPago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loansystem/recursos/pago.png"))); // NOI18N
        lnkNuevoPago.setText("Registrar Pago");
        tskPrestamo.getContentPane().add(lnkNuevoPago);

        pnelOpcionesColl.add(tskPrestamo);

        tskReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loansystem/recursos/reportes.png"))); // NOI18N
        tskReportes.setTitle("Reportes");
        tskReportes.setToolTipText("Reportes");

        lnkNuevoPrestamo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loansystem/recursos/registrar_prestamo.png"))); // NOI18N
        lnkNuevoPrestamo1.setText("Registrar Préstamo");
        lnkNuevoPrestamo1.setToolTipText("Registrar Nuevo Préstamo");
        lnkNuevoPrestamo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnkNuevoPrestamo1ActionPerformed(evt);
            }
        });
        tskReportes.getContentPane().add(lnkNuevoPrestamo1);

        pnelOpcionesColl.add(tskReportes);

        tskEmpresa.setExpanded(false);
        tskEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loansystem/recursos/admin.png"))); // NOI18N
        tskEmpresa.setTitle("Administración");

        lnkEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loansystem/recursos/empresa.png"))); // NOI18N
        lnkEmpresa.setText("Empresa");
        tskEmpresa.getContentPane().add(lnkEmpresa);

        lnkUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loansystem/recursos/usuarios.png"))); // NOI18N
        lnkUsuarios.setText("Administrar Usuarios");
        tskEmpresa.getContentPane().add(lnkUsuarios);

        jSeparator1.setPreferredSize(new java.awt.Dimension(0, 10));
        tskEmpresa.getContentPane().add(jSeparator1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Catálogos");
        tskEmpresa.getContentPane().add(jLabel1);

        lnkCargo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loansystem/recursos/cargo.png"))); // NOI18N
        lnkCargo.setText("Cargos");
        tskEmpresa.getContentPane().add(lnkCargo);

        lnkMonedas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loansystem/recursos/monedas.png"))); // NOI18N
        lnkMonedas.setText("Monedas");
        tskEmpresa.getContentPane().add(lnkMonedas);

        pnelOpcionesColl.add(tskEmpresa);

        javax.swing.GroupLayout pnelOpcionesLayout = new javax.swing.GroupLayout(pnelOpciones);
        pnelOpciones.setLayout(pnelOpcionesLayout);
        pnelOpcionesLayout.setHorizontalGroup(
            pnelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnelOpcionesLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnelOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnelOpcionesColl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        pnelOpcionesLayout.setVerticalGroup(
            pnelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnelOpcionesLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(pnelOpcionesColl, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE))
        );

        getContentPane().add(pnelOpciones, java.awt.BorderLayout.WEST);
        getContentPane().add(tabPrincipal, java.awt.BorderLayout.CENTER);

        jToolBar1.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loansystem/recursos/nuevo_cliente.png"))); // NOI18N
        jButton1.setToolTipText("Nuevo Cliente");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);
        jToolBar1.add(jSeparator2);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loansystem/recursos/registrar_prestamo.png"))); // NOI18N
        jButton2.setToolTipText("Nuevo Préstamo");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loansystem/recursos/pago.png"))); // NOI18N
        jButton3.setToolTipText("Registrar Pago");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton3);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loansystem/recursos/usuarios.png"))); // NOI18N
        jButton4.setToolTipText("Administrar Usuarios");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton4);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        mnuArchivo.setText("Archivo");

        mnuSalir.setText("Salir");
        mnuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSalirActionPerformed(evt);
            }
        });
        mnuArchivo.add(mnuSalir);

        jMenuBar1.add(mnuArchivo);

        mnuClientes.setText("Clientes");
        jMenuBar1.add(mnuClientes);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lnkNuevoPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnkNuevoPrestamoActionPerformed
        // TODO add your handling code here:
          if (panelPrestamo == null) {
                  panelPrestamo= new Prestamo(con,this);
                  cargarModulo(panelPrestamo, "Prestamos", "Prestamoss", "registrar_prestamo");
                  } else {
                          this.seleccionarTab(panelPrestamo);
                  }
        
    }//GEN-LAST:event_lnkNuevoPrestamoActionPerformed

    private void mnuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSalirActionPerformed
       System.exit(0);
    }//GEN-LAST:event_mnuSalirActionPerformed


    private void lnkNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnkNuevoClienteActionPerformed
        // TODO add your handling code here:
           if (panelCliente == null) {
                  panelCliente= new Cliente(con,this);
                  cargarModulo(panelCliente, "Clientes", "Catalogo de Clientess", "nuevo_cliente");
                  } else {
                          this.seleccionarTab(panelCliente);
                  }
       /* Cliente panelCliente = new Cliente(con, this);
        tabPrincipal.add(panelCliente);
        panelCliente.setVisible(true);*/
        
    }//GEN-LAST:event_lnkNuevoClienteActionPerformed

    private void lnkNuevoPrestamo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnkNuevoPrestamo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnkNuevoPrestamo1ActionPerformed


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal(con).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private com.l2fprod.common.swing.JLinkButton lnkBuscarCliente;
    private com.l2fprod.common.swing.JLinkButton lnkCargo;
    private com.l2fprod.common.swing.JLinkButton lnkEmpresa;
    private com.l2fprod.common.swing.JLinkButton lnkModificarCliente;
    private com.l2fprod.common.swing.JLinkButton lnkMonedas;
    private com.l2fprod.common.swing.JLinkButton lnkNuevoCliente;
    private com.l2fprod.common.swing.JLinkButton lnkNuevoPago;
    private com.l2fprod.common.swing.JLinkButton lnkNuevoPrestamo;
    private com.l2fprod.common.swing.JLinkButton lnkNuevoPrestamo1;
    private com.l2fprod.common.swing.JLinkButton lnkUsuarios;
    private javax.swing.JMenu mnuArchivo;
    private javax.swing.JMenu mnuClientes;
    private javax.swing.JMenuItem mnuSalir;
    private javax.swing.JPanel pnelOpciones;
    private javax.swing.JPanel pnelOpcionesColl;
    private javax.swing.JTabbedPane tabPrincipal;
    private com.l2fprod.common.swing.JTaskPaneGroup tskCliente;
    private com.l2fprod.common.swing.JTaskPaneGroup tskEmpresa;
    private com.l2fprod.common.swing.JTaskPaneGroup tskPrestamo;
    private com.l2fprod.common.swing.JTaskPaneGroup tskReportes;
    // End of variables declaration//GEN-END:variables
}
   
