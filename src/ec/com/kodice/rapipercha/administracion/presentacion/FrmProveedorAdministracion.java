/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.com.kodice.rapipercha.administracion.presentacion;

import ec.com.kodice.rapipercha.administracion.negocio.PerfilBO;
import ec.com.kodice.rapipercha.administracion.negocio.ProveedorBO;
import ec.com.kodice.rapipercha.util.UtilPresentacion;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * Esta clase contiene atributos y métodos del formulario FrmPerfilAdministracion
 * @author Benjamin Cepeda
 * @version v1.0
 * @date 2020/12/06
 */
public class FrmProveedorAdministracion extends javax.swing.JFrame {

    /** Creates new form FrmPerfilAdministracion */
    public FrmProveedorAdministracion() {
        initComponents();
        cargarModelo();
        this.setLocationRelativeTo(null);
    }
    private void cargarModelo(){
        ProveedorBO ProveedorBO = new ProveedorBO();
        try {
            tblProveedores.setModel(ProveedorBO.generaModeloDatosTabla(new Object[]{"CODIGO", "RUC","RAZON SOCIAL", "NOMBRE COMERCIAL"}));
        }
        catch ( Exception e) {
            UtilPresentacion.mostrarMensajeError(this, e.getMessage());
        }
        finally{
            ProveedorBO = null;   
            btnConsultar.setEnabled(false);
            btnEditar.setEnabled(false);
            btnBorrar.setEnabled(false);            
        }
            
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContenedor = new javax.swing.JPanel();
        pnlCabecera = new javax.swing.JPanel();
        lblLogoRapipercha = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        pnlDetalle = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProveedores = new javax.swing.JTable();
        pnlPie = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        lblLogoKodice = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        pnlContenedor.setAlignmentX(0.0F);
        pnlContenedor.setAlignmentY(0.0F);
        pnlContenedor.setPreferredSize(new java.awt.Dimension(800, 650));

        pnlCabecera.setBackground(new java.awt.Color(64, 124, 202));
        pnlCabecera.setAlignmentX(0.0F);
        pnlCabecera.setAlignmentY(0.0F);
        pnlCabecera.setMaximumSize(new java.awt.Dimension(32767, 90));
        pnlCabecera.setMinimumSize(new java.awt.Dimension(0, 90));
        pnlCabecera.setPreferredSize(new java.awt.Dimension(445, 90));

        lblLogoRapipercha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/com/kodice/rapipercha/imagenes/logo-rapipercha.png"))); // NOI18N

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("ADMINISTRACIÓN DE PERFILES");

        javax.swing.GroupLayout pnlCabeceraLayout = new javax.swing.GroupLayout(pnlCabecera);
        pnlCabecera.setLayout(pnlCabeceraLayout);
        pnlCabeceraLayout.setHorizontalGroup(
            pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCabeceraLayout.createSequentialGroup()
                .addComponent(lblLogoRapipercha)
                .addGap(129, 129, 129)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlCabeceraLayout.setVerticalGroup(
            pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogoRapipercha)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCabeceraLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(31, 31, 31))
        );

        pnlDetalle.setAlignmentX(0.0F);
        pnlDetalle.setAlignmentY(0.0F);

        tblProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Codigo", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProveedores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblProveedores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblProveedoresMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblProveedores);

        pnlPie.setMaximumSize(new java.awt.Dimension(32767, 90));
        pnlPie.setMinimumSize(new java.awt.Dimension(0, 90));
        pnlPie.setPreferredSize(new java.awt.Dimension(780, 90));

