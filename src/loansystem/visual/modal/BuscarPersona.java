/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loansystem.visual.modal;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import loansystem.Principal;
import loansystem.bd.Conexion;
import loansystem.dao.CargoDAO;
import loansystem.dao.MunicipioDAO;
import loansystem.dao.PersonalDAO;
import loansystem.entidad.CargoEntidad;
import loansystem.entidad.ClienteEntidad;
import loansystem.entidad.MunicipioEntidad;
import loansystem.entidad.PersonalEntidad;
import loansystem.utilidades.MetodosGenerales;
import loansystem.visual.panel.Usuario;

/**
 *
 * @author JChavarria
 */
public class BuscarPersona extends javax.swing.JDialog {
    private Conexion con;
    private Principal prin;
    private Usuario usu;
    private MetodosGenerales util;
    private PersonalDAO persoDAO;

    /**
     * Creates new form BuscarPersona
     * @param prin
     * @param modal
     * @param con
     * @param pres
     */
       public BuscarPersona(Principal prin, boolean modal, Conexion con, Usuario usu) {
         super(prin, modal);
        this.prin = prin;
        this.con = con;
        this.usu=usu;
     
        
        util = new MetodosGenerales();
        persoDAO = new PersonalDAO(con.getCon());
        
        initComponents();
        
        cargarTablaPersonal(persoDAO.obtenerTodosPersonas());
        
         setLocationRelativeTo(null);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnBuscarTodos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabPersonal = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Personal");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Búsqueda por:"));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Buscar:");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loansystem/recursos/paneles/search.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnBuscarTodos.setText("Todos");
        btnBuscarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarTodosActionPerformed(evt);
            }
        });

        tabPersonal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombres", "Apellidos", "Cédula", "Cargo", "Sexo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabPersonal);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loansystem/recursos/paneles/back.png"))); // NOI18N
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

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loansystem/recursos/paneles/save.png"))); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.setToolTipText("Aceptar");
        btnAceptar.setFocusable(false);
        btnAceptar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jScrollPane1)
                            .addContainerGap())
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel22)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnBuscarTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnAceptar)
                        .addGap(5, 5, 5)
                        .addComponent(btnCancelar)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscarTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
         if (txtNombre.getText().length() > 0) {            //Buscar por nombre
            cargarTablaPersonal(persoDAO.obtenerXPersona(txtNombre.getText()));

        } else {
            JOptionPane.showMessageDialog(null, "Debe indicar el parámetro de búsqueda", "Loan System", JOptionPane.ERROR_MESSAGE);

        }

       
       // cargarTablaPersonal(persoEnti);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarTodosActionPerformed
        txtNombre.setText("");
         cargarTablaPersonal(persoDAO.obtenerTodosPersonas());
    }//GEN-LAST:event_btnBuscarTodosActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
       int id = Integer.parseInt(tabPersonal.getValueAt(tabPersonal.getSelectedRow(), 0).toString());
        PersonalEntidad persoE = persoDAO.obtenerXPersona(id);

        System.out.print("++++++++++++++++++++++++++++++++valores  " +persoE.getApellidos());
        this.usu.cargarDatosPersonal(persoE);

        this.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed
    public void cargarTablaPersonal(ArrayList<PersonalEntidad> persoEnti) {
        if (persoEnti != null) {
           CargoDAO cargoDao = new CargoDAO(con.getCon());
            

            util.limpiarTabla(tabPersonal);
            String cargo;
            for (int i = 0; i < persoEnti.size(); i++) {
                CargoEntidad cargoenti = cargoDao.obtenerCargo(persoEnti.get(i).getIdCargo());
                
                util.agregarFila(tabPersonal);
                tabPersonal.setValueAt(persoEnti.get(i).getIdPersona(), i, 0); //ID
                tabPersonal.setValueAt(persoEnti.get(i).getNombres(), i, 1); //nombres
                tabPersonal.setValueAt(persoEnti.get(i).getApellidos(), i, 2); //apellidios
                tabPersonal.setValueAt(persoEnti.get(i).getNumCedula(), i, 3); //cedula
                tabPersonal.setValueAt(cargoenti.getCargo(), i, 4); //cargo
                tabPersonal.setValueAt(persoEnti.get(i).getSexo(), i, 5); //sexo
              
            }

        }
    }
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
            java.util.logging.Logger.getLogger(BuscarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BuscarPersona dialog = new BuscarPersona(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarTodos;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabPersonal;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
