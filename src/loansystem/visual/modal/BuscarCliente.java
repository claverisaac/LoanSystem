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
import loansystem.dao.ClienteDAO;
import loansystem.dao.MunicipioDAO;
import loansystem.dao.PrestamoDAO;
import loansystem.entidad.ClienteEntidad;
import loansystem.entidad.MunicipioEntidad;
import loansystem.entidad.PrestamoEntidad;
import loansystem.utilidades.MetodosGenerales;
import loansystem.visual.panel.Prestamo;

/**
 *
 * @author cgarcia
 */
public class BuscarCliente extends javax.swing.JDialog {

    private Conexion con; 
    private Principal prin;
    private Prestamo pres;
    private MetodosGenerales util;
    private ClienteDAO clieDAO;
    private ClienteEntidad cliente=null;
    
    /**
     * Creates new form BuscarCliente
     */
    public BuscarCliente(Principal prin, boolean modal, Conexion con, Prestamo pres) {
        super(prin, modal);
        this.prin = prin;
        this.con = con;
        this.pres = pres;
        
        util = new MetodosGenerales();
        clieDAO = new ClienteDAO(con.getCon());
        
        initComponents();
        
        cargarTablaClientes(clieDAO.obtenerTodosClientes());
        
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabClientes = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnBuscarTodos = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Cliente");
        setBackground(new java.awt.Color(255, 255, 255));

        tabClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombres", "Apellidos", "Cédula", "Sexo", "Departamento", "Municipio", "Movil", "Telefono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabClientes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabClientes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tabClientesFocusGained(evt);
            }
        });
        tabClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabClientes);
        if (tabClientes.getColumnModel().getColumnCount() > 0) {
            tabClientes.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabClientes.getColumnModel().getColumn(0).setMaxWidth(50);
            tabClientes.getColumnModel().getColumn(1).setPreferredWidth(120);
            tabClientes.getColumnModel().getColumn(2).setPreferredWidth(120);
        }

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Búsqueda por:"));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Buscar:");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loansystem/recursos/botones/encontrar.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnBuscarTodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loansystem/recursos/botones/repeat.png"))); // NOI18N
        btnBuscarTodos.setToolTipText("Todos");
        btnBuscarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22))
                    .addComponent(btnBuscarTodos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loansystem/recursos/paneles/like.png"))); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.setToolTipText("Aceptar");
        btnAceptar.setFocusable(false);
        btnAceptar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar);

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
        jPanel1.add(btnCancelar);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        setSize(new java.awt.Dimension(878, 463));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tabClientesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tabClientesFocusGained
        // TODO add your handling code here:
       // cargarFormulario();
      
    }//GEN-LAST:event_tabClientesFocusGained

    private void tabClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabClientesMouseClicked
        // TODO add your handling code here:
      //  cargarFormulario();
       
    }//GEN-LAST:event_tabClientesMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (txtNombre.getText().length() > 0) {            //Buscar por nombre
            cargarTablaClientes(clieDAO.obtenerClientesXParametro(txtNombre.getText())); 
            
        }else{ JOptionPane.showMessageDialog(null, "Debe indicar al menos un parámetro de búsqueda", "Loan System", JOptionPane.ERROR_MESSAGE);
          
        }

        /*   if (txtId.getText().equals("") && txtNombre.getText().equals("") && txtCed.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe indicar al menos un parámetro de búsqueda", "Loan System", JOptionPane.ERROR_MESSAGE);
        }*/
        //cargarTablaClientes();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarTodosActionPerformed
        txtNombre.setText("");
        cargarTablaClientes(clieDAO.obtenerTodosClientes());
    }//GEN-LAST:event_btnBuscarTodosActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        int id =  Integer.parseInt(tabClientes.getValueAt(tabClientes.getSelectedRow(), 0).toString());
        cliente = clieDAO.obtenerCliente(id);
        
        ArrayList<PrestamoEntidad> arrP = new ArrayList<PrestamoEntidad>();
        PrestamoDAO pDao = new PrestamoDAO(con.getCon());
        arrP = pDao.obtenerPrestamosPorClienteEstado(cliente.getIdCliente(),1); //Prestamos abiertos
        
        if(arrP.size()>0) {
            if(JOptionPane.showConfirmDialog(prin, "El cliente "+cliente.getNombres()+" "+cliente.getApellidos()+" tiene "+arrP.size()+" préstamos abiertos. \n¿Desea editar uno de estos?", 
                    "Cliente con Pedidos Abiertos", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.OK_CANCEL_OPTION, 
                    new javax.swing.ImageIcon(getClass().getResource("/loansystem/recursos/prestamo.png"))) == JOptionPane.YES_OPTION)
            {
                System.out.println("Selecciono Si");
                
            }else
            {
                this.pres.cargarDatosCliente(cliente);
            }
        }else
        {
            this.pres.cargarDatosCliente(cliente);
        }
        
        
        this.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    public void cargarTablaClientes(ArrayList<ClienteEntidad> aClieEnti) {
        if (aClieEnti != null) {
            MunicipioDAO muDao = new MunicipioDAO(con.getCon());
            

            util.limpiarTabla(tabClientes);
            String estado;
            for (int i = 0; i < aClieEnti.size(); i++) {
                MunicipioEntidad municipio = muDao.obtenerMunicipioXId(aClieEnti.get(i).getIdMunicipio());
                
                util.agregarFila(tabClientes);
                tabClientes.setValueAt(aClieEnti.get(i).getIdCliente(), i, 0); //ID
                tabClientes.setValueAt(aClieEnti.get(i).getNombres(), i, 1); //nombres
                tabClientes.setValueAt(aClieEnti.get(i).getApellidos(), i, 2); //apellidios
                tabClientes.setValueAt(aClieEnti.get(i).getNumCedula(), i, 3); //cedula
                tabClientes.setValueAt((aClieEnti.get(i).getSexo().equals("M")?"Masculino":"Femenino")  , i, 4); //sexo
                tabClientes.setValueAt(municipio.getDepartamento(), i, 5); //departamento
                tabClientes.setValueAt(municipio.getMunicipio(), i, 6); //municipio
                tabClientes.setValueAt(aClieEnti.get(i).getTelefonoMovil(), i, 7); //movil
                tabClientes.setValueAt(aClieEnti.get(i).getTelefonoCasa(), i, 8); //telefono
                //tabClientes.setValueAt(aClieEnti.get(i).getIdRutaVisita(), i, 9); //ruta

            }

        }
    }
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarTodos;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabClientes;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