        btnNuevo.setBackground(new java.awt.Color(64, 124, 202));
        btnNuevo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/com/kodice/rapipercha/imagenes/Empty document new.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setToolTipText("");
        btnNuevo.setAlignmentY(0.0F);
        btnNuevo.setBorderPainted(false);
        btnNuevo.setIconTextGap(1);
        btnNuevo.setMaximumSize(new java.awt.Dimension(118, 55));
        btnNuevo.setMinimumSize(new java.awt.Dimension(118, 55));
        btnNuevo.setPreferredSize(new java.awt.Dimension(118, 55));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnConsultar.setBackground(new java.awt.Color(64, 124, 202));
        btnConsultar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnConsultar.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/com/kodice/rapipercha/imagenes/Zoom.png"))); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.setToolTipText("");
        btnConsultar.setAlignmentY(0.0F);
        btnConsultar.setBorderPainted(false);
        btnConsultar.setIconTextGap(1);
        btnConsultar.setMaximumSize(new java.awt.Dimension(135, 55));
        btnConsultar.setMinimumSize(new java.awt.Dimension(135, 55));
        btnConsultar.setPreferredSize(new java.awt.Dimension(135, 55));
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(64, 124, 202));
        btnEditar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/com/kodice/rapipercha/imagenes/Pencil yellow.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setAlignmentY(0.0F);
        btnEditar.setBorderPainted(false);
        btnEditar.setIconTextGap(1);
        btnEditar.setMaximumSize(new java.awt.Dimension(118, 55));
        btnEditar.setMinimumSize(new java.awt.Dimension(118, 55));
        btnEditar.setPreferredSize(new java.awt.Dimension(118, 55));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnBorrar.setBackground(new java.awt.Color(64, 124, 202));
        btnBorrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBorrar.setForeground(new java.awt.Color(255, 255, 255));
        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/com/kodice/rapipercha/imagenes/Badge-multiply.png"))); // NOI18N
        btnBorrar.setText("Borrar");
        btnBorrar.setAlignmentY(0.0F);
        btnBorrar.setBorderPainted(false);
        btnBorrar.setIconTextGap(1);
        btnBorrar.setMaximumSize(new java.awt.Dimension(118, 55));
        btnBorrar.setMinimumSize(new java.awt.Dimension(118, 55));
        btnBorrar.setPreferredSize(new java.awt.Dimension(118, 55));
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(64, 124, 202));
        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/com/kodice/rapipercha/imagenes/Badge-cancel.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setAlignmentY(0.0F);
        btnSalir.setBorderPainted(false);
        btnSalir.setIconTextGap(1);
        btnSalir.setMaximumSize(new java.awt.Dimension(118, 55));
        btnSalir.setMinimumSize(new java.awt.Dimension(118, 55));
        btnSalir.setPreferredSize(new java.awt.Dimension(118, 55));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        lblLogoKodice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/com/kodice/rapipercha/imagenes/logo-kodice.png"))); // NOI18N
        lblLogoKodice.setMaximumSize(new java.awt.Dimension(125, 55));
        lblLogoKodice.setMinimumSize(new java.awt.Dimension(125, 55));
        lblLogoKodice.setPreferredSize(new java.awt.Dimension(125, 55));

        javax.swing.GroupLayout pnlPieLayout = new javax.swing.GroupLayout(pnlPie);
        pnlPie.setLayout(pnlPieLayout);
        pnlPieLayout.setHorizontalGroup(
            pnlPieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPieLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblLogoKodice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        pnlPieLayout.setVerticalGroup(
            pnlPieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPieLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogoKodice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlPieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlDetalleLayout = new javax.swing.GroupLayout(pnlDetalle);
        pnlDetalle.setLayout(pnlDetalleLayout);
        pnlDetalleLayout.setHorizontalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(pnlPie, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        pnlDetalleLayout.setVerticalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalleLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlPie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlContenedorLayout = new javax.swing.GroupLayout(pnlContenedor);
        pnlContenedor.setLayout(pnlContenedorLayout);
        pnlContenedorLayout.setHorizontalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCabecera, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addComponent(pnlDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlContenedorLayout.setVerticalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenedorLayout.createSequentialGroup()
                .addComponent(pnlCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        FrmProveedorNuevo frmProveedorNuevo = new FrmProveedorNuevo();
        frmProveedorNuevo.setVisible(true);  
        cargarModelo();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        String codigoElegido = "";
        String descripcionElegido = "";
        boolean confirmacionBorrado = false;
        int fila = tblProveedores.getSelectedRow();
        if (fila >= 0) {
            codigoElegido = tblProveedores.getModel().getValueAt(
                    fila, 0).toString();
            descripcionElegido = tblProveedores.getModel().getValueAt(fila, 1).
                    toString() + tblProveedores.getModel().getValueAt(fila, 2).
                    toString();
        }
        if (!(codigoElegido.isEmpty() | codigoElegido.isBlank())) {
            confirmacionBorrado = (UtilPresentacion.mostrarMensajeConfirmacion(
                    this, "Desea eliminar el registro:\n" + codigoElegido + " - "
                    + descripcionElegido) == JOptionPane.YES_OPTION);
            if (confirmacionBorrado) {
                ProveedorBO proveedorBO = new ProveedorBO();
                try {
                    proveedorBO.eliminar(Integer.valueOf(codigoElegido));
                } catch (Exception e) {
                    UtilPresentacion.mostrarMensajeError(this, e.getMessage());
                } finally {
                    proveedorBO = null;
                }
            }
            cargarModelo();
        }

    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        String codigoElegido = "";
        int fila = tblProveedores.getSelectedRow();
        if (fila >= 0) {
            codigoElegido = tblProveedores.getModel().getValueAt(
                    fila, 0).toString();
        }
        if (!(codigoElegido.isEmpty() | codigoElegido.isBlank())) {
            FrmProveedorNuevo frmProveedorNuevo = new FrmProveedorNuevo(
                    Integer.valueOf(codigoElegido), false);
            frmProveedorNuevo.setVisible(true);
            cargarModelo();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        String codigoElegido = "";
        int fila = tblProveedores.getSelectedRow();
        if (fila >= 0) {
            codigoElegido = tblProveedores.getModel().getValueAt(
                fila, 0).toString();
        }
        if (!(codigoElegido.isEmpty() | codigoElegido.isBlank())) {
            FrmProveedorNuevo frmProveedorNuevo = new FrmProveedorNuevo(
                Integer.valueOf(codigoElegido), true);
            frmProveedorNuevo.setVisible(true);
            cargarModelo();
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void tblProveedoresMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProveedoresMousePressed
        JTable source = (JTable) evt.getSource();
        String codigoElegido = "";
        int fila = source.rowAtPoint(evt.getPoint());
        //int column = source.columnAtPoint(evt.getPoint());
        if (fila >= 0) {
            codigoElegido = tblProveedores.getModel().getValueAt(
                    fila, 0).toString();
            btnConsultar.setEnabled(true);
            btnEditar.setEnabled(true);
            btnBorrar.setEnabled(true);
            if (evt.getClickCount() == 2 && !codigoElegido.isEmpty() && !codigoElegido.isBlank()) {
                FrmProveedorNuevo frmProveedorNuevo = new FrmProveedorNuevo(
                        Integer.valueOf(codigoElegido),true);
                frmProveedorNuevo.setVisible(true);
                cargarModelo();
            }
        }
    }//GEN-LAST:event_tblProveedoresMousePressed

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
            java.util.logging.Logger.getLogger(FrmProveedorAdministracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmProveedorAdministracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmProveedorAdministracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmProveedorAdministracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmProveedorAdministracion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLogoKodice;
    private javax.swing.JLabel lblLogoRapipercha;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlCabecera;
    private javax.swing.JPanel pnlContenedor;
    private javax.swing.JPanel pnlDetalle;
    private javax.swing.JPanel pnlPie;
    private javax.swing.JTable tblProveedores;
    // End of variables declaration//GEN-END:variables

}
