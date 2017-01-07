/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loansystem;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import loansystem.bd.Conexion;
import loansystem.visual.panel.*;
import loansystem.visual.panel.Prestamo;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author cgarcia
 */
public class Principal extends javax.swing.JFrame {

    private static Conexion con;

    Cliente panelCliente;
    Prestamo panelPrestamo;
    Usuario panelUsuarios;
    Personal panelPersonal;
    private ActionListener actionListener;
    private int pestania = 0;

    /**
     * Creates new form Principal Otro comentario mas..
     */
    public Principal(Conexion con) {
        this.con = con;
        initComponents();

        setExtendedState(MAXIMIZED_BOTH);

        actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();
                for (int i = 0; i < tabPrincipal.getTabCount(); i++) {
                    if (SwingUtilities.isDescendingFrom(button, tabPrincipal.getTabComponentAt(i))) {
                        JPanel panel = (JPanel) tabPrincipal.getComponentAt(i);
                        tabPrincipal.remove(i);
                        pestania--;

                        if (panel == panelCliente) {
                            panelCliente = null;
                        }

                        if (panel == panelPrestamo) {
                            panelPrestamo = null;
                        }

                        if (panel == panelUsuarios) {
                            panelUsuarios = null;
                        }

                        if (panel == panelPersonal) {
                            panelPersonal = null;
                        }

                        break;
                    }
                }
            }
        };

        tabPrincipal.add("Start Page", new StartPage(this, con));

    }

    private void cargarModulo(JPanel panel, String titulo, String tooltip, String icono) {
        JLabel label = new JLabel(titulo, cargarIconoTab(icono), JLabel.RIGHT);
        label.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14));
        JButton closeButton = new JButton(cargarIconoTab("close"));
        closeButton.addActionListener(actionListener);
        closeButton.setOpaque(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setBorderPainted(false);
        closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JPanel tabComponent = new JPanel(new BorderLayout(5, 5));
        tabComponent.add(label, BorderLayout.WEST);
        tabComponent.add(closeButton, BorderLayout.EAST);
        tabComponent.setOpaque(false);

        pestania++;
        tabPrincipal.addTab(null, panel);
        tabPrincipal.setTabComponentAt(pestania, tabComponent);
        tabPrincipal.setSelectedIndex(pestania);

        /*tabPrincipal.add(titulo, panel);
        tabPrincipal.setSelectedComponent(panel);
        // tabPrincipal.setSelectedIndex(tabPrincipal.getComponentCount() - 1);
        tabPrincipal.setToolTipTextAt(tabPrincipal.getSelectedIndex(), tooltip);
        if (icono.length() > 0) {
            tabPrincipal.setIconAt(tabPrincipal.getSelectedIndex(), cargarIconoTab(icono));
        }*/
    }

    public void removerModulo(JPanel panel) {
        this.tabPrincipal.remove(panel);
        pestania--;
    }

    public Icon cargarIconoTab(String nombreIcono) {
        return new javax.swing.ImageIcon(getClass().getResource("/loansystem/recursos/" + nombreIcono + ".png"));
    }

    public void seleccionarTab(JPanel panel) {
        if (panel == null) {
        } else {
            tabPrincipal.setSelectedComponent(panel);
        }

    }

    public void removerTab(JPanel panel) {
        tabPrincipal.remove(panel);
        if (panel == panelCliente) {
            panelCliente = null;
        }

        if (panel == panelPrestamo) {
            panelPrestamo = null;
        }

        if (panel == panelUsuarios) {
            panelUsuarios = null;
        }

        if (panel == panelPersonal) {
            panelPersonal = null;
        }

        pestania--;

    }

    /**
     * Abrir reporte
     *
     * @param reporte
     * @param parametros
     * @param titulo
     * @param icono
     */
    public void abrirReporte(String reporte, HashMap parametros, String titulo, String icono) {

        try {
            URL fileName = getClass().getResource("/loansystem/reportes/" + reporte + ".jrxml");
            String archivo = fileName.getPath();
            System.out.println("reporte: " + archivo);

            if (fileName == null) {
                System.out.println("No encuentro el archivo del reporte.");
                System.exit(2);
            }

            File theFile = new File(archivo);
            JasperDesign jasperDesign = JRXmlLoader.load(theFile);

            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, con.getCon());

            this.cargarModulo((JPanel) new JPanel().add(new JRViewer(jasperPrint)), titulo, titulo, icono);

        } catch (Exception j) {
            System.out.println("Mensaje de Error:" + j.getMessage());
            javax.swing.JOptionPane.showMessageDialog(null, j.getLocalizedMessage());
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
        tskPrestamo = new com.l2fprod.common.swing.JTaskPaneGroup();
        lnkNuevoPrestamo = new com.l2fprod.common.swing.JLinkButton();
        lnkNuevoPago = new com.l2fprod.common.swing.JLinkButton();
        tskReportes = new com.l2fprod.common.swing.JTaskPaneGroup();
        lnkNuevoPrestamo1 = new com.l2fprod.common.swing.JLinkButton();
        tskEmpresa = new com.l2fprod.common.swing.JTaskPaneGroup();
        lnkUsuarios = new com.l2fprod.common.swing.JLinkButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        lnkCargo = new com.l2fprod.common.swing.JLinkButton();
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
        lnkNuevoCliente.setText("Registrar Cliente");
        lnkNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnkNuevoClienteActionPerformed(evt);
            }
        });
        tskCliente.getContentPane().add(lnkNuevoCliente);

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

        tskReportes.setExpanded(false);
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

        tskEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loansystem/recursos/admin.png"))); // NOI18N
        tskEmpresa.setTitle("Administración");

        lnkUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loansystem/recursos/usuarios.png"))); // NOI18N
        lnkUsuarios.setText("Administrar Usuarios");
        lnkUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnkUsuariosActionPerformed(evt);
            }
        });
        tskEmpresa.getContentPane().add(lnkUsuarios);

        jSeparator1.setPreferredSize(new java.awt.Dimension(0, 10));
        tskEmpresa.getContentPane().add(jSeparator1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Catálogos");
        tskEmpresa.getContentPane().add(jLabel1);

        lnkCargo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loansystem/recursos/cargo.png"))); // NOI18N
        lnkCargo.setText("Personal");
        lnkCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnkCargoActionPerformed(evt);
            }
        });
        tskEmpresa.getContentPane().add(lnkCargo);

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
            panelPrestamo = new Prestamo(con, this);
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
            panelCliente = new Cliente(con, this);
            cargarModulo(panelCliente, "Clientes", "Catalogo de Clientes", "nuevo_cliente");
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

    private void lnkUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnkUsuariosActionPerformed
        // TODO add your handling code here:
        if (panelUsuarios == null) {
            panelUsuarios = new Usuario(con, this);
            cargarModulo(panelUsuarios, "Usuarios", "Administración de Usuarios", "usuarios");
        } else {
            this.seleccionarTab(panelUsuarios);
        }
    }//GEN-LAST:event_lnkUsuariosActionPerformed

    private void lnkCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnkCargoActionPerformed
        // TODO add your handling code here:
        if (panelPersonal == null) {
            panelPersonal = new Personal(con, this);
            cargarModulo(panelPersonal, "Personal", "Administración de Personal", "cargo");
        } else {
            this.seleccionarTab(panelPersonal);
        }
    }//GEN-LAST:event_lnkCargoActionPerformed


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
    private com.l2fprod.common.swing.JLinkButton lnkCargo;
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
