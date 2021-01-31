/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.kodice.rapipercha.administracion.presentacion;

import ec.com.kodice.rapipercha.administracion.persistencia.EmpleadoVO;
import ec.com.kodice.rapipercha.administracion.persistencia.ProveedorVO;
import javax.swing.JFrame;

/**
 * Esta clase contiene atributos y métodos del formulario de Inicio
 * @author Benjamin Cepeda
 * @version v1.0
 * @date 2020/12/03 
 */
public class FrmInicio extends JFrame {
    private EmpleadoVO empleadoLogueado= null;
    private ProveedorVO proveedorEmpleadoLogueado = null;
    

    /**
     * Creates new form FrmInicio
     */
    public FrmInicio() {
        initComponents();
        
        this.setLocationRelativeTo(null);        
    }
    
    public FrmInicio(EmpleadoVO empleadoLogueado, 
            ProveedorVO proveedorEmpleadoLoguedo) {
        initComponents();
        this.setLocationRelativeTo(null);        
        this.empleadoLogueado = empleadoLogueado;
        this.proveedorEmpleadoLogueado = proveedorEmpleadoLoguedo;
        lblNombreUsuarario.setText(empleadoLogueado.getUsuario().getNombre());
        lblPerfil.setText(empleadoLogueado.getUsuario().getPerfil().getNombre());
        lblEmpresa.setText(proveedorEmpleadoLogueado.getNombreComercial());
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
        jLabel1 = new javax.swing.JLabel();
        pnlPie = new javax.swing.JPanel();
        lblTituloNombreUsuario = new javax.swing.JLabel();
        lblNombreUsuarario = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblTituloPerfil = new javax.swing.JLabel();
        lblPerfil = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblPoweredBy = new javax.swing.JLabel();
        lblKodice = new javax.swing.JLabel();
        lblTituloEmpresa = new javax.swing.JLabel();
        lblEmpresa = new javax.swing.JLabel();
        barPrincipal = new javax.swing.JMenuBar();
        mnuAdministracion = new javax.swing.JMenu();
        mniPerfiles = new javax.swing.JMenuItem();
        mniProveedores = new javax.swing.JMenuItem();
        mniUsuarios = new javax.swing.JMenuItem();
        mnCentrosExpendio = new javax.swing.JMenuItem();
        mnuTomaFisica = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(900, 700));
        setMinimumSize(new java.awt.Dimension(900, 700));
        setPreferredSize(new java.awt.Dimension(900, 700));
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/com/kodice/rapipercha/imagenes/logo-rapipercha.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(421, 421, 421))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(257, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(191, 191, 191))
        );

        pnlPie.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlPie.setMaximumSize(new java.awt.Dimension(32767, 25));
        pnlPie.setMinimumSize(new java.awt.Dimension(100, 25));
        pnlPie.setPreferredSize(new java.awt.Dimension(924, 25));

        lblTituloNombreUsuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTituloNombreUsuario.setText("Usuario:");
        lblTituloNombreUsuario.setAlignmentY(0.0F);

        lblNombreUsuarario.setText("Usuario Logueado");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lblTituloPerfil.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTituloPerfil.setText("Perfil:");
        lblTituloPerfil.setAlignmentY(0.0F);

        lblPerfil.setText("Perfil del Usuario");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lblPoweredBy.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPoweredBy.setForeground(new java.awt.Color(51, 51, 255));
        lblPoweredBy.setText("Powered by:");
        lblPoweredBy.setAlignmentY(0.0F);

        lblKodice.setForeground(new java.awt.Color(0, 0, 255));
        lblKodice.setText("Kodice S.A. - UIsrael @2020");

        lblTituloEmpresa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTituloEmpresa.setText("Empresa:");
        lblTituloEmpresa.setAlignmentY(0.0F);

        lblEmpresa.setText("Nombre Empresa");

        javax.swing.GroupLayout pnlPieLayout = new javax.swing.GroupLayout(pnlPie);
        pnlPie.setLayout(pnlPieLayout);
        pnlPieLayout.setHorizontalGroup(
            pnlPieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPieLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloNombreUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombreUsuarario, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTituloPerfil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTituloEmpresa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                .addComponent(lblPoweredBy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblKodice)
                .addGap(128, 128, 128))
        );
        pnlPieLayout.setVerticalGroup(
            pnlPieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblKodice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPoweredBy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlPieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTituloEmpresa))
            .addGroup(pnlPieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblNombreUsuarario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTituloNombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTituloPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1))
            .addComponent(jSeparator2)
        );

        mnuAdministracion.setText("Administración");

        mniPerfiles.setText("Perfiles");
        mniPerfiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniPerfilesActionPerformed(evt);
            }
        });
        mnuAdministracion.add(mniPerfiles);

        mniProveedores.setText("Proveedores");
        mniProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniProveedoresActionPerformed(evt);
            }
        });
        mnuAdministracion.add(mniProveedores);

        mniUsuarios.setText("Usuarios");
        mniUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniUsuariosActionPerformed(evt);
            }
        });
        mnuAdministracion.add(mniUsuarios);

        mnCentrosExpendio.setText("CentrosExpendio");
        mnCentrosExpendio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCentrosExpendioActionPerformed(evt);
            }
        });
        mnuAdministracion.add(mnCentrosExpendio);

        barPrincipal.add(mnuAdministracion);

        mnuTomaFisica.setText("Toma física");
        barPrincipal.add(mnuTomaFisica);

        setJMenuBar(barPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlPie, javax.swing.GroupLayout.DEFAULT_SIZE, 1002, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlPie, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniProveedoresActionPerformed
        FrmProveedorAdministracion frmProveedorAdministracion = new FrmProveedorAdministracion();
        frmProveedorAdministracion.setVisible(true);
        
    }//GEN-LAST:event_mniProveedoresActionPerformed

    private void mniPerfilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniPerfilesActionPerformed
        FrmPerfilAdministracion frmPerfilAdministracion = new FrmPerfilAdministracion();
        frmPerfilAdministracion.setVisible(true);
    }//GEN-LAST:event_mniPerfilesActionPerformed

    private void mniUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniUsuariosActionPerformed
        // TODO add your handling code here:
        FrmUsuarioAdministracion frmUsuarioAdministracion = new FrmUsuarioAdministracion();
        frmUsuarioAdministracion.setVisible(true);
            
    }//GEN-LAST:event_mniUsuariosActionPerformed


    private void mnCentrosExpendioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCentrosExpendioActionPerformed
        // TODO add your handling code here:
        FrmCentroExpendioAdministracion frmcentroexpendio = new FrmCentroExpendioAdministracion();
        frmcentroexpendio.setVisible(true);
        
    }//GEN-LAST:event_mnCentrosExpendioActionPerformed
    private void mniEmpleadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniEmpleadorActionPerformed
        FrmEmpleadoAdministracion frmEmpleadoAdministracion = new FrmEmpleadoAdministracion(
        this.empleadoLogueado,this.proveedorEmpleadoLogueado);
        frmEmpleadoAdministracion.setVisible(true);
    }//GEN-LAST:event_mniEmpleadorActionPerformed

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
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barPrincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblEmpresa;
    private javax.swing.JLabel lblKodice;
    private javax.swing.JLabel lblNombreUsuarario;
    private javax.swing.JLabel lblPerfil;
    private javax.swing.JLabel lblPoweredBy;
    private javax.swing.JLabel lblTituloEmpresa;
    private javax.swing.JLabel lblTituloNombreUsuario;
    private javax.swing.JLabel lblTituloPerfil;
    private javax.swing.JMenuItem mnCentrosExpendio;
    private javax.swing.JMenuItem mniPerfiles;
    private javax.swing.JMenuItem mniProveedores;
    private javax.swing.JMenuItem mniUsuarios;
    private javax.swing.JMenu mnuAdministracion;
    private javax.swing.JMenu mnuTomaFisica;
    private javax.swing.JPanel pnlPie;
    // End of variables declaration//GEN-END:variables
}
